package com.maldur94.lirycsbar.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.R
import com.maldur94.lirycsbar.model.LirycActions
import com.maldur94.lirycsbar.model.LirycsBarScreen
import com.maldur94.lirycsbar.model.TagKeys
import com.maldur94.lirycsbar.resources.Dimens
import com.maldur94.lirycsbar.util.inQuotationMarks

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LirycCard(navController: NavHostController, lirycActions: LirycActions, liryc: Liryc) {
    var cardHeight by remember { mutableStateOf(Dimens.emptyMargin) }
    var shouldShowDialog by remember { mutableStateOf(false) }
    if (shouldShowDialog) {
        LirycsBarDialog(
            shouldShowDialog = { shouldShowDialog = it },
            confirmButtonText = stringResource(R.string.confirm),
            confirmButtonAction = { lirycActions.removeLiryc(liryc) }
        )
    }
    Card(
        modifier = Modifier
            .padding(
                start = Dimens.large_padding,
                top = Dimens.large_padding,
                end = Dimens.large_padding,
                bottom = Dimens.smallPadding
            )
            .fillMaxHeight(Dimens.MAX_CARD_HEIGHT)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = TagKeys.LIRYC_TAG,
                        value = liryc
                    )
                    navController.navigate(LirycsBarScreen.LirycsEdit.name)
                },
                onLongClick = { shouldShowDialog = true },
            )
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = Dimens.mediumElevation,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(Dimens.mediumPadding)) {
                Text(
                    modifier = Modifier
                        .padding(bottom = Dimens.smallPadding)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h2,
                    text = liryc.title.inQuotationMarks(),
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .onGloballyPositioned { coordinates ->
                            cardHeight = coordinates.size.height.dp
                        },
                    style = MaterialTheme.typography.body2,
                    text = liryc.description,
                )
                if (cardHeight.value > Dimens.MAX_CARD_HEIGHT) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center,
                        text = "",
                    )
                }
            }
        }
    }
}

//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
//@Composable
//fun LirycCardPreview() {
//    LirycsBarTheme {
//        LirycCard(
//            liryc = Liryc(
//                0,
//                "Red Hot Chilli Peppers - Under the Bridge",
//                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout",
//                iconUrl = ""
//            ), navController = rememberNavController()
//        )
//    }
//}
