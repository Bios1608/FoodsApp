package com.example.foodslist.ui.pages.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.foodslist.data.model.FoodData
import com.example.foodslist.ui.theme.FoodsListTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class HomePageKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeFoodsList = FoodData.foodData
    private var fakeKeyword = ""

    @Before
    fun setUp() {
        composeTestRule.setContent {
            FoodsListTheme {
                HomeBody(
                    modifier = Modifier,
                    keyword = fakeKeyword,
                    onKeywordChange = {},
                    listFoods = fakeFoodsList,
                    detailNavigation = {}
                )
            }
        }
    }

    @Test
    fun checkIfFoodsListIsDisplayed() {
        composeTestRule.onNodeWithTag("lazy_list").assertIsDisplayed()
    }
}