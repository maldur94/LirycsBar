package com.maldur94.lirycsbar.component

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.maldur94.lirycsbar.R
import com.maldur94.lirycsbar.model.LirycsBarScreen
import com.maldur94.lirycsbar.resources.Dimens

@Composable
fun LirycsBarAppBar(currentScreen: LirycsBarScreen, navigateUp: () -> Unit) {
    TopAppBar(
        elevation = Dimens.mediumElevation,
        title = { Text(stringResource(currentScreen.titleId)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = { navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        },
        actions = {
            val context = LocalContext.current
            var isKebabMenuExpanded by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.TopEnd)
            ) {
                IconButton(onClick = { isKebabMenuExpanded = !isKebabMenuExpanded }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More"
                    )
                }
                DropdownMenu(
                    expanded = isKebabMenuExpanded,
                    onDismissRequest = { isKebabMenuExpanded = false }
                ) {
                    DropdownMenuItem(
                        onClick = {
                            Toast.makeText(context, R.string.exporting, Toast.LENGTH_SHORT).show()
                        },
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_download),
                                contentDescription = stringResource(
                                    R.string.export_lirycs_into_csv_format
                                )
                            )
                            Spacer(modifier = Modifier.width(width = 8.dp))
                            Text(
                                text = stringResource(R.string.export_lirycs_into_csv_format),
                                style = MaterialTheme.typography.body2,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    )
                }
            }
        }
    )
}
