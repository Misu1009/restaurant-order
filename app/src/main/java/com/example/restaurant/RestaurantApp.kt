package com.example.restaurant

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurant.ui.RestaurantViewModel
import com.example.restaurant.ui.screen.AccompanimentScreen
import com.example.restaurant.ui.screen.CheckOutScreen
import com.example.restaurant.ui.screen.EntreeScreen
import com.example.restaurant.ui.screen.SideDishScreen
import com.example.restaurant.ui.screen.StartScreen

@Composable
fun RestaurantApp(){
    var navController = rememberNavController()
    var viewModel: RestaurantViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "StartScreen"
    ){
        composable(route = "StartScreen"){
            StartScreen(){
                viewModel.removeAllList()
                navController.navigate("EntreeScreen")
            }
        }
        composable(route = "EntreeScreen"){
            EntreeScreen(
                onCancelButton = {
                    viewModel.removeEntreeList()
                    navController.navigate("StartScreen")
                },
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(route = "SideDishScreen"){
            SideDishScreen(
                onCancelButton = {
                    viewModel.removeEntreeList()
                    viewModel.removeSideDishList()
                    navController.navigate("EntreeScreen")
                },
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(route = "AccompanimentScreen"){
            AccompanimentScreen(
                onCancelButton = {
                    viewModel.removeSideDishList()
                    viewModel.removeAccompanimentList()
                    navController.navigate("SideDishScreen")
                 },
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(route = "CheckOutScreen"){
            CheckOutScreen(
                onCancelButton = {
                    viewModel.removeAccompanimentList()
                    navController.navigate("AccompanimentScreen")
                },
                viewModel=viewModel,
                onSUbmitButton = { navController.navigate("StartScreen")}
            )
        }
    }
}