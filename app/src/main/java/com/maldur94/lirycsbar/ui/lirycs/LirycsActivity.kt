package com.maldur94.lirycsbar.ui.lirycs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maldur94.lirycsbar.component.LirycsBarAppBar
import com.maldur94.lirycsbar.navigation.LirycsBarNavHost
import com.maldur94.lirycsbar.theme.LirycsBarTheme
import com.maldur94.lirycsbar.theme.grey100
import com.maldur94.lirycsbar.theme.grey300
import com.maldur94.lirycsbar.ui.lirycs.screen.LirycsBarScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LirycsBarActivity : ComponentActivity() {

    private val viewModel: LirycsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LirycsBarTheme {
                val navController = rememberNavController()
                val lirycs = viewModel.lirycs.collectAsState().value
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                Scaffold(
                    topBar = {
                        LirycsBarAppBar(
                            currentScreen = getCurrentScreen(navController),
                            navigateUp = { onBackPressedDispatcher.onBackPressed() }
                        )
                    },
                    modifier = Modifier.background(Brush.linearGradient(listOf(grey100, grey300)))
                ) { paddingValues ->
                    LirycsBarNavHost(
                        navController = navController,
                        lirycs = lirycs,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getLirycs()
    }
}

@Composable
private fun getCurrentScreen(navController: NavHostController): LirycsBarScreen {
    val backStackEntry by navController.currentBackStackEntryAsState()
    return LirycsBarScreen.values().find {
        backStackEntry?.destination?.route?.contains(it.name) == true
    } ?: LirycsBarScreen.Lirycs
}
