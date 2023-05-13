package com.maldur94.lirycsbar.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.maldur94.lirycsbar.theme.grey100

@Composable
fun InputTextField(
    modifier: Modifier,
    hint: String,
    text: String,
    textStyle: TextStyle,
    onValueChange: (String) -> Unit
) {
    TextField(
        label = { Text(hint) },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = grey100,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        value = text,
        textStyle = textStyle,
        onValueChange = onValueChange
    )
}