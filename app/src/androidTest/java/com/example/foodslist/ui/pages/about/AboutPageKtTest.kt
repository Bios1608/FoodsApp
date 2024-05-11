package com.example.foodslist.ui.pages.about

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.foodslist.ui.theme.FoodsListTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AboutPageKtTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            FoodsListTheme {
                AboutPage()
            }
        }
    }

    @Test
    fun aboutInformationIsDisplayedAndNotEmpty(){
        composeTestRule.onNodeWithTag("about_name").assertIsDisplayed()
        composeTestRule.onNodeWithTag("about_email").assertIsDisplayed()
        composeTestRule.onNodeWithTag("about_photo").assertIsDisplayed()
    }
}
