package com.example.sons.telas

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sons.R
import com.example.sons.ui.theme.BackgroundCalm
import com.example.sons.ui.theme.fonteleague


@Composable
fun SecaoUm(navController: NavHostController) {
    var expandedTempestade by remember { mutableStateOf(false) }
    var expandedChuva by remember { mutableStateOf(false) }
    var expandedChuvaFraca by remember { mutableStateOf(false) }

    fun collapseOthers(except: String) {
        expandedTempestade = except == "tempestade" && !expandedTempestade
        expandedChuva = except == "chuva" && !expandedChuva
        expandedChuvaFraca = except == "chuvaFraca" && !expandedChuvaFraca
    }

    //chamar o som assim q o botão player for clicado
    val context = LocalContext.current
    val tempestadeUri = rawResToUri(context, R.raw.tempestade)
    val chuvaUri = rawResToUri(context, R.raw.chuva)
    val chuvaFracaUri = rawResToUri(context, R.raw.chuvafraca)

    Box(
        Modifier
            .fillMaxSize()
            .background(color = BackgroundCalm)
    ) {
        Image(
            painter = painterResource(id = R.drawable.xicara_1),
            contentDescription = "Apenas uma xicara na cor amarela",
            modifier = Modifier
                .width(78.dp)
                .height(57.dp)
                .align(Alignment.TopCenter)
                .offset(x = 3.dp, y = 45.dp)
        )
        Text(
            text = "Seção 1",
            fontSize = 29.sp,
            fontFamily = fonteleague,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(360.dp)
                .height(130.dp)
                .offset(x = 25.dp, y = 122.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.chuvafoto),
            contentDescription = "Uma foto de uma chuva caindo no chão com nome 'chuva' escrito",
            modifier = Modifier
                .width(365.dp)
                .height(230.dp)
                .align(Alignment.TopCenter)
                .offset(y = 152.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.flor_lateral_baixo),
            contentDescription = "Metade de uma flor de camomila na posição inferior esquerda",
            modifier = Modifier
                .width(190.dp)
                .height(190.dp)
                .offset(y = 20.dp)
                .align(Alignment.BottomStart)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(390.dp))

            // Botão Tempestade
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(350f / 105f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { collapseOthers("tempestade") },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tempestadebotao),
                    contentDescription = "Imagem de uma noite bem chuvosa escrito 'tempestade'",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedTempestade,
                url = tempestadeUri.toString()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Chuva
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(350f / 105f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { collapseOthers("chuva") },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chuvabotao),
                    contentDescription = "Uma imagem de uma chuva aconchegante vista da janela",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedChuva,
                url = chuvaUri.toString()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Chuva Fraca
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 70f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { collapseOthers("chuvaFraca") },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chuvafracabotao),
                    contentDescription = "imagem de uma chuva pingando na rua, descrita como 'chuva fraca'",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedChuvaFraca,
                url = chuvaFracaUri.toString()
            )
        }
    }
}

@Composable
fun PlayerAnimado(visible: Boolean, url: String) {
    val playerHeight by animateDpAsState(
        targetValue = if (visible) 90.dp else 0.dp,
        animationSpec = tween(durationMillis = 400, easing = EaseInOut),
        label = "playerHeight"
    )

    val playerAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 400, easing = EaseInOut),
        label = "playerAlpha"
    )

    Box(
        modifier = Modifier
            .height(playerHeight)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        if (playerAlpha > 0f) {
            Box(modifier = Modifier.alpha(playerAlpha)) {
                PlayerDesign(url = url)
            }
        }
    }
}
