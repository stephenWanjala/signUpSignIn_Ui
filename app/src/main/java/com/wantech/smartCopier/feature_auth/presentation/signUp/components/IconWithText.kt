package com.wantech.smartCopier.feature_auth.presentation.signUp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun IConWithText(
    modifier: Modifier,
    onClick: () -> Unit,
    icon: ImageVector = Icons.Default.ArrowBack,
    text: String = "Create Account"
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            ,
//            .align(Alignment.TopCenter),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onClick,
        modifier = Modifier
            .padding(bottom = 8.dp)
            .align(Alignment.CenterVertically)) {
            Icon(imageVector = icon, contentDescription = "Back",
            modifier = Modifier.align(Alignment.Top))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(start = 32.dp, bottom = 16.dp, end = 32.dp)
        )

    }
}
