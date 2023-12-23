package com.tejdev.pingpong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.tejdev.pingpong.ui.theme.PingPongTheme
import kotlin.math.max
import kotlin.math.min

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PingPongTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    PongGame()
                }
            }
        }
    }
}

@Composable
fun PongGame() {
    val racketWidthDp = 150f
    val racketHeightDp = 20f
    val ballRadiusDp = 10f
    val density = LocalDensity.current.density

    var racketPosition by remember { mutableFloatStateOf(200f) }
    var ballPosition by remember { mutableStateOf(Offset(100f, 100f)) }
    var ballVelocity by remember { mutableStateOf(Offset(8F, 9f)) }

    LaunchedEffect(key1 = true) {
        while (true) {
            withFrameMillis { _ ->
                ballPosition = ballPosition.copy(
                    x = ballPosition.x + ballVelocity.x,
                    y = ballPosition.y + ballVelocity.y
                )
            }
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {

        // Convert dimensions to pixels
        val racketWidth = racketWidthDp * density
        val racketHeight = racketHeightDp * density
        val ballRadius = ballRadiusDp * density

        // Check for collisions with the window edges
        if (ballPosition.x - ballRadius < 0f || ballPosition.x + ballRadius > size.width) {
            ballVelocity = ballVelocity.copy(x = -ballVelocity.x)
        }
        if (ballPosition.y - ballRadius < 0f || ballPosition.y + ballRadius > size.height) {
            ballVelocity = ballVelocity.copy(y = -ballVelocity.y)
        }

        // Check for collisions with the racket
        if (ballPosition.y + ballRadius >= size.height - racketHeight &&
            ballPosition.x in racketPosition..racketPosition + racketWidth) {
            ballVelocity = ballVelocity.copy(y = -ballVelocity.y)
        }

        // Draw the racket
        drawRect(
            color = Color.Green,
            topLeft = Offset(racketPosition, size.height - racketHeight),
            size = androidx.compose.ui.geometry.Size(racketWidth, racketHeight)
        )

        // Draw the ball
        drawCircle(
            color = Color.Blue,
            center = ballPosition,
            radius = ballRadius
        )

        // Update the racket position to follow the ball
        racketPosition = min(max(ballPosition.x - racketWidth / 2, 0f), size.width - racketWidth)
    }
}