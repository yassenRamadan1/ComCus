package com.example.comcus.composables

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comcus.R


@Composable
fun Test() {
    val context = LocalContext.current
    Column(
        Modifier.padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {
            Toast.makeText(
                context,
                "Hello moon cake I am Floating action button",
                Toast.LENGTH_SHORT
            )
                .show()
        }, shape = CircleShape
            , color = Color.LightGray
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_add_24
                ),
                contentDescription = "Icon", tint = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        IconButton(
            onClick = {
                Toast.makeText(context, "Hello moon cake I am Icon button", Toast.LENGTH_SHORT)
                    .show()

            },
            icon = R.drawable.baseline_heart_broken_24,
            contentDescription = "Icon",
            buttonText = "Hello world",
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.White
            ),
            iconColor = Color.Red,
            color = Color.LightGray
        )


    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewTest() {
    Test()
}