package com.example.comcus.ui.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    Column(Modifier.padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
       FloatingActionButton(onClick = { /*TODO*/ }, shape = CircleShape) {
           BasicText(text = "Amnah")
       }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewTest() {
    Test()
}