package com.jjunior.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.jjunior.estaohack.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Array para o spinner
        val listaContinentes = arrayListOf("Continente","Africa","América","Antártida","Asia","Europa","Oceania")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaContinentes)
        binding.spnCadastroContinente.adapter = spinnerAdapter



        //Botão cadastrar
        binding.btnCadastroCadastrar.setOnClickListener {

            //Dados preenchidos pelo usuario
            val nome = binding.edtCadastroNome.text.toString().trim()
            val sobrenome = binding.edtCadastroSobrenome.text.toString().trim()
            val email = binding.edtCadastroEmail.text.toString().trim()
            val senha = binding.edtCadastroSenha.text.toString().trim()
            val continente = binding.spnCadastroContinente.selectedItem.toString()

            //Verificar se todos campos foram preenchidos
            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || continente == listaContinentes[0]){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }else{

                //Armazenar os dados
                val sharedPrefs = getSharedPreferences("Cadastro $email", Context.MODE_PRIVATE)
                val editPrefs = sharedPrefs.edit()

                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("CONTINENTE", continente)

                editPrefs.apply()

                val mIntent = Intent(this, MainActivity::class.java)
                mIntent.putExtra("INTENT_EMAIL",email)
                startActivity(mIntent)

                finish()

            }
        }
    }
}