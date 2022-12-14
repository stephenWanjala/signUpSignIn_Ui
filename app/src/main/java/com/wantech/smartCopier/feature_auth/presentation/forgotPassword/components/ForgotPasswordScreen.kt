package com.wantech.smartCopier.feature_auth.presentation.forgotPassword.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wantech.smartCopier.feature_auth.presentation.login.components.AButton
import com.wantech.smartCopier.feature_auth.presentation.login.components.InputTextField
import com.wantech.smartCopier.feature_auth.presentation.signUp.components.IConWithText
import com.wantech.smartCopier.feature_auth.presentation.util.Screen
import kotlinx.coroutines.launch

@Composable
fun ForgotPasswordScreen(navController: NavController) {
    var emailState by remember {
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            IConWithText(
                modifier = Modifier.align(Alignment.TopCenter),
                text = "Forgot Password",
                onClick = {
                    navController.navigate(Screen.SignIn.route) {
                        popUpTo(Screen.SignIn.route)
                    }
                })

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.Center),
                contentColor = MaterialTheme.colors.surface,
                backgroundColor = MaterialTheme.colors.onBackground,
                shape = RoundedCornerShape(12.dp),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(start = 16.dp, end = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Please Enter your Email, \nyou will receive a link to reset your password via email",
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                    )
                    InputTextField(
                        textValue = emailState,
                        labelText = "Your Email",
                        onValueChange = { email ->
                            emailState = email

                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Send
                        )
                    )

                    AButton(
                        text = "Send",
                        onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Reset Password Email Sent",
                                    actionLabel = "Dismiss",
                                    duration = SnackbarDuration.Long
                                )
                            }
                            emailState = ""
                        },

                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        (emailState.isNotBlank() &&
                                android.util.Patterns.EMAIL_ADDRESS.matcher(emailState).matches()
                                )
                    }
                }
            }
        }

    }
}