package com.tejdev.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.tejdev.quotesapp.models.Quote

@Composable
fun QuoteLists( data: Array<Quote>, onClick:()-> Unit ) {
    
    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it ) {
                onClick()
            }
        }
    })
}