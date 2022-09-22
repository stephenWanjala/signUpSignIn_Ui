package com.wantech.smartCopier.feature_auth.presentation.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    textValue: String,
    labelText: String,
    maxLines: Int = 1,
    first: Boolean = false,
    singleLine: Boolean = true,
    tittle: String = "",
    trailingIconResource: Int? = null,
    trailingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Email
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onSendAction: (() -> Unit?)? = null

) {
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        val keyBoardController = LocalSoftwareKeyboardController.current
        OutlinedTextField(
            value = textValue,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            label = { Text(text = labelText) },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },

            placeholder = {
                Text(text = labelText)
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    keyBoardController?.hide()
                },
                onSend = {
                    keyBoardController?.hide()
                    onSendAction?.let { it() }
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colors.background,
                unfocusedLabelColor = MaterialTheme.colors.background,
                placeholderColor = MaterialTheme.colors.background,
                leadingIconColor = MaterialTheme.colors.background.copy(alpha = 0.9f),
                trailingIconColor = MaterialTheme.colors.background.copy(alpha = 0.9f)
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(
                '*'
            ),
        )

    }

}

