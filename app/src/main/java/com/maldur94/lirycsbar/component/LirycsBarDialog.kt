package com.maldur94.lirycsbar.component

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.maldur94.lirycsbar.R

@Composable
fun LirycsBarDialog(
    shouldShowDialog: (Boolean) -> Unit,
    confirmButtonText: String,
    dismissButtonText: String = stringResource(R.string.cancel),
    confirmButtonAction: () -> Unit
) {
    AlertDialog(
        text = {
            Text(text = stringResource(id = R.string.are_you_sure_you_want_to_remove_this_liryc))
        },
        onDismissRequest = { shouldShowDialog.invoke(false) },
        confirmButton = {
            TextButton(onClick = {
                confirmButtonAction()
                shouldShowDialog.invoke(false)
            })
            { Text(text = confirmButtonText) }
        },
        dismissButton = {
            TextButton(onClick = { shouldShowDialog.invoke(false) })
            { Text(text = dismissButtonText) }
        }
    )
}
