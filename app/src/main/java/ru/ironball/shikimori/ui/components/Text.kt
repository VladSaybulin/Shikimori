package ru.ironball.shikimori.ui.components

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@ExperimentalTextApi //Не нравиться но другого решения пока что не нашёл
@Deprecated("Move Text to box and put size IntrinsicSize.Min") //нашёл
@Composable
fun TextWithLines(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    lines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    var finalText by remember { mutableStateOf(text) }
    var textLayoutResultState by remember { mutableStateOf<TextLayoutResult?>(null) }

    LaunchedEffect(textLayoutResultState) {
        textLayoutResultState?.let {
            if (it.lineCount < 2) {
                finalText = buildString {
                    append(finalText)
                    repeat(lines - it.lineCount) {
                        append("\n")
                    }
                }
            }
        }
    }

    Text(
        text = finalText,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = lines,
        onTextLayout = {
            textLayoutResultState = it
            onTextLayout(it)
        },
        style = style
    )
}

@Composable
fun SimpleValueText(
    title: String,
    value: String,
    valueSpanStyle: SpanStyle = LocalTextStyle.current.toSpanStyle(),
    titleSpanStyle: SpanStyle = valueSpanStyle.copy(color = valueSpanStyle.color.copy(alpha = 0.4f))
) {
    Text(text = buildAnnotatedString {
        withStyle(titleSpanStyle) {
            append(title)
            append(": ")
        }
        withStyle(valueSpanStyle) {
            append(value)
        }
    })
}

@Composable
fun SimpleValueText(
    title: String,
    value: AnnotatedString,
    titleSpanStyle: SpanStyle = LocalTextStyle.current.toSpanStyle(),
    valueSpanStyle: SpanStyle = LocalTextStyle.current.toSpanStyle(),
) {
    Text(text = buildAnnotatedString {
        withStyle(titleSpanStyle) {
            append(title)
            append(": ")
        }
        withStyle(valueSpanStyle) {
            append(value)
        }
    })
}


@Composable
fun ExpandableText() {

}