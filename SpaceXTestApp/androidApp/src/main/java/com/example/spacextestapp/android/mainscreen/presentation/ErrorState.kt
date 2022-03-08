package com.example.spacextestapp.android.mainscreen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spacextestapp.android.R

@Composable
internal fun ErrorState(
    modifier: Modifier,
    onReloadClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.errorMessage),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = onReloadClick
            ) {
                Text(text = stringResource(id = R.string.reload))
            }
        }
    }
}