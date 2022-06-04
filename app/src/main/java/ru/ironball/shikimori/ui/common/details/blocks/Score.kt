package ru.ironball.shikimori.ui.common.details.blocks

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.components.Block

@Composable
fun ScoreBlock(score: Float) {
    Block(title = stringResource(id = R.string.block_title_score)) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = score.toString(), style = MaterialTheme.typography.h4)
            Text(
                text = stringResource(
                    id = when {
                        score > 9 -> R.string.score_fabulous
                        score > 8 -> R.string.score_great
                        score > 7 -> R.string.score_good
                        score > 6 -> R.string.score_normal
                        score > 5 -> R.string.score_more_or_less
                        score > 4 -> R.string.score_bad
                        score > 3 -> R.string.score_very_bad
                        else -> R.string.score_worse_than_ever
                    }
                )
            )
        }
    }
}