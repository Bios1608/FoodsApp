package com.example.foodslist.ui.pages.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.foodslist.data.model.Food
import com.example.foodslist.data.model.FoodData
import com.example.foodslist.ui.theme.FoodsListTheme
import com.example.foodslist.utils.State

@Composable
fun DetailPage(
    modifier: Modifier,
    foodId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    viewModel.food.collectAsState(initial = State.Loading).value.let { foodState ->
        when (foodState) {
            is State.Error -> {}
            State.Loading -> {
                viewModel.getFoodDetails(foodId)
            }

            is State.Success -> {
                DetailBody(modifier = modifier, food = foodState.data)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailBody(
    modifier: Modifier,
    food: Food,
) {
    val isFavorite = remember {
        mutableStateOf(food.favorite)
    }
    Scaffold(
        modifier = modifier.padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    food.favorite = !food.favorite
                    isFavorite.value = !isFavorite.value
                },
            ) {
                Icon(
                    imageVector = if (isFavorite.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = ""
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = food.name, fontSize = 24.sp, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = food.shop)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = food.location)
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = food.photoUrl,
                contentDescription = food.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = food.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailFoodPreview() {
    FoodsListTheme {
        DetailBody(
            modifier = Modifier,
            food = FoodData.foodData[2],
        )
    }
}