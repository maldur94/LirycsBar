package com.maldur94.lirycsbar.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.maldur94.lirycsbar.theme.LirycsBarTheme

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
                        Column(Modifier.padding(it)) {
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
        LirycsList(listOf("test1", "test2", "test3"))
    }
}