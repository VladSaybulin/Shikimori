package ru.ironball.shikimori.ui.common.details.blocks

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.components.Block

@Composable
fun DescriptionBlock(description: String?) {
    Block(title = stringResource(id = R.string.block_title_description)) {
        Column(modifier = Modifier.padding(it).animateContentSize()) {
            if (description != null) {
                Text(text = description)
            } else {
                Text(text = stringResource(id = R.string.no_description), textAlign = TextAlign.Center)
            }
        }
    }
}