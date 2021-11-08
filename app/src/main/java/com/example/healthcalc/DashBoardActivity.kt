package com.example.healthcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashBoardActivity : AppCompatActivity() {
    //Declarando textView's com inicialização atrasada
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        tvNome = findViewById(R.id.text_nome)
        tvProfissao = findViewById(R.id.text_profissao)
        tvAltura = findViewById(R.id.text_altura)

        preencherDashBoard()
    }
    private fun preencherDashBoard(){
        //abrindo arquivo sharedPreferences usuario
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        //recebendo valores dos textView's
        tvNome.text = arquivo.getString("nome","")
        tvProfissao.text = arquivo.getString("profissao", "--")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
    }
}

