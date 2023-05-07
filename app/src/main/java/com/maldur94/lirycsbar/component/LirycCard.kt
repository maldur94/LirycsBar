package com.maldur94.lirycsbar.component

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.model.TagKeys
import com.maldur94.lirycsbar.resources.Dimens
import com.maldur94.lirycsbar.theme.LirycsBarTheme
import com.maldur94.lirycsbar.ui.lirycs.screen.LirycsBarScreen
import com.maldur94.lirycsbar.util.inQuotationMarks

@Composable
fun LirycCard(liryc: Liryc, navController: NavHostController) {
    var cardHeight by remember { mutableStateOf(Dimens.emptyMargin) }
    Card(
        modifier = Modifier
            .padding(
                top = Dimens.large_padding,
                start = Dimens.large_padding,
                end = Dimens.large_padding
            )
            .fillMaxHeight(Dimens.MAX_CARD_HEIGHT)
            .fillMaxWidth()
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = TagKeys.LIRYC_TAG,
                    value = liryc
                )
                navController.navigate(LirycsBarScreen.LirycsEdit.name)
            }
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = Dimens.mediumElevation,
        backgroundColor = MaterialTheme.colors.surface) {
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
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        cardHeight = coordinates.size.height.dp
                    },
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    text = liryc.description,
                )
                if (cardHeight.value > Dimens.MAX_CARD_HEIGHT) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center,
                        text = "...",
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun LirycCardPreview() {
    LirycsBarTheme {
        LirycCard(
            liryc = Liryc(
                0,
                "Red Hot Chilli Peppers - Under the Bridge",
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout",
                iconUrl = ""
            ), navController = rememberNavController()
        )
    }
}
