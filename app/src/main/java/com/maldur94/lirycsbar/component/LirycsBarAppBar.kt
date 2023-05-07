package com.maldur94.lirycsbar.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.maldur94.lirycsbar.R

@Composable
fun LirycsBarAppBar(navigateUp: () -> Unit) {
    TopAppBar(
        elevation = 10.dp,
        title = { Text(stringResource(R.string.your_lirycs_bar)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }
    )
}
