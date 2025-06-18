package com.example.sons.telas

import android.content.Context
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.core.net.toUri
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.example.sons.R
import kotlinx.coroutines.delay

@OptIn(UnstableApi::class)
@Composable
fun PlayerDesign(url: String) {

    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(url)
            setMediaItem(mediaItem)
            prepare()
        }
    }

    var isPlaying by remember { mutableStateOf(false) }
    var currentPosition by remember { mutableStateOf(0L) }
    var duration by remember { mutableStateOf(1L) } // começa com 1L para evitar range vazio

    // atualiza a duração quando o player estiver pronto
    LaunchedEffect(Unit) {
        exoPlayer.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                if (state == Player.STATE_READY) {
                    duration = exoPlayer.duration.coerceAtLeast(1L)
                }
            }
        })
    }

    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            currentPosition = exoPlayer.currentPosition
            delay(500)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 5.dp)
            .offset(y = (-6).dp)
            .background(
                color = Color(0xFFDFCCA4),
                shape = RoundedCornerShape(24.dp)
            )
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color.Black.copy(alpha = 0.0f),
                spotColor = Color.Black.copy(alpha = 0.0f)
            )
            .padding(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Slider(
                    value = currentPosition.coerceIn(0L, duration).toFloat(),
                    onValueChange = {
                        currentPosition = it.toLong()
                        exoPlayer.seekTo(currentPosition)
                    },
                    valueRange = 0f..duration.toFloat(),
                    modifier = Modifier
                        .weight(4f)
                        .height(20.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF00082A),
                        activeTrackColor = Color(0xFF00082A),
                        inactiveTrackColor = Color.White.copy(alpha = 0.4f)
                    )
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Image(
                painter = painterResource(
                    id = if (isPlaying) R.drawable.pausarbotao else R.drawable.playbotao
                ),
                contentDescription = "Botão",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(80.dp)
                    .offset(y = 3.dp)
                    .clickable {
                        if (isPlaying) exoPlayer.pause() else exoPlayer.play()
                        isPlaying = !isPlaying
                    }
            )
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}

fun rawResToUri(context: Context, resId: Int): Uri {
    return Uri.parse("android.resource://${context.packageName}/$resId")
}