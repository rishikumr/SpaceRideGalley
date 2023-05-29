package com.sample.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.appcompose.AppScreens.ImageList.screenRoute
import com.sample.appcompose.imagedetail.ImageDetailDestination
import com.sample.appcompose.imagelist.ImageListDestination
import com.sample.appcompose.ui.theme.SpaceRideGalleyTheme

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
            // val viewModel: ContentLibrarySearchViewModel = hiltViewModel()
            ImageListDestination(
                onNavigateToFriends = { navController.navigate(AppScreens.ImageDetails.screenRoute) }
            )
        }
        composable(route = AppScreens.ImageDetails.screenRoute) { ImageDetailDestination(/*...*/) }
    }
}

sealed class AppScreens(val screenRoute: String) {
    object ImageList : AppScreens(screenRoute = "imagelist")
    object ImageDetails : AppScreens(screenRoute = "imagedetails")
}
