package ru.ironball.shikimori.utils

import java.text.SimpleDateFormat
import java.util.*

private val locale = Locale("ru")

val yearOnlyFormatter = SimpleDateFormat("yyyy", locale)
val monthAndYearFormatter = SimpleDateFormat("MMM yyyy", locale)
val fullFormatter = SimpleDateFormat("d MMM yyyy", locale)