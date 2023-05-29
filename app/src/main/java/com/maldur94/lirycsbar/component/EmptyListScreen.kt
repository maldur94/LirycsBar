package com.maldur94.lirycsbar.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.maldur94.lirycsbar.resources.Dimens

@Composable
fun EmptyListScreen(titleId: Int, message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(Dimens.mediumPadding)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.body1,
                text = stringResource(titleId)
            )
            Text(
                style = MaterialTheme.typography.body2,
                text = message
            )
        }
    }
}
