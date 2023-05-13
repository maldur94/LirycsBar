package com.maldur94.lirycsbar.ui.lirycs.screen.edit

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.component.InputTextField
import com.maldur94.lirycsbar.resources.Dimens
import com.maldur94.lirycsbar.ui.lirycs.LirycsViewModel
import com.maldur94.lirycsbar.util.inQuotationMarks

@Composable
fun LirycsEditScreen(navController: NavHostController, viewModel: LirycsViewModel, liryc: Liryc) {
    val lirycValue by remember { mutableStateOf(liryc) }
    var titleValue by remember { mutableStateOf(liryc.title) }
    var descriptionValue by remember { mutableStateOf(liryc.description) }
    BackHandler {
        if (lirycValue != liryc) viewModel.editLiryc(liryc)
        navController.navigateUp()
    }
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
                    text = titleValue.inQuotationMarks(),
                    textStyle = MaterialTheme.typography.h2,
                    onValueChange = {
                        titleValue = it
                        lirycValue.title = it
                    },
                )
                InputTextField(modifier = Modifier.fillMaxHeight(),
                    text = descriptionValue,
                    textStyle = MaterialTheme.typography.body2,
                    onValueChange = {
                        descriptionValue = it
                        lirycValue.description = it
                    }
                )
            }
        }
    }
}

//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
//@Composable
//fun PlanetPreview() {
//    LirycsBarTheme {
//        LirycsEditScreen(
//            liryc = Liryc(
//                id = 0,
//                title = "Red Hot Chilli Peppers - Under the Bridge",
//                description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout",
//                iconUrl = ""
//            )
//        )
//    }
//}
