package com.tejdev.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tejdev.quotesapp.R
import com.tejdev.quotesapp.models.Quote

@Composable
fun QuoteListScreen(data : Array<Quote>, onclick:(quote:Quote)->Unit) {
    Column() {
        Text(text = "Quote App",
            textAlign = TextAlign.Center,
            modifier =Modifier.padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
        style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)))
        QuoteLists(data = data , onclick)
    }
}