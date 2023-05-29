package com.sample.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sample.appcompose.imagedetail.ImageDetailDestination
import com.sample.appcompose.imagelist.ImageListDestination
import com.sample.appcompose.ui.theme.SpaceRideGalleyTheme
import com.sample.imagefeaturelibrary.imagedetails.view.ImageDetailViewModel
import com.sample.imagefeaturelibrary.imagelist.view.ImageListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceRideGalleyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppScreens.ImageList.screenRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = AppScreens.ImageList.screenRoute) {
            val viewModel: ImageListViewModel = hiltViewModel()
            ImageListDestination(
                onNavigateToDetails = { argString: Int ->
                    navController.navigate(route = AppScreens.ImageDetails.screenRoute + "/$argString")
                }, viewModel = viewModel
            )
        }
        composable(
            route = AppScreens.ImageDetails.screenRoute + "/{imagePosition}",
            arguments = listOf(navArgument("imagePosition") { type = NavType.IntType })
        ) { backStackEntry ->
            val viewModel: ImageDetailViewModel = hiltViewModel()
            ImageDetailDestination(
                viewModel = viewModel,
                selectedPosition = backStackEntry.arguments?.getInt("imagePosition") ?: 0
            )
        }
    }
}

sealed class AppScreens(val screenRoute: String) {
    object ImageList : AppScreens(screenRoute = "imagelist")
    object ImageDetails : AppScreens(screenRoute = "imagedetails")
}
