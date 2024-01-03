package com.tejdev.drinkwater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tejdev.drinkwater.ui.theme.DrinkWaterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrinkWaterTheme {
                Surface(
                    modifier =  Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    var usedAmount by remember {
                        mutableStateOf(400)
                    }
                    var totalWaterAmount by remember {
                        mutableStateOf(2400)
                    }

                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement =  Arrangement.Center
                        ){
                        WaterBottele(totalWaterAmount = totalWaterAmount, unit ="" , usedWaterAmount = usedAmount, modifier = Modifier.width(250.dp))
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount is : $totalWaterAmount")
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(onClick = { usedAmount += 200},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                        ) {
                            TextWithSize(label = "Drink", size = 25.sp)
                            
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun TextWithSize(label:String, size: TextUnit){
    Text(text = label, fontSize = size, color = Color.White)
}