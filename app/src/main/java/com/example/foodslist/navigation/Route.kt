package com.example.foodslist.navigation

sealed class Route(val route: String) {
    object Home : Route("home")
    object Favorite : Route("favorite")
    object About : Route("about")
    object Detail : Route("detail/{foodId}"){
        fun createRoute(foodId:Int) = "detail/$foodId"
    }
}