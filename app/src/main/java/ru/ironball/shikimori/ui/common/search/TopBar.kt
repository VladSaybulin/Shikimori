package ru.ironball.shikimori.ui.common.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.theme.ShikimoriTheme

@Composable
fun SearchTopBar(
    title: String,
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    openFilters: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    Surface(
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier.height(56.dp)
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(4.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.content_description_navigate_up)
                )
            }
            Box(Modifier.padding(4.dp)) {
                SearchTextField(
                    searchValue = searchValue,
                    onSearchValueChange = onSearchValueChange,
                    openFilters = openFilters,
                    placeholderText = title,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopBarWithEmptySearchPreview() {
    ShikimoriTheme {
        SearchTopBar(
            title = "Title",
            searchValue = "",
            onSearchValueChange = { },
            onNavigateUp = { },
            openFilters = { },
        )
    }
}

@Preview
@Composable
private fun TopBarWithNotEmptySearchPreview() {
    ShikimoriTheme {
        SearchTopBar(
            title = "Title",
            searchValue = "Наруто",
            onSearchValueChange = { },
            onNavigateUp = { },
            openFilters = { },
        )
    }
}