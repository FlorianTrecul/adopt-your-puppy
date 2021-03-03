package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.navigation.AppNavigator

@Composable
fun PuppyHomeScreen(navController: NavController, puppiesList: List<Puppy>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Adopt Your Puppy") },
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        },
        content = { PuppiesList(navController, puppiesList) },
    )

}

@Composable
fun PuppiesList(navController: NavController, puppiesList: List<Puppy>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn(content = {
            items(puppiesList) {
                puppiesList.forEach { puppy ->
                    PuppyCard(
                        puppy = puppy,
                        onPuppyClicked = { navController.navigate("puppyDetail/${puppy.id}") }
                    )
                }
            }
        })
    }
}