package com.maldur94.lirycsbar.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.component.LirycsBarAppBar
import com.maldur94.lirycsbar.theme.LirycsBarTheme
import com.maldur94.lirycsbar.theme.grey100
import com.maldur94.lirycsbar.theme.grey300
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.datetime.LocalDateTime

@AndroidEntryPoint
class LirycsBarActivity : ComponentActivity() {

    private val viewModel: LirycsBarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LirycsBarTheme {
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                val lirycs = viewModel.lirycs.collectAsState().value
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = { LirycsBarAppBar { onBackPressedDispatcher.onBackPressed() } }
                    ) {
                        Column(
                            Modifier
                                .padding(it)
                                .background(Brush.linearGradient(listOf(grey100, grey300)))
                        ) {
                            LirycsList(lirycs)
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getLirycs()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetPreview() {
    LirycsBarTheme {
        LirycsList(
            listOf(
                Liryc(
                    id = 0,
                    title = "test",
                    description = "description",
                    createdAt = LocalDateTime(2023, 1, 12, 10, 0),
                    iconUrl = ""
                )
            )
        )
    }
}