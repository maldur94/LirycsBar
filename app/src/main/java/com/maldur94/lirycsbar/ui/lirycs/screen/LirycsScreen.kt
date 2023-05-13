package com.maldur94.lirycsbar.ui.lirycs.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.component.EmptyListScreen
import com.maldur94.lirycsbar.component.LirycCard
import com.maldur94.lirycsbar.model.LirycsBarScreen
import com.maldur94.lirycsbar.model.TagKeys
import com.maldur94.lirycsbar.resources.Dimens
import com.maldur94.lirycsbar.ui.lirycs.LirycsViewModel

@Composable
fun LirycsScreen(
    navController: NavHostController,
    viewModel: LirycsViewModel,
    lirycs: List<Liryc>
) {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (lirycs.isEmpty()) EmptyListScreen()
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lirycs) { liryc ->
                    LirycCard(navController = navController, viewModel = viewModel, liryc = liryc)
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(Dimens.smallPadding),
                backgroundColor = MaterialTheme.colors.primary,
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = TagKeys.LIRYC_TAG,
                        value = getNewLiryc(lirycs.size + 1)
                    )
                    navController.navigate(LirycsBarScreen.LirycsAdd.name)
                },
                shape = RoundedCornerShape(Dimens.large_padding)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add FAB",
                    tint = Color.White,
                )
            }
        }
    }
}

private fun getNewLiryc(newId: Int) = Liryc(id = newId, title = "...", description = "")
