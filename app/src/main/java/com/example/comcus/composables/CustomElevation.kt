package com.example.comcus.composables

//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun CustomElevation(
//    elevation: Dp = 4.dp,
//    content: @Composable () -> Unit
//) {
//    var isPressed by remember { mutableStateOf(false) }
//
//    val backgroundColor = if (isPressed) {
//        color.
//    } else {
//        colors.surface
//    }
//
//    Box(
//        modifier = Modifier
//            .background(
//                color = backgroundColor,
//                shape = RoundedCornerShape(4.dp),
//                elevation = elevation
//            )
//            .clickable(
//                onClick = { /* Handle click event */ },
//                onPress = { isPressed = true },
//                onRelease = { isPressed = false }
//            )
//    ) {
//        content()
//    }
//}