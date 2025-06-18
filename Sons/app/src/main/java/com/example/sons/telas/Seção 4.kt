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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sons.R
import com.example.sons.ui.theme.BackgroundCalm
import com.example.sons.ui.theme.fonteleague

@Composable
fun SecaoQuatro(navController: NavHostController) {

    var expandedOndas by remember { mutableStateOf(false) }
    var expandedPraia by remember { mutableStateOf(false) }
    var expandedOceano by remember { mutableStateOf(false) }

    fun collapseOthers(except: String) {
        expandedOndas = except == "ondas" && !expandedOndas
        expandedPraia = except == "praia" && !expandedPraia
        expandedOceano = except == "oceano" && !expandedOceano
    }

    //chamar o som assim q o botão player for clicado
    val context = LocalContext.current
    val ondasUri = rawResToUri(context, R.raw.tempestade)
    val praiaUri = rawResToUri(context, R.raw.cachoeira)
    val oceanoUri = rawResToUri(context, R.raw.chuvafraca)

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
            text = "Seção 4",
            fontSize = 29.sp,
            fontFamily = fonteleague,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(360.dp)
                .height(130.dp)
                .offset(x = 25.dp, y = 122.dp)

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
        //imagem do oceano
        //tirar o sombreado da foto
        Image(
            painter = painterResource(id = R.drawable.oceanofoto),
            contentDescription = "Uma foto de um mar calmo com o nome 'Oceano' escrito",
            modifier = Modifier
                .width(370.dp)
                .height(230.dp)
                .align(Alignment.TopCenter)
                .offset(y = 152.dp)
        )
        //botões imagem
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(390.dp)) // empurra todos os botões para baixo

            // Botão Ondas
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(350f / 105f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        collapseOthers("ondas")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaoondas),
                    contentDescription = "Imagem de varias ondas do mar um pouco agressivas, com um nome ao meio escrito 'ondas'",
                    modifier = Modifier.fillMaxSize()
                )
            }
            PlayerAnimado(
                visible = expandedOndas,
                url = ondasUri.toString()
            )

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            // Botão Praia
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(350f / 105f)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        collapseOthers("praia")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.botaopraia),
                    contentDescription = "Uma imagem de uma praia com ondas um pouco calmas em um horario do por do sol, com o nome 'praia' escrito",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedPraia,
                url = praiaUri.toString()
            )

            Spacer(modifier = Modifier.height(15.dp)) // espaço entre os botões

            // Botão Oceano
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .aspectRatio(220f / 70f) // se for quadrado
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        collapseOthers("oceano")
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.oceanobotao),
                    contentDescription = "Imagem de um oceano com algumas algas e um pouco de luz solar 'noite'",
                    modifier = Modifier.fillMaxSize()
                )
            }

            PlayerAnimado(
                visible = expandedOceano,
                url = oceanoUri.toString()
            )
        }
    }
}