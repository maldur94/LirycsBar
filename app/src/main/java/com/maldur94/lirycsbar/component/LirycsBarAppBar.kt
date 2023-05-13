package com.maldur94.lirycsbar.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.maldur94.lirycsbar.model.LirycsBarScreen
import com.maldur94.lirycsbar.resources.Dimens

@Composable
fun LirycsBarAppBar(currentScreen: LirycsBarScreen, navigateUp: () -> Unit) {
    TopAppBar(
        elevation = Dimens.mediumElevation,
        title = { Text(stringResource(currentScreen.titleId)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }
    )
}
