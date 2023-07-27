package com.example.comcus.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.comcus.R

@Composable
fun CustomTopAppBar(
    modifier: Modifier=Modifier,
    height: Dp =60.dp,
    color: Color =Color.White,
    paddingValues: PaddingValues= PaddingValues(16.dp),
    showLeftICon:Boolean = true,
    showRightICon:Boolean = false,
    leftICon:Painter = painterResource(id = R.drawable.baseline_arrow_back_24),
    rightICon:Painter = painterResource(id = R.drawable.baseline_arrow_back_24),
    text:String ="Main Activity",
    textColor:Color= Color.Black
    ){
    Row(
        modifier
            .fillMaxWidth()
            .height(height)
            .background(color)
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ){
        if (showLeftICon){
        Box(modifier =Modifier){
            Icon(painter = leftICon, contentDescription = "")
        }}
        Box(modifier =Modifier){
            Text(text = text, modifier = Modifier,color=textColor)
        }
        Box(modifier =Modifier){
            if (showRightICon){
            Icon(painter = rightICon, contentDescription = "")}
        }
    }

}
@Preview
@Composable
fun TopAppBarPreview(){
    CustomTopAppBar()
}