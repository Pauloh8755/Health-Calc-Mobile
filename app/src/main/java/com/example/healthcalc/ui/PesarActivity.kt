package com.example.healthcalc.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.healthcalc.R
import com.example.healthcalc.utils.obterDataAtual
import java.time.LocalDate

class PesarActivity : AppCompatActivity(){
    //criando objeto editText
    lateinit var editPeso: EditText
    lateinit var btnPesar: Button
    lateinit var spnAtividadeFisica : Spinner

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesar)
        supportActionBar!!.hide()

        //recebendo data atual no edit text
        val dataPesagem = findViewById<TextView>(R.id.data_pesagem)
        dataPesagem.text = obterDataAtual()

        //recebendo editText através do id
        editPeso = findViewById(R.id.edit_peso)
        btnPesar = findViewById(R.id.btn_pesar)
        spnAtividadeFisica = findViewById(R.id.spn_atividade)

        //adicionando ouvinte de click para o botão
        btnPesar.setOnClickListener {
            gravarPeso()
        }
    }

    private fun gravarPeso(){
        //abrindo arquivo sharedPreferences para salvar o peso
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        //chamando edit() para editar o arquivo
        val editor =  arquivo.edit()

        //obter dados ja inseridos
        val peso = arquivo.getString("peso", "")
        val dataPesagem = arquivo.getString("nascimento", "")

        //recebendo dados
        editor.putString("nascimento", "$dataPesagem;${LocalDate.now()}")
        editor.putString("peso", "$peso;${editPeso.text}")
        editor.putInt("atividade", spnAtividadeFisica.selectedItemPosition)

        editor.apply()
        Toast.makeText(this, "Peso registrado com sucesso", Toast.LENGTH_LONG).show()
        finish()
    }
}