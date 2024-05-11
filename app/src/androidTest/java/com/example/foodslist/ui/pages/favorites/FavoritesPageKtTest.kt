package com.example.foodslist.ui.pages.favorites

import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.foodslist.ui.theme.FoodsListTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoritesPageKtTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    @Before
    fun setUp(){
        composeTestRule.setContent {
            FoodsListTheme {
                FavoritesPage(
                    modifier = Modifier,
                    detailNavigation = {}
                )
            }
        }
    }

    @Test
    fun checkIfFavoriteFoodsListIsDisplayed() {
        composeTestRule.onNodeWithTag("lazy_list").assertIsDisplayed()
    }
}