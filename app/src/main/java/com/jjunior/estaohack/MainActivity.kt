package com.jjunior.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.jjunior.estaohack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recuperando o valor passado pela intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //Acessar o xml referente ao cadastro do usuario logado (identificando pelo email)
        val sharedPrefs = getSharedPreferences("Cadastro $email", Context.MODE_PRIVATE)

        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME","")
        val continente = sharedPrefs.getString("CONTINENTE","")

        //exibir os dados cadastrados
        binding.txvMainNome.text = "$nome $sobrenome"
        binding.txvMainEmail.text = email
        binding.txvMainContinente.text = continente

        //botão sair
        binding.btnMainSair.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Atenção")
            alert.setMessage("Deseja sair?")

            //btn a direita
            alert.setPositiveButton("Sair"){dialog, which ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finish()
            }

            //btn a esquerda
            alert.setNeutralButton("Não"){dialog, which -> }

            //alert.setCancelable(false) opcional

            alert.show()
        }

        //botão site
        binding.btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }

}