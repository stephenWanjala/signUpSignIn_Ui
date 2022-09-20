package com.wantech.smartCopier.feature_auth.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background
            ) {
                Text(
                    text = "Login Account",
                    style = MaterialTheme.typography.h6,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                        .padding(start = 32.dp, bottom = 16.dp, end = 32.dp)
                )

            }
        }, scaffoldState = scaffoldState
    ) {

    }
    TextInPutSection(buttonLabel = "Sign In",
        {}) {

    }


}




