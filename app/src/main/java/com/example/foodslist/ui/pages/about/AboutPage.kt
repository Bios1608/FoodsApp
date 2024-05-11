package com.example.foodslist.ui.pages.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.foodslist.R
import com.example.foodslist.ui.theme.FoodsListTheme

@Composable
fun AboutPage(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(32.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter)
        ) {
            AsyncImage(
                model = stringResource(R.string.about_photo_url),
                contentDescription = "about_image",
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .testTag("about_photo")
            )
            Text(
                text = stringResource(R.string.about_name),
                modifier = modifier.testTag("about_name").align(Alignment.Start)
            )
            Text(
                text = stringResource(R.string.about_email),
                modifier = modifier.testTag("about_email").align(Alignment.Start)
            )
            Text(text = stringResource(id = R.string.jurusan),
                modifier.align(Alignment.Start)
            )
            Text(text = stringResource(id = R.string.kampus),
                modifier.align(Alignment.Start))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailFoodPreview() {
    FoodsListTheme {
        AboutPage()
    }
}