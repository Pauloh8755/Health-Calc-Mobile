package com.example.healthcalc

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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

        //adicionando ouvinte de click para o botão
        btnPesar.setOnClickListener {
            //abrindo arquivo sharedPreferences para salvar o peso
            var arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            //chamando edit() para editar o arquivo
            var editor =  arquivo.edit()

            //recebendo dados
            editor.putFloat("peso", editPeso.text.toString().toFloat())
            editor.putString("atividade", spnAtividadeFisica.selectedItem.toString())

            editor.apply()
            Toast.makeText(this, "Peso registrado com sucesso", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}