package com.maldur94.lirycsbar.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.model.LirycsBarScreen
import com.maldur94.lirycsbar.model.TagKeys.LIRYC_TAG
import com.maldur94.lirycsbar.ui.lirycs.LirycsViewModel
import com.maldur94.lirycsbar.ui.lirycs.screen.LirycsScreen
import com.maldur94.lirycsbar.ui.lirycs.screen.add.LirycsAddScreen
import com.maldur94.lirycsbar.ui.lirycs.screen.edit.LirycsEditScreen

@Composable
fun LirycsBarNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: LirycsViewModel,
    lirycs: List<Liryc>
) {
    NavHost(
        navController = navController,
        startDestination = LirycsBarScreen.Lirycs.name,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = LirycsBarScreen.Lirycs.name) {
            LirycsScreen(viewModel = viewModel, navController = navController, lirycs = lirycs)
        }
        composable(route = LirycsBarScreen.LirycsAdd.name) {
            LirycsAddScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = LirycsBarScreen.LirycsEdit.name) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Liryc>(LIRYC_TAG)?.run {
                LirycsEditScreen(navController = navController, viewModel = viewModel, liryc = this)
            }
        }
    }
}
