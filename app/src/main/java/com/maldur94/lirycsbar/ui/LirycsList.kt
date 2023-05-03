package com.maldur94.lirycsbar.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LirycsList(lirycs: List<String>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(lirycs) { liryc ->
            LirycCard(title = liryc, description = liryc)
        }
    }
}
