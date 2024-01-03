package com.tejdev.scaffold.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyScreenContent() {
    Column {
        // Your screen content goes here
        Text(text = "Hello, Jetpack Compose!", color = Color.Black)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldExample() {
    Scaffold(
        topBar = {
            // Custom app bar or toolbar
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,),
                title = { Text(text = "My App", color = Color.Blue)})
        },
        content = {
            // Main content area
            MyScreenContent()
        },
        floatingActionButton = {
            // Floating Action Button
            FloatingActionButton(onClick = { /* Handle FAB click */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        bottomBar = {
            // Bottom navigation or bar
            BottomAppBar( ) {
                Text(text = "Bottom bar")
                // BottomAppBar content goes here
            }
        },
//        drawerContent = {
//            // Drawer content
//            // Navigation links or additional options
//        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun MyScaffoldExamplePreview() {
    MyScaffoldExample()
}
