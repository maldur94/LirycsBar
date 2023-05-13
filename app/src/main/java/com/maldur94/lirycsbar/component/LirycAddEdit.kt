package com.maldur94.lirycsbar.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.resources.Dimens
import com.maldur94.lirycsbar.util.inQuotationMarks

@Composable
fun LirycAddEdit(lirycValue: Liryc?, navigateBackAction: (Liryc) -> Unit) {
    Card(
        modifier = Modifier
            .padding(Dimens.mediumPadding)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = Dimens.mediumElevation,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.padding(Dimens.mediumPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputTextField(
                    modifier = Modifier,
                    text = lirycValue?.title?.inQuotationMarks(),
                    textStyle = MaterialTheme.typography.h2,
                    onValueChange = { lirycValue?.title = it },
                )
                InputTextField(modifier = Modifier.fillMaxHeight(),
                    text = lirycValue?.description,
                    textStyle = MaterialTheme.typography.body2,
                    onValueChange = { lirycValue?.description = it })
            }
        }
    }
}
