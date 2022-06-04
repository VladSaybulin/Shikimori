package ru.ironball.shikimori.ui.common.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.components.gridItems

@Composable
fun <T : Any> Search(
    title: String,
    paging: LazyPagingItems<T>,
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    openFiltersScreen: () -> Unit,
    onNavigateUp: () -> Unit,
    itemContent: @Composable (T) -> Unit,
) {
    Scaffold(
        topBar = {
            SearchTopBar(
                title = title,
                searchValue = searchValue,
                onSearchValueChange = onSearchValueChange,
                openFilters = openFiltersScreen,
                onNavigateUp = onNavigateUp
            )
        }
    ) {
        Box(Modifier.padding(it)) {
            when (paging.loadState.refresh) {
                LoadState.Loading -> Refreshing()
                is LoadState.Error -> RefreshError {
                    paging.retry()
                }
                is LoadState.NotLoading -> {
                    if (paging.itemCount == 0) {
                        EmptyList()
                    } else {
                        Showing(
                            paging = paging,
                            itemContent = itemContent
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Refreshing() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun RefreshError(onRetry: () -> Unit) {
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

@Composable
private fun <T : Any> Showing(
    paging: LazyPagingItems<T>,
    itemContent: @Composable (T) -> Unit,
) {

    BoxWithConstraints(Modifier.fillMaxSize()) {

        val columns = when {
            maxWidth < 480.dp -> 2
            maxWidth < 840.dp -> 4
            else -> 6
        }

        LazyColumn(Modifier.fillMaxSize()) {
            gridItems(paging.itemCount, columns = columns) { index ->
                val item = paging[index]
                if (item != null) {
                    itemContent(item)
                } else {
                    // TODO placeholder
                }
            }

            if (paging.loadState.append == LoadState.Loading) {
                item {
                    AppendingItem()
                }
            } else if (paging.loadState.append is LoadState.Error) {
                item {
                    AppendingErrorItem { paging.retry() }
                }
            }
        }
    }
}

@Composable
private fun EmptyList() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.empty_search_result),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun AppendingItem() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(4.dp), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun AppendingErrorItem(onRetry: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.error_loading),
            style = MaterialTheme.typography.subtitle1
        )
        TextButton(onClick = onRetry) {
            Text(text = stringResource(id = R.string.action_retry))
        }
    }
}