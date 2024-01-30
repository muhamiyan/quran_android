package com.quran.mobile.feature.audiobar.ui

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.quran.labs.androidquran.common.ui.core.QuranIcons
import com.quran.labs.androidquran.common.ui.core.QuranTheme
import com.quran.mobile.feature.audiobar.AudioBarEvent
import com.quran.mobile.feature.audiobar.AudioBarState

@Composable
fun ErrorAudioBar(state: AudioBarState.Error, modifier: Modifier = Modifier) {
  val sink = state.eventSink
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier.height(IntrinsicSize.Min)
  ) {
    IconButton(onClick = { sink(AudioBarEvent.CancelablePlaybackEvent.Cancel) }) {
      Icon(QuranIcons.Close, contentDescription = stringResource(id = android.R.string.cancel))
    }

    Divider(
      modifier = Modifier
        .fillMaxHeight()
        .width(Dp.Hairline)
    )

    Text(text = state.message)
  }
}

@Preview
@Composable
fun ErrorAudioBarPreview() {
  QuranTheme {
    ErrorAudioBar(
      state = AudioBarState.Error(
        message = "Error message",
        eventSink = {}
      )
    )
  }
}