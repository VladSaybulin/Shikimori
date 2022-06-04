package ru.ironball.shikimori.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Home(
    openAnimeSearch: () -> Unit,
    openMangaSearch: () -> Unit,
    openRanobeSearch: () -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = openAnimeSearch, modifier = Modifier.width(180.dp)) {
            Text("Аниме")
        }

        Button(onClick = openMangaSearch, modifier = Modifier.width(180.dp)) {
            Text("Манга")
        }

        Button(onClick = openRanobeSearch, modifier = Modifier.width(180.dp)) {
            Text("Ранобэ")
        }
    }

}