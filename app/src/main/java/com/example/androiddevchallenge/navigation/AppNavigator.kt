package com.example.androiddevchallenge.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.components.PuppiesList
import com.example.androiddevchallenge.components.PuppyDetail
import com.example.androiddevchallenge.data.PuppyFactory

@ExperimentalFoundationApi
@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "puppyHome") {
        composable("puppyHome") {
            PuppiesList(navController, PuppyFactory.puppyList)
        }
        composable(
            "puppyDetail/{puppyId}",
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) {backStackEntry ->
            PuppyDetail(navController, backStackEntry.arguments?.getInt("puppyId") ?: 0)
        }
    }
}