package com.tejdev.stopwatch

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tejdev.stopwatch.ui.theme.StopWatchTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@Preview
@Composable
fun CardWithBorder() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp),
        border = BorderStroke(3.dp, Color.Blue),
        modifier = paddingModifier
    ) {
        Column() {
            Text(text = "Text with card content color (Blue)",
                color = Color.Blue,
                modifier = paddingModifier)
            Text(text = "Text with card custom color",
                color = Color.Black,
                modifier = paddingModifier)
            Text(text = "Text with card content color (Blue)",
                color = Color.Green,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                ),
                modifier = paddingModifier)
            Text(text = "Text with card custom color",
                color = Color.Red,
                modifier = paddingModifier)

        }
        Row( Modifier.padding(10.dp)) {
            Text(text = "Row 1",
                modifier = paddingModifier,
                color = Color.Blue,)
            Text(text = "Row 2",
                modifier = paddingModifier,
                color = Color.Blue,)
            Text(text = "Row 3",
                modifier = paddingModifier,
                color = Color.Blue,)
            Text(text = "Row 4",
                modifier = paddingModifier,
                color = Color.Blue,)
            Text(text = "Row 5",
                modifier = paddingModifier,
                color = Color.Blue,)
        }
    }
}

