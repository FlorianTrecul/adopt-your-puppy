package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun GenderIconTag(name: String) {
    val color = if (name == "Male") R.color.blue else R.color.red
    ChipGender(gender = name, colorResource = colorResource(id = color))
}

@Composable
fun ChipGender(gender: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
            .padding(4.dp)
    ) {
        Row {
            if (gender == "Male") {
                Icon(
                    Icons.Filled.Male, "",
                    tint = colorResource
                )
            } else {
                Icon(
                    Icons.Filled.Female, "",
                    tint = colorResource
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = gender,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                color = colorResource,
                style = MaterialTheme.typography.caption
            )
        }
    }
}