package com.example.comcus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.comcus.composables.TextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val text = rememberSaveable { mutableStateOf("") }

            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                TextField(
                    text = text.value,
                    label = {
                        BasicText(text = "Email", modifier = Modifier.padding(horizontal = 8.dp))
                    },
                    modifier = Modifier.width(300.dp),
                    backgroundColor = colorResource(id = R.color.teal_200),
                    shape = RoundedCornerShape(0),
                    isError = true,
                    cursorBrush = SolidColor(Color.Green),
                    colors = Color.Cyan,
                    paddingContent = PaddingValues(horizontal = 16.dp),
                    onValueChange = { t ->
                        text.value = t
                    }
                )
            }
        }
    }
}
