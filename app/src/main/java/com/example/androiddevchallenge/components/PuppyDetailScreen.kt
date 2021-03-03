package com.example.androiddevchallenge.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PuppyDetailScreen(navController: NavController, puppyId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Puppy") },
                backgroundColor = MaterialTheme.colors.primaryVariant,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .padding(top = 0.dp, start = 8.dp, end = 0.dp, bottom = 0.dp)
                            .clickable {
                                navController.navigateUp()
                            }
                    )
                }
            )
        },
        content = { PuppyDetail(puppyId) },
    )
}

@Composable
fun PuppyDetail(puppyId: Int) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "$puppyId", modifier = Modifier.align(Alignment.Center))
    }
}



