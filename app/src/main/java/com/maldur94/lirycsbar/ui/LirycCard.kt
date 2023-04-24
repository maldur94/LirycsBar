package com.maldur94.lirycsbar.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maldur94.lirycsbar.R
import com.maldur94.lirycsbar.theme.LirycsBarTheme

@Composable
fun LirycCard(name: String, description: String, image: Int) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
//            Image(
//                painter = painterResource(id = image),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(130.dp)
//                    .padding(8.dp),
//                contentScale = ContentScale.Fit,
//            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp)
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
            name = "test1",
            description = "description1",
            image = R.drawable.baseline_notes_24
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCard1Preview() {
    LirycsBarTheme {
        LirycCard(
            name = "test2",
            description = "description2",
            image = R.drawable.baseline_notes_24
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCard2Preview() {
    LirycsBarTheme {
        LirycCard(
            name = "test3",
            description = "description3",
            image = R.drawable.baseline_notes_24
        )
    }
}
