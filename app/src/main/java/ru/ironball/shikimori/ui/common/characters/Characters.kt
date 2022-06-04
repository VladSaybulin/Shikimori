package ru.ironball.shikimori.ui.common.characters

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.person.Person
import ru.ironball.shikimori.ui.common.search.PersonGridItem
import ru.ironball.shikimori.ui.components.Block
import ru.ironball.shikimori.ui.components.Grid

@Composable
fun CharactersScreen(viewState: CharactersViewState, onRefresh: () -> Unit, onNavigateUp: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Герои") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            when (val state = viewState) {
                CharactersViewState.Loading -> Loading()
                CharactersViewState.Error -> LoadingError(onRetry = onRefresh)
                is CharactersViewState.Show -> Show(state.main, state.minor)
            }
        }
    }
}

@Composable
private fun Show(main: List<Person>, minor: List<Person>) {
    Column(
        Modifier
            .verticalScroll(state = rememberScrollState())
            .padding(16.dp)) {
        CharacterBlock(
            title = stringResource(id = R.string.block_title_main_characters),
            characters = main
        )
        CharacterBlock(
            title = stringResource(id = R.string.block_title_minor_characters),
            characters = minor
        )
    }
}

@Composable
private fun CharacterBlock(
    title: String,
    characters: List<Person>,
) {
    Block(title = title) { paddingValues ->
        BoxWithConstraints(modifier = Modifier.padding(paddingValues)) {
            val columns = when {
                maxWidth < 480.dp -> 3
                maxWidth < 840.dp -> 5
                else -> 6
            }
            Grid(items = characters, columns = columns) { character ->
                PersonGridItem(person = character)
            }
        }
    }
}

@Composable
private fun Loading() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun LoadingError(onRetry: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.error_loading),
            style = MaterialTheme.typography.subtitle1
        )

        Button(onClick = onRetry) {
            Text(text = stringResource(id = R.string.action_retry))
        }
    }
}