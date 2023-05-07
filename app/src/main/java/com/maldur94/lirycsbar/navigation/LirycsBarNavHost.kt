package com.maldur94.lirycsbar.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.model.TagKeys.LIRYC_TAG
import com.maldur94.lirycsbar.ui.lirycs.screen.LirycsBarScreen
import com.maldur94.lirycsbar.ui.lirycs.screen.LirycsEditScreen
import com.maldur94.lirycsbar.ui.lirycs.screen.LirycsScreen

@Composable
fun LirycsBarNavHost(
    navController: NavHostController,
    lirycs: List<Liryc>,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = LirycsBarScreen.Lirycs.name,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = LirycsBarScreen.Lirycs.name) {
            LirycsScreen(lirycs = lirycs, navController = navController)
        }
        composable(route = LirycsBarScreen.LirycsEdit.name) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Liryc>(LIRYC_TAG)?.run {
                LirycsEditScreen(this)
            }
        }
    }
}
