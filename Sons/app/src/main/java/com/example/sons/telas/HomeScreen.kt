package com.example.sons.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sons.R
import com.example.sons.ui.theme.BackgroundCalm
import com.example.sons.ui.theme.fonteleague
import com.example.sons.ui.theme.fonteleagueBold


@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        Modifier.fillMaxSize()
            .background(color = BackgroundCalm)
    ) {
        Image(
            painter = painterResource(id = R.drawable.flor_em_cima_lado),
            contentDescription = "Metade de uma flor de camomila na posição superior direita",
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .offset(y = (-30).dp, x = 90.dp)
                .align(Alignment.TopCenter)
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
        Text(
            text = "Olá, como vai?",
            textAlign = TextAlign.Left,
            fontSize = 32.sp,
            fontFamily = fonteleagueBold,
            modifier = Modifier
                .width(256.dp)
                .height(50.dp)
                .offset(x = 25.dp, y = 75.dp)
        )
        Text(
            text = "O que gostaria de ouvir?",
            textAlign = TextAlign.Left,
            fontSize = 29.sp,
            fontFamily = fonteleague,
            modifier = Modifier
                .width(360.dp)
                .height(50.dp)
                .offset(x = 25.dp, y = 120.dp)
        )

        //botões imagem
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(175.dp)) // empurra todos os botões para baixo

            // Botão Chuva
            Box(
                modifier = Modifier
                    .width(370.dp)
                    .aspectRatio(350f / 180f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate("secao1")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaochuva),
                    contentDescription = "Imagem de uma noite bem chuvosa",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(20.dp)) // espaço entre os botões

            // Botão Natureza
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 65f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate("secao2")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaonatureza),
                    contentDescription = "Uma imagem de natureza estilo minecraft, em um dia muito insolarado",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            // Botão Ruído
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 65f) // se for quadrado
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate("secao3")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ruidobotao),
                    contentDescription = "Imagem de um ruído na cores cinza",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            //imagem como botão de oceano
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 65f) // se for quadrado
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate("secao4")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaooceano),
                    contentDescription = "Uma imagem de um oceano com as ondas tranquilas no horario do por do sol",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            //imagem como botão de lo-fi
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 65f) // se for quadrado
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        navController.navigate("secao5")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaolofi),
                    contentDescription = "Uma imagem de uma menina ouvindo musica no estilo pixelado",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


