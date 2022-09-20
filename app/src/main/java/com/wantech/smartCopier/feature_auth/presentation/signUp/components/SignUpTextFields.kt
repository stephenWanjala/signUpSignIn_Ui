package com.wantech.smartCopier.feature_auth.presentation.signUp.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.wantech.smartCopier.R
import com.wantech.smartCopier.feature_auth.presentation.login.components.AButton
import com.wantech.smartCopier.feature_auth.presentation.login.components.InputTextField

@Composable

fun SignUpTextFields(
    buttonLabel: String,
    onClickLoginButton: () -> Unit,
    onClickToSignUp:()->Unit
) {
    var emailFieldState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        InputTextField(
            textValue = emailFieldState,
            labelText = "Email",
            tittle = "Example@gmail.com",
            trailingIcon = Icons.Default.Email,
            onValueChange = { emailFieldState = it },
            first = true
        )
        InputTextField(
            textValue = passwordState,
            labelText = "Email",
            tittle = "Example@gmail.com",
            trailingIconResource = R.drawable.ic_eye,
            onValueChange = { passwordState = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
            )
        )

        AButton(
            text = buttonLabel,
            onClick = onClickLoginButton,
            modifier = Modifier
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text ="Don't Have an Account?",
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.ExtraLight
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "SignUp",
                modifier = Modifier.clickable { onClickToSignUp },
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.ExtraBold
            )

        }
    }
}