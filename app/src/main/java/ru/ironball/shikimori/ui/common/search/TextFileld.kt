@file:OptIn(ExperimentalComposeUiApi::class)

package ru.ironball.shikimori.ui.common.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.ui.components.ShikimoriIconButton

@Composable
fun SearchTextField(
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    openFilters: () -> Unit,
    placeholderText: String,
) {

    val textFieldFocusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        color = MaterialTheme.colors.onPrimary,
        contentColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.height(40.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(
                value = searchValue,
                onValueChange = onSearchValueChange,
                textStyle = MaterialTheme.typography.subtitle1,
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(textFieldFocusRequester)
                    .onFocusChanged {
                        if (it.isFocused) {
                            //TODO Keyboard not showed
                            keyboardController?.show()
                        }
                    },
                decorationBox = { innerTextField ->
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.size(40.dp), contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = stringResource(id = R.string.content_description_search),
                            )
                        }
                        Box {
                            if (searchValue.isEmpty()) {
                                Text(
                                    text = placeholderText,
                                    style = MaterialTheme.typography.subtitle1,
                                    modifier = Modifier.alpha(0.7f)
                                )
                            }
                            innerTextField()
                        }
                    }
                }
            )
            //ShikimoriIconButton(
            //    onClick = openFilters,
            //    modifier = Modifier.size(40.dp)
            //) {
            //    Icon(
            //        imageVector = Icons.Filled.FilterList,
            //        contentDescription = stringResource(id = R.string.content_description_filter_list),
            //    )
            //}

            if (searchValue.isNotEmpty()) {
                ShikimoriIconButton(
                    onClick = {
                        textFieldFocusRequester.requestFocus()
                        onSearchValueChange("")
                    },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.content_description_clear),
                    )
                }
            }
        }
    }
}