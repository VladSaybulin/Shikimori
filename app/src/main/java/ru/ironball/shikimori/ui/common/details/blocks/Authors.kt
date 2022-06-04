package ru.ironball.shikimori.ui.common.details.blocks

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.person.PersonWithRoles
import ru.ironball.shikimori.ui.common.ShikimoriImage
import ru.ironball.shikimori.ui.components.Block
import ru.ironball.shikimori.ui.components.SimpleValueText

@Composable
fun AuthorsBlock(mainAuthors: List<PersonWithRoles>, openAuthors: () -> Unit) {
    Block(title = stringResource(id = R.string.block_title_authors), onMore = openAuthors) {
        Column(Modifier.padding(it), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            mainAuthors.forEach { author ->
                AuthorItem(author = author)
            }
        }
    }
}

@Composable
private fun AuthorItem(author: PersonWithRoles) {

    Row {
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

//Cause cutting out the photo
private const val PhotoAspect = 5 / 7f