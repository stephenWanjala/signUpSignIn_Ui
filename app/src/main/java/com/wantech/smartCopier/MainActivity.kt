package com.wantech.smartCopier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wantech.smartCopier.feature_auth.presentation.forgotPassword.components.ForgotPasswordScreen
import com.wantech.smartCopier.feature_auth.presentation.login.components.LoginScreen
import com.wantech.smartCopier.feature_auth.presentation.signUp.components.SigUpScreen
import com.wantech.smartCopier.feature_auth.presentation.util.Screen
import com.wantech.smartCopier.feature_copier.presentation.HomeScreen
import com.wantech.smartCopier.ui.theme.SmartCopierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartCopierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.SignIn.route
                    ) {
                        composable(route = Screen.SignIn.route) {
                            LoginScreen(navController)
                        }
                        composable(route = Screen.SigUp.route) {
                            SigUpScreen(navController = navController)
                        }

                        composable(route = Screen.Home.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(route = Screen.ForgotPassword.route) {
                            ForgotPasswordScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

