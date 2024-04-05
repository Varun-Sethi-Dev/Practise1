package redo_practise.screens.utils

sealed class Screens(val route: String) {
    data object Home : Screens(route = "homeScreen")
    data object List : Screens(route = "listScreen")
    data object Edit : Screens(route = "editScreen")
    data object Add : Screens(route = "addScreen")
}