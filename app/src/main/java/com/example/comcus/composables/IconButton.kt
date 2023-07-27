package com.example.comcus.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comcus.R
import com.example.comcus.ui.theme.Purple40

enum class IconPosition {
    START, END
}
@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color = Purple40,
    shape: Shape = RoundedCornerShape(16.dp),
    icon: Int,
    iconPosition: IconPosition = IconPosition.START,
    contentDescription:String,
    iconColor:Color = Color.White,
    buttonText:String = "",
    textStyle: TextStyle = TextStyle()
) {

    Box(
        modifier = modifier
            .clip(shape)
            .height(56.dp)
            .background(color)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            if (buttonText == ""){
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    tint = iconColor
                )
            }else if (iconPosition == IconPosition.END){
                BasicText(text = buttonText, style = textStyle)
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    tint = iconColor
                )
            }else if(iconPosition == IconPosition.START){
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    tint = iconColor
                )
                BasicText(text = buttonText, style = textStyle)

            }

        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun PreviewIconButton() {
    Column (){
        Spacer(modifier = Modifier.height(16.dp))
        IconButton(
            onClick = { /*TODO*/ },
            icon = R.drawable.baseline_heart_broken_24,
            iconColor = Color.Red,
            contentDescription = "add",
            buttonText = "Hello world",
            iconPosition = IconPosition.START
        )
    }
}