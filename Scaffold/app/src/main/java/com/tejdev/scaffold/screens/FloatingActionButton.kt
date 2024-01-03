package com.tejdev.scaffold.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun ActionButton() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                    bottomEnd = 30.dp,
                    bottomStart = 2.dp
                ),
                onClick = { /*todo*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ){
        inner->BoxM(innerPadding = inner)
    }
}

@Composable
fun BoxM(innerPadding: PaddingValues){
    Box(
        Modifier.fillMaxSize(), Alignment.Center,
    ) {
        Text(
            text = "Hello",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
