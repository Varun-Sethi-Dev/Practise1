package redo_practise.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import redo_practise.screens.add.AddScreen
import redo_practise.screens.edit.EditScreen
import redo_practise.screens.home.HomeScreen
import redo_practise.screens.list.ListScreen
import redo_practise.screens.utils.Screens

@Composable
fun NavigationManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeScreen(
                navigateToListScreen = { navController.navigate(Screens.List.route) },
                navigateToAddScreen = { navController.navigate(Screens.Add.route) }) {
            }
        }
        composable(Screens.Add.route) {
            AddScreen()
        }
        composable("${Screens.Edit.route}/{noteId}", arguments = listOf(navArgument("noteId") {
            type = NavType.IntType
        })) {
            val noteID = it.arguments?.getInt("noteId")
            EditScreen(noteId = noteID)
        }
        composable(Screens.List.route) {
            ListScreen(navigateToEditScreen = {
                navController.navigate("${Screens.Edit.route}/$it")
            })
        }
    }
}