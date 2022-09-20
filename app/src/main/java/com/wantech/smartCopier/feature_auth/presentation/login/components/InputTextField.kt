package com.wantech.smartCopier.feature_auth.presentation.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    textValue: String,
    labelText: String,
    maxLines: Int = 1,
    first:Boolean=false,
    singleLine: Boolean = true,
    tittle: String = "",
    trailingIconResource: Int? = null,
    trailingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Email
    )
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val keyBoardController =LocalSoftwareKeyboardController.current
        OutlinedTextField(
            value = textValue,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
//            label = TextFieldLabel(string = labelText),
            trailingIcon = {
               AddIcon(
                    trailingIcon = trailingIcon,
                    trailingIconResource
                )
            },
//            label = {TextFieldLabel(string = labelText)}
            placeholder = {
                TextFieldLabel(
                    string = tittle
                )
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    keyBoardController?.hide()
                }
            )


        )

    }

}

@Composable
fun TextFieldLabel(string: String) {
    Text(text = string)
}

@Composable
fun AddIcon(trailingIcon: ImageVector?, trailingIconResource: Int?) {
    if (trailingIcon != null) Icon(
        imageVector = trailingIcon,
        contentDescription = null
    ) else if (trailingIconResource != null) {
        Icon(painter = painterResource(id = trailingIconResource), contentDescription = null)
    } else null


}