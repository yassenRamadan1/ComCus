package com.example.comcus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.comcus.composable.TextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val text = rememberSaveable { mutableStateOf("") }

            TextField(
                text = text.value,
                label = {
                        BasicText(text = "Email", modifier = Modifier.padding(horizontal = 16.dp))
                },
                modifier = Modifier.width(400.dp),
                backgroundColor = colorResource(id = R.color.purple_200),
                shape = RoundedCornerShape(100),
                isError = false,
                cursorBrush = SolidColor(Color.Yellow),
                paddingContent = PaddingValues(horizontal = 16.dp),
                onValueChange = { t ->
                    text.value = t
                }
            )
        }
    }
}
