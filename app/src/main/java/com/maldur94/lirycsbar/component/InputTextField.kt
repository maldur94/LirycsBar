package com.maldur94.lirycsbar.component

import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun InputTextField(
    modifier: Modifier,
    text: String?,
    textStyle: TextStyle,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        value = text ?: "",
        textStyle = textStyle,
        onValueChange = onValueChange
    )
}