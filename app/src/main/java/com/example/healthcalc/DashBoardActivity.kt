package com.example.healthcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.healthcalc.utils.calcularIdade

class DashBoardActivity : AppCompatActivity() {
    //Declarando textView's com inicialização atrasada
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var tvIdade: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        tvNome = findViewById(R.id.text_nome)
        tvProfissao = findViewById(R.id.text_profissao)
        tvAltura = findViewById(R.id.text_altura)
        tvIdade = findViewById(R.id.text_idade)

        preencherDashBoard()
    }
    private fun preencherDashBoard(){
        //abrindo arquivo sharedPreferences usuario
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val dataNascimento = arquivo.getString("nascimento","").toString()

        //recebendo valores dos textView's
        tvNome.text = arquivo.getString("nome","")
        tvProfissao.text = arquivo.getString("profissao", "--")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()

        tvIdade.text = calcularIdade(dataNascimento).toString()
    }
}

