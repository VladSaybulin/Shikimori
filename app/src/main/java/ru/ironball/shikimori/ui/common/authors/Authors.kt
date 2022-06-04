package ru.ironball.shikimori.ui.common.authors

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.person.PersonWithRoles
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.SimpleValueText

@Composable
fun Authors(
    viewState: AuthorsViewState,
    onRefresh: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Авторы") },
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
                AuthorsViewState.Loading -> Loading()
                AuthorsViewState.Error -> LoadingError(
                    onRetry = onRefresh
                )
                is AuthorsViewState.Show -> Show(state.authors)
            }
        }
    }
}

@Composable
private fun Show(authors: List<PersonWithRoles>) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(authors) { author ->
            AuthorItem(author = author)
        }
    }
}

@Composable
private fun AuthorItem(author: PersonWithRoles) {

    Row(Modifier.padding(8.dp)) {
        Photo(
            imageUrl = author.person.image.original,
            contentDescription = author.person.name,
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .aspectRatio(PhotoAspect)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = author.person.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            SimpleValueText(
                title = stringResource(id = R.string.roles),
                value = author.roles.joinToString(", ")
            )
        }
    }
}

@Composable
private fun Photo(imageUrl: String, contentDescription: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        ShikimoriImage(
            url = imageUrl,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
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

//Cause cutting out the photo
private const val PhotoAspect = 5 / 7f