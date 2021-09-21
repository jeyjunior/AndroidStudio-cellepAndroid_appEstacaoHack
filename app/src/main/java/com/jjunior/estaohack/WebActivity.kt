package com.jjunior.estaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.jjunior.estaohack.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Habilitar execução js
        binding.wbvWeb.settings.javaScriptEnabled = true

        //load url
        binding.wbvWeb.loadUrl("https://br.cellep.com/estacaohack")

        //Definindo webview cliente padrão
        binding.wbvWeb.webViewClient = WebViewClient()

    }
}