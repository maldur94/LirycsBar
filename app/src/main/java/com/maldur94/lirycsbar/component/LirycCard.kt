package com.maldur94.lirycsbar.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.theme.LirycsBarTheme
import kotlinx.datetime.LocalDateTime

@Composable
fun LirycCard(liryc: Liryc) {
    Card(
        modifier = Modifier
            .padding(top = 14.dp, start = 14.dp, end = 14.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 6.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(11.dp)) {
                Text(
                    text = liryc.title,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = liryc.description,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCardPreview() {
    LirycsBarTheme {
        LirycCard(
            Liryc(
                0,
                "title",
                "test description",
                LocalDateTime(2023, 1, 12, 0, 0),
                iconUrl = ""
            )
        )
    }
}

