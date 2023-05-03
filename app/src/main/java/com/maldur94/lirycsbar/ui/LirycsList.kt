package com.maldur94.lirycsbar.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maldur94.database.model.Liryc
import com.maldur94.lirycsbar.component.LirycCard

@Composable
fun LirycsList(lirycs: List<Liryc>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(lirycs) { liryc ->
            LirycCard(liryc)
        }
    }
}
