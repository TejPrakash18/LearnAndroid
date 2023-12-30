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
import com.tejdev.quotesapp.screens.QuoteListItem
import com.tejdev.quotesapp.screens.QuoteListScreen
import com.tejdev.quotesapp.screens.QuotesDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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
fun App(){
    if (DataManager.isDataLoaded.value){
        QuoteListScreen(data = DataManager.data){

        }
    }
    else{
        Box(modifier = Modifier.fillMaxWidth(1f)){
            Text(text =" Laoding.... ",
                style = MaterialTheme.typography.labelMedium)
        }
    }

}
