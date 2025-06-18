package com.example.sons.telas


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sons.R
import com.example.sons.ui.theme.BackgroundCalm
import com.example.sons.ui.theme.fonteleague
import kotlinx.coroutines.delay


@Composable
fun Splashconteudo(onTimeout: () -> Unit) {
    LaunchedEffect(Unit){
        delay(2000L)
        onTimeout()
    }
    //add fonte
    Box(
        Modifier.fillMaxSize()
            .background(color = BackgroundCalm)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icone_sem_sombra),
            contentDescription = "uma logo com uma mão segurando uma xícara na cor bege e com uma florde camomila dentro",
            modifier = Modifier
                .align(Alignment.Center)
                .width(195.dp)
                .height(199.dp)
        )
        Text(
            text = "Calmina",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontFamily = fonteleague,
            modifier = Modifier
                .align(Alignment.Center)
                .width(200.dp)
                .height(100.dp)
                .offset(y = 140.dp)
        )
    }

}