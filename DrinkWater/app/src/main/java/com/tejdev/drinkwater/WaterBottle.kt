package com.tejdev.drinkwater

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WaterBottele(
    modifier: Modifier = Modifier,
    totalWaterAmount:Int,
    unit: String,
    usedWaterAmount: Int,
    waterColor: androidx.compose.ui.graphics.Color = Color(0xff279eff),
    bottleColor: androidx.compose.ui.graphics.Color = Color.White,
    capColor: androidx.compose.ui.graphics.Color = Color(0xff0065b9)

) {

    val waterPercentage = animateFloatAsState(
        targetValue = usedWaterAmount.toFloat()/totalWaterAmount,
        label = "Water",
        animationSpec = tween(durationMillis = 1000)
    ).value

    Box(modifier = modifier
        .width(200.dp)
        .height(600.dp))
    {
        Canvas(modifier = Modifier.fillMaxSize()){
            val width = size.width
            val height = size.height
            val capWidth = size.width *0.55f
            val capHeight = size.height*0.13f

            val bottleBodyPath = Path().apply {
                moveTo(
                    x = width*0.3f, y = height * 0.1f
                )
                lineTo(
                    x = width*0.3f, y = height*0.2f
                )
                quadraticBezierTo(
                    x1 = 0f, y1 = height*0.3f,
                    x2 = 0f, y2 = height*0.4f
                )
                lineTo(
                    x= 0f, y = height*0.95f
                )
                quadraticBezierTo(
                    x1 = 0f, y1 = height,
                    x2 = width* 0.05f , y2 = height
                )
                lineTo(
                    x= width*0.95f,
                    y = height
                )
                quadraticBezierTo(
                    x1 = width, y1 = height,
                    x2 = width , y2 = height *0.95f
                )
                lineTo(
                    x = width,
                    y = height*0.4f
                )
                quadraticBezierTo(
                    x1 = width , y1 = height*0.3f,
                    x2 = width*0.7f, y2 = height*0.2f
                )
                lineTo(
                    x = width*0.7f,
                    y = height *0.1f
                )
                close()
            }
            clipPath(bottleBodyPath){
                drawRect(color = bottleColor,
                size = size,
                    )
                val  waterWavesYposotion = (1-waterPercentage) * size.height
                val waterPath = Path().apply {
                    moveTo(
                        x = 0f,
                        y = waterWavesYposotion
                    )
                    lineTo(
                        x =size.width,
                        y = waterWavesYposotion
                    )
                    lineTo(
                        x = size.width,
                        y = size.height
                    )
                    lineTo(
                        x=  0f,
                        y = size.height
                    )
                    close()
                }
                drawPath(
                    path =  waterPath,
                    color = waterColor
                )
            }
            drawRoundRect(
                color = capColor,
                size = Size(capWidth, capHeight),
                topLeft = Offset(size.width/2 - capWidth /2f, 0f),
                cornerRadius = CornerRadius(45f, 45f  )
            )

        }
    }
}