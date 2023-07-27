package com.example.comcus.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.comcus.R
import com.example.comcus.util.IconButtonTokens


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
    textColor:Color= Color.Black,
    onClickLeftIcon:()->Unit= {},
    onClickRightIcon: () -> Unit={}
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
        val context = LocalContext.current
        if (showLeftICon){
        Box(modifier =Modifier){
            Icon(painter = leftICon, contentDescription = "",
                modifier = Modifier.clickable {
                    mToast(context)
                    onClickLeftIcon()
            }
            )
        }
        }
        Box(modifier =Modifier){
            Text(text = text, modifier = Modifier,color=textColor)
        }
        Box(modifier =Modifier.size(IconButtonTokens.IconSize)){
            if (showRightICon){
                Icon(painter = rightICon, contentDescription = "",
                    Modifier.clickable {
                        mToast(context)
                        onClickRightIcon()
                }
                )
            }
        }
    }

}
private fun mToast(context: Context){
    Toast.makeText(context, "Iam not Here *_*", Toast.LENGTH_LONG).show()
}
@Preview
@Composable
fun TopAppBarPreview(){
    CustomTopAppBar()
}