package com.jjunior.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    //onCreate é um dos métodos presente no ciclo de vida da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Método que faz referência a nossa activity splash res/layout/activity_splash
        setContentView(R.layout.activity_splash)

        //Abrir a MainActivity após 5 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //postDelayed passar como argumento uma função lambda {}

            //Iniciar uma intent - transição da tela Splash para a tela Main
            //Selecionar Intent() segura alt e aperta entre pra importar as bibliotecas
            val mIntent = Intent(this, MainActivity::class.java)

            startActivity(mIntent) //Iniciar Essa tela (as telas ficam empilhadas)
            //Nesse ponto vamos finalizar a tela SplashScreen

            finish()
        }, 5000) //5000ms
    }
}