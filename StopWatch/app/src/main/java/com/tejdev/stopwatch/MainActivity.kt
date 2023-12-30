package com.tejdev.stopwatch

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tejdev.stopwatch.ui.theme.StopWatchTheme
import kotlinx.coroutines.delay
import java.sql.Time
import java.time.format.TextStyle
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchCard()
        }
    }
}


@Preview
@Composable
fun WatchCard() {
    Card(elevation = CardDefaults.cardElevation(defaultElevation=10.dp),
        border = BorderStroke(2.dp, Color.Gray),
        modifier = Modifier.padding(20.dp))
    {
        Stopwatch()
    }
}



@Composable
fun Stopwatch() {
    var running by remember { mutableStateOf(false) }
    var startTime by remember { mutableStateOf(0L) }

    val elapsedTime = remember { mutableStateOf(0L) }

    LaunchedEffect(Unit) {
        while (true) {
            if (running) {
                startTime = System.currentTimeMillis() - elapsedTime.value
            }
            elapsedTime.value = System.currentTimeMillis() - startTime
            delay(1000)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatTime(elapsedTime.value),
            fontSize = 40.sp
        )

        Row(
            modifier = Modifier.padding(top = 1.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    running = !running
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = if (running) "Pause" else "Start")
            }

            Button(
                onClick = {
                    running = false
                    elapsedTime.value = 0
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset")
            }
        }
    }
}

 fun formatTime(timeInMillis: Long): String {
    val seconds = (timeInMillis / 1000) % 60
    val minutes = (timeInMillis / (1000 * 60)) % 60
    val hours = (timeInMillis / (1000 * 60 * 60)) % 24

    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

//@Preview
//@Composable
//fun CardWithBorder() {
//    val paddingModifier = Modifier.padding(10.dp)
//    Card(
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp),
//        border = BorderStroke(3.dp, Color.Blue),
//        modifier = paddingModifier
//    ) {
//        Column(Modifier.padding(10.dp)) {
//            Button(onClick = {  },
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
//                Text(text = "Button Column 1", color= Color.Magenta)
//            }
//        }
//        Row( Modifier.padding(10.dp)) {
//            Text(text = "Row 1",
//                modifier = paddingModifier,
//                color = Color.Blue,)
//            Text(text = "Row 2",
//                modifier = paddingModifier,
//                color = Color.Blue,
//                fontWeight = FontWeight.Bold,
//                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
//           )
//            Text(text = "Row 3",
//                modifier = paddingModifier,
//                color = Color.Blue,)
//            Row(Modifier.padding(10.dp)) {
//                Button(onClick = { },
//                    shape = RectangleShape,
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
//                    Image(
//                        painterResource(id = androidx.core.R.drawable.ic_call_answer),
//                        contentDescription ="Cart button icon",
//                        modifier = Modifier.size(20.dp))
//
//                    Text(text = " Row ", color = Color.Gray)
//                    Text(text = "Button" ,color =Color.Blue )
//
//                }
//            }
//        }
//
//        Button(onClick = {
//            //your onclick code here
//        },
//            modifier = Modifier.padding(10.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Black))
//        {
//            Text(text = "Button 1", color = Color.Gray)
//        }
//
//        //button 2
//        Button(onClick = {
//            //your onclick code here
//        },
//            modifier = Modifier.padding(10.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Black))
//        {
//            Text(text = "Button  2", color = Color.Gray)
//        }
//
//        Image(painter = painterResource(id = R.drawable.img), contentDescription = "image",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .padding(20.dp)
//                .size(128.dp)
//                .clip(CircleShape) // clip to the circle shape
//                .border(2.dp, Color.Gray, CircleShape)
//                .padding(2.dp))
//        var text by remember {
//            mutableStateOf(TextFieldValue(""))
//        }
//        OutlinedTextField(
//            modifier = Modifier.padding(10.dp),
//            value = text,
//            label = { Text(text = "Enter Your Name") },
//            onValueChange = {
//                text = it
//            }
//        )
//
//        var clickCount = 0
//        Column {
//            Button(onClick = {
//                clickCount++
//                Log.d("TAG", "NoState: "+clickCount)
//            }) {
//                Text(text = ""+clickCount+" times clicked")
//            }
//        }
//        //Simple List
//        val countryList =
//            mutableListOf("India", "Pakistan", "China", "United States")
//
//        val listModifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(15.dp)
//
//        val textStyle =
//            androidx.compose.ui.text.TextStyle(fontSize = 20.sp, color = Color.Blue)
//
//        LazyColumn(modifier = listModifier) {
//            this.items(countryList) { country ->
//                Text(text = country, style = textStyle)
//            }
//        }
//    }
//
//}

