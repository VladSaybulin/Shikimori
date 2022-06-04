package ru.ironball.shikimori.ui.screens.animesearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.common.search.AnimeGridItem
import ru.ironball.shikimori.ui.common.search.Search

@Composable
fun AnimeSearch(
    viewModel: AnimeSearchViewModel,
    openAnimeDetails: (Long) -> Unit,
    navigateUp: () -> Unit,
) {

    val animePaging = viewModel.pagedAnimeList.collectAsLazyPagingItems()

    val searchValue by viewModel.query.collectAsState(initial = "")

    Column {
        Box(Modifier.weight(1f)) {
            Search(
                title = stringResource(id = R.string.title_anime),
                paging = animePaging,
                searchValue = searchValue,
                onSearchValueChange = { viewModel.search(it) },
                onNavigateUp = navigateUp,
                openFiltersScreen = { },
                itemContent = {
                    AnimeGridItem(
                        anime = it,
                        onClick = { anime -> openAnimeDetails(anime.id) }
                    )
                }
            )
        }
    }
}
