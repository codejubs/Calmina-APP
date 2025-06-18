package com.example.sons.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sons.telas.HomeScreen
import com.example.sons.telas.SecaoCinco
import com.example.sons.telas.SecaoDois
import com.example.sons.telas.SecaoQuatro
import com.example.sons.telas.SecaoTres
import com.example.sons.telas.SecaoUm
import com.example.sons.telas.Splashconteudo
import com.example.sons.ui.theme.SonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //navegação
            SonsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController,
                    startDestination = "splash"
                )
                {
                    composable("splash") {
                        Splashconteudo {
                            navController.navigate("home")
                            {
                                popUpTo("splash") {
                                    inclusive = true
                                }
                            }
                        }
                    }
                    composable("Home") {
                        HomeScreen(navController)
                    }
                    composable("secao1") {
                        SecaoUm(navController)
                    }
                    composable("secao2") {
                        SecaoDois(navController)
                    }
                    composable("secao3") {
                        SecaoTres(navController)
                    }
                    composable("secao4") {
                        SecaoQuatro(navController)
                    }
                    composable("secao5"){
                        SecaoCinco(navController)
                    }

                }
            }

            }

        }

    }