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
fun SecaoDois(navController: NavHostController) {
    var expandedVentania by remember { mutableStateOf(false) }
    var expandedCachoeira by remember { mutableStateOf(false) }
    var expandedNoite by remember { mutableStateOf(false) }

    fun collapseOthers(except: String) {
        expandedVentania = except == "ventania" && !expandedVentania
        expandedCachoeira = except == "cachoeira" && !expandedCachoeira
        expandedNoite = except == "noite" && !expandedNoite
    }

    //chamar o som assim q o botão player for clicado
    val context = LocalContext.current
    val ventaniaUri = rawResToUri(context, R.raw.tempestade)
    val cachoeiraUri = rawResToUri(context, R.raw.cachoeira)
    val noiteUri = rawResToUri(context, R.raw.chuvafraca)

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
            text = "Seção 2",
            fontSize = 29.sp,
            fontFamily = fonteleague,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(360.dp)
                .height(130.dp)
                .offset(x = 25.dp, y = 122.dp)

        )
        //imagem da natureza e tirar o sombreado da foto
        Image(
            painter = painterResource(id = R.drawable.imagenatu),
            contentDescription = "Uma foto de uma joaninha na natureza em cima de uma folha com nome 'natureza' escrito",
            modifier = Modifier
                .width(370.dp)
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
        //botões imagem
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(390.dp)) // empurra todos os botões para baixo

            // Botão ventania
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(350f / 105f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        collapseOthers("ventania")},
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.butaoventani),
                    contentDescription = "Imagem de uma arvore com suas folhas em constante ventania",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedVentania,
                url = ventaniaUri.toString()
            )

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            // Botão cachoeira
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(350f / 105f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { collapseOthers("cachoeira")},
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bot_ocacho),
                    contentDescription = "Uma imagem de uma cachoeira em um clima confortavel no estilo pixel realista com o nome 'Cachoeira' escrito",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedCachoeira,
                url = cachoeiraUri.toString()
            )

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            // Botão noite
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 70f) // se for quadrado
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        collapseOthers("noite")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaonoite),
                    contentDescription = "Imagem de uma noite estrelada com a lua minguante, ao centro da foto esta escrito 'noite'",
                    modifier = Modifier.fillMaxSize()
                )

            }
            PlayerAnimado(
                visible = expandedNoite,
                url = noiteUri.toString()
            )
        }
    }
}
