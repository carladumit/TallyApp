package com.carladumit.tallyapp

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.carladumit.tallyapp.screens.LoginScreen
import com.carladumit.tallyapp.screens.RegisterScreen

private enum class AppScreen {
    LOGIN,
    REGISTER
}

@Composable
fun App() {
    var currentScreen by remember {
        mutableStateOf(AppScreen.LOGIN)
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            when (currentScreen) {
                AppScreen.LOGIN -> {
                    LoginScreen(
                        onNavigateToRegister = {
                            currentScreen = AppScreen.REGISTER
                        }
                    )
                }

                AppScreen.REGISTER -> {
                    RegisterScreen(
                        onNavigateToLogin = {
                            currentScreen = AppScreen.LOGIN
                        }
                    )
                }
            }
        }
    }
}
