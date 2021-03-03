package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Puppy

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