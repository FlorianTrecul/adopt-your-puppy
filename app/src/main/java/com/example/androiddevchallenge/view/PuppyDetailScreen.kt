/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.components.GenderIconTag
import com.example.androiddevchallenge.data.PuppyFactory
import dev.chrisbanes.accompanist.coil.CoilImage

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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            val puppy = PuppyFactory.puppyList[puppyId]
            CoilImage(
                data = puppy.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                alignment = Alignment.CenterStart,
                contentDescription = puppy.name,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically),
                ) {
                    Text(
                        text = puppy.name,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h1
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${puppy.age} months",
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = puppy.race,
                        style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    GenderIconTag(puppy.gender)
                }
            }
            Text(
                text = "About Me",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontWeight = FontWeight.W700,
                style = MaterialTheme.typography.h2
            )
            Text(
                text = puppy.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = Color.White
                )
            ) {
                Text("Adopt me !")
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}



