package com.example.practise1.navigationManager

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practise1.screen.AddScreen
import com.example.practise1.screen.Button
import com.example.practise1.screen.EditScreen
import com.example.practise1.screen.HomeScreen
import com.example.practise1.screen.ListScreen
import dagger.hilt.android.AndroidEntryPoint

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home")
    data object List : Screen(route = "list")
    data object Edit : Screen(route = "edit")
    data object Add : Screen(route = "create")
}

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen() { whichButton ->
                when (whichButton) {
                    Button.Add -> {
                        navController.navigate(Screen.Add.route)
                    }

                    Button.Edit -> {
                        navController.navigate(Screen.Edit.route)
                    }

                    Button.Read -> {
                        navController.navigate(Screen.List.route)
                    }
                }

            }
        }
        composable(route = Screen.List.route) {
            ListScreen()
        }
        composable(route = Screen.Edit.route) {
            EditScreen()
        }
        composable(route = Screen.Add.route) {
            AddScreen()
        }

    }
}