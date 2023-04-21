package com.maldur94.lirycsbar.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.maldur94.lirycsbar.ui.theme.LirycsBarTheme
import com.maldur94.lirycsbar.util.collectLatestLifecycleFlow

class LirycsBarActivity : ComponentActivity() {

    private val viewModel: LirycsBarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var lirycs = listOf<String>()
        collectLatestLifecycleFlow(viewModel.lirycs) {
            lirycs = it
        }
        setContent {
            LirycsBarTheme {
                viewModel.getLirycs()
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                Surface(color = MaterialTheme.colors.background) {
                    LirycsList(lirycs)
                }
            }
        }
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