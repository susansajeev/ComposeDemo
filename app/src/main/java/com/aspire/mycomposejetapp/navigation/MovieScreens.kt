package com.aspire.mycomposejetapp.navigation

enum class MovieScreens{
    JetTipScreen,
    MoviewScreen,
    DetailScreen,
    LoginScreen;
    companion object{
        fun fromRoute(route: String?): MovieScreens
        = when(route?.substringBefore("/")){
            LoginScreen.name -> LoginScreen
            JetTipScreen.name -> JetTipScreen
            DetailScreen.name -> DetailScreen
            null -> LoginScreen
            else -> throw IllegalArgumentException("Route $route not found")
        }
    }

}