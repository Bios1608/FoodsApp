package com.example.foodslist.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodslist.data.model.FoodData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyChipList (
    modifier: Modifier
){
    LazyRow{
        items(FoodData.foodKeywords, key = {it}){chip->
            var selected = remember { mutableStateOf(false) }
            FilterChip(
                modifier = modifier.padding(horizontal = 4.dp),
                onClick = {
                    selected.value = !selected.value
                     },
                selected = selected.value,
                label = { Text(text = chip) })
        }
    }
}