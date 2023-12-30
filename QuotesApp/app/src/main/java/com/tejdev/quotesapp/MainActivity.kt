package com.tejdev.quotesapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.tejdev.quotesapp.screens.QuoteListItem
import com.tejdev.quotesapp.screens.QuoteListScreen
import com.tejdev.quotesapp.screens.QuotesDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.LoadAssetsFromFile(applicationContext)
        }


        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)

            }
        }else{
            DataManager.currentQuote?.let { QuotesDetail(quote = it) }
        }
}

    else{
        Box(modifier = Modifier.fillMaxWidth(1f)){
            Text(text ="Laoding....", color = Color.Black,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium)
        }
    }

}

enum class Pages{
    LISTING,
    DETAIL
}