package com.demo.productmanageemntsystemii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.productmanageemntsystemii.ui.screens.AddProductScreen
import com.demo.productmanageemntsystemii.ui.screens.HomeScreen
import com.demo.productmanageemntsystemii.ui.screens.UpdateProductScreen
import com.demo.productmanageemntsystemii.ui.theme.ProductManageemntSystemIITheme
import com.demo.productmanageemntsystemii.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductManageemntSystemIITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            val onClickItem = { navController.navigate("add") }
                            HomeScreen(viewmodel = viewModel, navController = navController)
                        }
                        composable("add") {
                            AddProductScreen(viewModel = viewModel, navController = navController)
                        }
                        composable("edit") {
                            UpdateProductScreen(
                                viewModel = viewModel,
                                navController = navController
                            )

                        }
                    }
                }
            }
        }
    }
}