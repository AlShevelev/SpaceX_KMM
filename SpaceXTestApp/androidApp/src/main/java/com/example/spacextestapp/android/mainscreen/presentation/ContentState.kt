package com.example.spacextestapp.android.mainscreen.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spacextestapp.android.R
import com.example.spacextestapp.entity.RocketLaunch

@Composable
internal fun ContentState(
    modifier: Modifier,
    content: List<RocketLaunch>,
    onReloadClick: () -> Unit           // FAB
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onReloadClick) {
                Icon(Icons.Filled.Refresh, "")
            }
        },
        content = {
            LazyColumn(
                modifier = modifier
            ) {
                items(content) { launch ->
                    Card(
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(all = 16.dp)
                        ) {
                            Text(text = stringResource(id = R.string.cardTitle, launch.missionName))

                            if(launch.launchSuccess == true) {
                                Text(
                                    text = stringResource(id = R.string.cardSuccess),
                                    color = Color.Green
                                )
                            } else {
                                Text(
                                    text = stringResource(id = R.string.cardFail),
                                    color = Color.Red
                                )
                            }

                            Text(text = stringResource(id = R.string.cardYear, launch.launchYear))

                            Text(
                                text = stringResource(id = R.string.cardDetails, launch.details ?: ""),
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}