package com.example.healthcalc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.healthcalc.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        //criando instancia dos EditText
        val editEmail =findViewById<EditText>(R.id.edit_email_login)
        val editSenha = findViewById<EditText>(R.id.edit_senha_login)

        //Criando instancia do botão entrar
        val buttonEntrar = findViewById<Button>(R.id.btn_entrar)
        buttonEntrar.setOnClickListener{
            //abrindo arquivo usuario sharedPreferences
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            //recebendo dados de login
            val email = arquivo.getString("email", "")
            val senha = arquivo.getString("senha", "")

            //validando login
            if(editEmail.text.toString() == email && editSenha.text.toString() == senha ){
                val abrirDashBoard = Intent(this, DashBoardActivity::class.java)
                startActivity(abrirDashBoard)
            }
            else{
                Toast.makeText(this, "Senha ou E-mail incorretos", Toast.LENGTH_SHORT).show()
            }
        }

        //Criando instancia do botão novo usuario
        val buttonNovoUser =  findViewById<Button>(R.id.btn_novo_user)
        buttonNovoUser.setOnClickListener {
            val abrirNovaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovaConta)
        }
    }
}