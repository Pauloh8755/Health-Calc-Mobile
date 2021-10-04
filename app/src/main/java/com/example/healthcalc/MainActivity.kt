package com.example.healthcalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        //Criando instancia do botão entrar
        val buttonEntrar = findViewById<Button>(R.id.btn_entrar)
        buttonEntrar.setOnClickListener{
            val abrirDashBoard = Intent(this, DashBoardActivity::class.java)
            startActivity(abrirDashBoard)
        }
    }
}