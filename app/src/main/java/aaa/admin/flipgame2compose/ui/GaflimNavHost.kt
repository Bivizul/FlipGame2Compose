package aaa.admin.flipgame2compose.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Gaflimash : Screen("gaflimash")
    object Gaflimame : Screen("gaflimame")
}

@Composable
fun GaflimNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Gaflimash.route
) {
    val gamlimact = LocalContext.current as Activity
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Gaflimash.route) { backStackEntry ->
            GaflimashScreen(navController = navController)
//            backStackEntry.c

        }
        composable(Screen.Gaflimame.route) {
            Gaflimame()
            BackHandler() {
                gamlimact.finish()
            }
        }
    }
}
