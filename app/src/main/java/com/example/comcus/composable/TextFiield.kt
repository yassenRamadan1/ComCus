package com.example.comcus.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    isError: Boolean = false,
    shape: Shape = RoundedCornerShape(0),
    backgroundColor: Color = Color.LightGray,
    paddingContent: PaddingValues = PaddingValues(0.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: Color = Color.Black,
    label: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit = {},
    textStyle: TextStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
    cursorBrush: Brush = SolidColor(Color.Green),
    messageError: String = "The content is Error",
    errorStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold
    ),
) {

    Column (modifier = Modifier.clip(shape = shape)){
        Box(
            modifier = modifier
                .background(color = backgroundColor)
                .width(300.dp)
                .indicatorLine(
                    enabled,
                    isError,
                    interactionSource,
                    if (isError) Color.Red else colors
                ),
            contentAlignment = Alignment.Center
        ) {
            Column {
                label?.let { it() }
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .padding(horizontal = 4.dp)
                )
                BasicTextField(
                    value = text,
                    cursorBrush = cursorBrush,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .padding(paddingValues = paddingContent),
                    maxLines = 1,
                    textStyle = textStyle,
                    onValueChange = onValueChange,
                )
            }
        }
        if (isError) {
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            BasicText(
                text = messageError,
                style = errorStyle,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

val FocusedBorderThickness = 2.dp
val UnfocusedBorderThickness = 2.dp
internal const val AnimationDuration = 150


fun Modifier.indicatorLine(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: Color,
    focusedIndicatorLineThickness: Dp = FocusedBorderThickness,
    unfocusedIndicatorLineThickness: Dp = UnfocusedBorderThickness
) = composed(inspectorInfo = debugInspectorInfo {
    name = "indicatorLine"
    properties["enabled"] = enabled
    properties["isError"] = isError
    properties["interactionSource"] = interactionSource
    properties["colors"] = colors
    properties["focusedIndicatorLineThickness"] = focusedIndicatorLineThickness
    properties["unfocusedIndicatorLineThickness"] = unfocusedIndicatorLineThickness
}) {
    val stroke = animateBorderStrokeAsState(
        enabled,
        isError,
        interactionSource,
        colors,
        focusedIndicatorLineThickness,
        unfocusedIndicatorLineThickness
    )
    Modifier.drawIndicatorLine(stroke.value)
}


@Composable
private fun animateBorderStrokeAsState(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: Color,
    focusedBorderThickness: Dp,
    unfocusedBorderThickness: Dp
): State<BorderStroke> {
    val focused by interactionSource.collectIsFocusedAsState()
    val targetThickness = if (focused) focusedBorderThickness else unfocusedBorderThickness
    val animatedThickness = if (enabled) {
        animateDpAsState(targetThickness, tween(durationMillis = AnimationDuration), label = "")
    } else {
        rememberUpdatedState(unfocusedBorderThickness)
    }
    return rememberUpdatedState(
        BorderStroke(animatedThickness.value, SolidColor(colors))
    )
}

internal fun Modifier.drawIndicatorLine(indicatorBorder: BorderStroke): Modifier {
    val strokeWidthDp = indicatorBorder.width
    return drawWithContent {
        drawContent()
        if (strokeWidthDp == Dp.Hairline) return@drawWithContent
        val strokeWidth = strokeWidthDp.value * density
        val y = size.height - strokeWidth / 2
        drawLine(
            indicatorBorder.brush,
            Offset(0f, y),
            Offset(size.width, y),
            strokeWidth
        )
    }
}