package com.example.foodslist.ui.pages.details

import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.foodslist.data.model.FoodData
import com.example.foodslist.ui.theme.FoodsListTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailPageKtTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeFood = FoodData.foodData[0]

    @Before
    fun setUp(){
        composeTestRule.setContent {
            FoodsListTheme {
                DetailBody(modifier = Modifier, food = fakeFood)
            }
        }
    }

    @Test
    fun detailFoodIsDisplayed(){
        composeTestRule.onNodeWithText(fakeFood.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeFood.shop).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeFood.location).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeFood.description).assertIsDisplayed()
    }
}