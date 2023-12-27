package com.sam.tenflix.pesentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.tenflix.R
import com.sam.tenflix.ui.theme.AppRed

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(40.dp),
            painter = painterResource(id = R.drawable.app_logo),
            tint = AppRed,
            contentDescription = null
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier
                .size(40.dp)
                .padding(5.dp),
            imageVector = Icons.Rounded.Search,
            tint = Color.White,
            contentDescription = null
        )

    }

}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar()
}