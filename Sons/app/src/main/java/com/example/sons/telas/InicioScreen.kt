package com.example.sons.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sons.R
import com.example.sons.ui.theme.BackgroundCalm
import com.example.sons.ui.theme.Black

@Preview
@Composable
fun InicioScreen() {
    //add fonte
    Box(
        Modifier.fillMaxSize()
            .background(color = BackgroundCalm)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icone_sem_sombra),
            contentDescription = "uma logo com uma mão segurando uma xícara na cor bege e com uma florde camomila dentro",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(149.dp)
                .height(151.dp)
                .offset(y = 30.dp)
        )
        Text(
            text = "Calmina",
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(200.dp)
                .height(100.dp)
                .offset(y = 180.dp)
        )
        Text(
            text = "Vamos organizar a mente?",
            textAlign = TextAlign.Left,
            fontSize = 25.sp,
            modifier = Modifier
                .width(256.dp)
                .height(62.dp)
                .offset(y = 307.dp, x = 28.dp)
        )
        Text(
            text = "Preparei sons que podem te ajudar a se acalmar",
            textAlign = TextAlign.Left,
            fontSize = 25.sp,
            modifier = Modifier
                .width(324.dp)
                .height(93.dp)
                .offset(y = 412.dp, x = 28.dp)
        )
        Text(
            text = "Vamos lá?",
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier
                .width(355.dp)
                .height(31.dp)
                .offset(y = 150.dp)
                .align(Alignment.Center)
        )
        Image(
            painter = painterResource(id = R.drawable.group_4),
            contentDescription = "A metade de uma flor de camomila no canto inferior esquerdo",
            modifier = Modifier
                .width(280.dp)
                .height(280.dp)
                .align(Alignment.BottomEnd)
                .offset(y = 39.dp, x = (-115).dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
           BotaoElevado()
        }
    }
}

@Composable
fun BotaoElevado(){
    ElevatedButton (
        onClick = {/*ação */},
        modifier = Modifier
            .offset(x = 100.dp, y = 620.dp)
            .width(194.dp)
            .height(53.dp)
            .shadow(10.dp, RoundedCornerShape(30.dp))


    ){
        Text(
            text = "Começar",
            color = Black,
            fontSize = 20.sp,
            modifier = Modifier

        )
    }
}
