package com.example.healthcalc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.healthcalc.R
import com.example.healthcalc.utils.calcularIdade
import com.example.healthcalc.utils.calcularIMC
import com.example.healthcalc.utils.calcularNCD

class DashBoardActivity : AppCompatActivity() {
    //Declarando textView's com inicialização atrasada
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        tvNome = findViewById(R.id.text_nome)
        tvProfissao = findViewById(R.id.text_profissao)
        tvAltura = findViewById(R.id.text_altura)
        tvPeso = findViewById(R.id.text_peso)
        tvIdade = findViewById(R.id.text_idade)
        tvImc = findViewById(R.id.edit_imc)
        tvNcd = findViewById(R.id.edit_ncd)

        preencherDashBoard()

        //criando instância do card para entrar na tela pesar
        val viewPesar = findViewById<RelativeLayout>(R.id.view_pesar)
        viewPesar.setOnClickListener{
            val abrirPesar = Intent(this, PesarActivity::class.java)
            startActivity(abrirPesar)
        }


    }
    private fun preencherDashBoard(){
        //abrindo arquivo sharedPreferences usuario
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val dataNascimento = arquivo.getString("nascimento","").toString()

        //recebendo valores dos textView's
        val peso = arquivo.getFloat("peso",0.0f)
        val altura = arquivo.getFloat("altura",0.0f)
        val sexo = arquivo.getString("sexo", "").toString()
        val idade = calcularIdade(dataNascimento)
        val atividade = arquivo.getInt("atividade", 0)

        tvNome.text = arquivo.getString("nome","")
        tvProfissao.text = arquivo.getString("profissao", "--")
        tvAltura.text = altura.toString()
        tvPeso.text = peso.toString()
        tvIdade.text = idade.toString()
        tvImc.text = calcularIMC(peso,altura).toString()
        tvNcd.text = calcularNCD(peso,sexo,idade,atividade).toString()
    }
}

