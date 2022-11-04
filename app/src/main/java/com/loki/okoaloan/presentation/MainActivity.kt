package com.loki.okoaloan.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.loki.okoaloan.presentation.change_password.ChangePasswordScreen
import com.loki.okoaloan.presentation.get_started.GetStartedScreen
import com.loki.okoaloan.presentation.home.HomeScreen
import com.loki.okoaloan.presentation.loan_history.LoanHistoryScreen
import com.loki.okoaloan.presentation.splash_screen.SplashScreen
import com.loki.okoaloan.presentation.ui.theme.OkoaLoanTheme
import com.loki.okoaloan.presentation.welcome_screen.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkoaLoanTheme {
                Box(modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
                    .fillMaxSize()) {
                    Navigation()

                }
            }
        }
    }
}


@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {

        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screens.GetStartedScreen.route) {
            GetStartedScreen(navController = navController)

        }

        composable(route = Screens.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }

        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.LoanHistoryScreen.route) {
            LoanHistoryScreen()
        }

        composable(route = Screens.ChangePasswordScreen.route) {
            ChangePasswordScreen()
        }
    }
}


sealed class Screens(val route: String) {

    object SplashScreen: Screens("splash_screen")
    object GetStartedScreen: Screens("get_started_screen")
    object WelcomeScreen: Screens("welcome_screen")
    object HomeScreen: Screens("home_screen")
    object LoanHistoryScreen: Screens("loan_history_screen")
    object ChangePasswordScreen: Screens("change_password_screen")
}