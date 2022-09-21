package com.wantech.smartCopier.feature_auth.presentation.util

sealed class Screen(val route: String) {
    object SigUp : Screen("sign_up_screen")
    object SignIn : Screen("sign_in_screen")
    object Home : Screen(route = "home_screen")
    object ForgotPassword: Screen(route = "reset_password_screen")
}