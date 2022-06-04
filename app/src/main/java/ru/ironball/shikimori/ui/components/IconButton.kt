package ru.ironball.shikimori.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun ShikimoriIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit
) {
    Box(
        modifier
            .clickable(
                onClick = onClick,
                role = Role.Button,
                indication = rememberRipple(bounded = false, radius = 24.dp),
                interactionSource = remember { MutableInteractionSource() },
            ),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}