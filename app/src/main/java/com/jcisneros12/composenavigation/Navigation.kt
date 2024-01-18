package com.jcisneros12.composenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jcisneros12.composenavigation.data.findFruit
import com.jcisneros12.composenavigation.data.fruitList
import com.jcisneros12.composenavigation.ui.screen.FruitDetailScreen
import com.jcisneros12.composenavigation.ui.screen.FruitScreen
import com.jcisneros12.composenavigation.ui.screen.MasterScreen


sealed class Screen(val route: String) {
    object MasterScreen: Screen(route = "master")
    object FruitScreen: Screen(route = "fruit_screen")
    object FruitDetailScreen: Screen(route = "fruit_detail_screen")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MasterScreen.route) {
        composable(Screen.MasterScreen.route) {
            MasterScreen(navController)
        }
        composable(Screen.FruitScreen.route) {
            FruitScreen(navController, fruitList)
        }
        composable(Screen.FruitDetailScreen.route + "/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("id")?.toInt()?.let { id ->
                val fruit = findFruit(id)
                FruitDetailScreen(navController, fruit)
            }
        }
    }

}