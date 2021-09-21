package com.jjunior.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jjunior.estaohack.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Login
        binding.btnLoginEntrar.setOnClickListener {


            //Passar pras val os dados inseridos pelo user
            val email = binding.editLoginEmail.text.toString().trim()
            val senha = binding.editLoginSenha.text.toString().trim()

            //Verificar se todos os campos foram preenchidos
            if(email.isEmpty()){
                binding.editLoginEmail.error = "Campo obrigatório"
                binding.editLoginEmail.requestFocus()

            }
            else if(senha.isEmpty()){
                binding.editLoginSenha.error = "Campo obrigatório"
                binding.editLoginSenha.requestFocus()

            }else{

                //Recuperar do arquivo .xml as informações salvas no cadastro
                val sharedPrefs = getSharedPreferences("Cadastro $email", Context.MODE_PRIVATE)
                val emailPrefs = sharedPrefs.getString("EMAIL","")
                val senhaPrefs = sharedPrefs.getString("SENHA","")

                //Verificar se as informações inseridas no email e senha são iguais as cadastradas
                if(email == emailPrefs && senha == senhaPrefs){
                    Toast.makeText(this, "Usuário logado!", Toast.LENGTH_LONG).show()

                    val mIntent = Intent(this, MainActivity::class.java)
                    mIntent.putExtra("INTENT_EMAIL", email)

                    startActivity(mIntent)
                    finish()

                }else{
                    Toast.makeText(this,"Email ou senha inválidos!", Toast.LENGTH_LONG).show()
                }
            }

        }

        //Cadastro
        binding.btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}
