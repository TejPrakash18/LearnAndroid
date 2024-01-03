package com.tejdev.scaffold.screens

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.selects.select

@Preview
@Composable
fun BottomBar() {
    var bottomState  by remember {
        mutableStateOf("Home")
    }
Scaffold (
    bottomBar = {
        BottomNavigation() {
            BottomNavigationItem(select<> {  })

        }
    }
){
}

}