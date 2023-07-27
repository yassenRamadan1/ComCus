package com.example.comcus.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.comcus.ui.theme.Purple80

@Composable
fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color:  Color = Purple80,
    shape: Shape = RoundedCornerShape(16.dp),
    elevation: Dp = 8.dp,
    content: @Composable BoxScope.() -> Unit,
) {


        Box(
            modifier = modifier
                .shadow(elevation, ambientColor = Color.Transparent, spotColor = Color.Transparent)
                .size(58.dp)
                .clip(shape)
                .clickable(onClick = onClick)
                .background(color),
            contentAlignment = Alignment.Center,
            content = content
        )


}


@Preview(showSystemUi = true)
@Composable
fun PreviewFloatingActionButton() {
    Column(Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {}){

        }
    }

}