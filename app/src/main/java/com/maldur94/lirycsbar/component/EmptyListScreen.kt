package com.maldur94.lirycsbar.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.maldur94.lirycsbar.R
import com.maldur94.lirycsbar.resources.Dimens

@Composable
fun EmptyListScreen() {
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
                text = stringResource(R.string.no_lirycs_added)
            )
            Text(
                style = MaterialTheme.typography.body2,
                text = stringResource(R.string.please_add_new_liryc_on_button_down_below)
            )
        }
    }
}
