package com.wantech.smartCopier.feature_auth.presentation.forgotPassword.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wantech.smartCopier.feature_auth.presentation.signUp.components.IConWithText
import com.wantech.smartCopier.feature_auth.presentation.util.Screen

@Composable
fun ForgotPasswordScreen(navController: NavController) {
 Box(modifier = Modifier.fillMaxSize(),
 contentAlignment = Alignment.Center){
     IConWithText(
         modifier = Modifier.align(Alignment.TopCenter),
         text = "Forgot Password",
         onClick = {
             navController.navigate(Screen.SignIn.route){
                 popUpTo(Screen.SignIn.route)
             }
         })
 }
}