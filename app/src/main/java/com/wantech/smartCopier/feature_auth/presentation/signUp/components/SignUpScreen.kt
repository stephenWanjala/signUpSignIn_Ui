package com.wantech.smartCopier.feature_auth.presentation.signUp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wantech.smartCopier.feature_auth.presentation.login.components.TextInPutSection

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SigUpScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background
            ) {
                Text(
                    text = "Create  Account",
                    style = MaterialTheme.typography.h6,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                        .padding(start = 32.dp, bottom = 16.dp, end = 32.dp)
                )

            }
        }, scaffoldState = scaffoldState){

    }
        TextInPutSection(buttonLabel = "Sign Up",{}) {

        }




}




