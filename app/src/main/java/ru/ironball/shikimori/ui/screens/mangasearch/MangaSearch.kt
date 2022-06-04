package ru.ironball.shikimori.ui.screens.mangasearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.common.search.MangaGridItem
import ru.ironball.shikimori.ui.common.search.Search

@Composable
fun MangaSearch(
    viewModel: MangaSearchViewModel,
    openMangaDetails: (Long) -> Unit,
    navigateUp: () -> Unit,
) {
    val mangaPaging = viewModel.pagedMangaList.collectAsLazyPagingItems()
    val searchValue by viewModel.query.collectAsState(initial = "")

    Column {
        Box(Modifier.weight(1f)) {
            Search(
                title = stringResource(id = R.string.title_manga),
                paging = mangaPaging,
                searchValue = searchValue,
                onSearchValueChange = { viewModel.search(it) },
                onNavigateUp = navigateUp,
                openFiltersScreen = { },
                itemContent = {
                    MangaGridItem(
                        manga = it,
                        onClick = { manga -> openMangaDetails(manga.id) }
                    )
                }
            )
        }
    }
}