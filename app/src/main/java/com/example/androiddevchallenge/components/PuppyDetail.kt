package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun PuppyDetail(navController: NavController, puppyId: Int) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "$puppyId", modifier = Modifier.align(Alignment.Center))
    }
}


