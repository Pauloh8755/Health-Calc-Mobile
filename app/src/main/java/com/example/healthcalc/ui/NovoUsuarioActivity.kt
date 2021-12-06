package com.example.healthcalc.ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.healthcalc.R
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {
    // Criando objeto do tipo EditText
    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText
    lateinit var radioFeminio: RadioButton
    lateinit var radioMasculino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editNome =findViewById(R.id.edit_nome)
        editEmail =findViewById(R.id.edit_email)
        editSenha =findViewById(R.id.edit_senha)
        editProfissao=findViewById(R.id.edit_profissao)
        editAltura =findViewById(R.id.edit_altura)
        editDataNascimento =findViewById(R.id.edit_data)
        radioFeminio =findViewById(R.id.radio_feminino)
        radioMasculino =findViewById(R.id.radio_masculino)

        supportActionBar!!.title = "Nova Conta"



        //Colocar um listener de click no editText data nascimento
        //para abrir o calendario(DatePicker)
        editDataNascimento.setOnClickListener {
            criarDatePicker()
        }
    }

    private fun criarDatePicker() {
        // Criar um calendário
        //*** Obter a data atual(hoje)
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            var mesReal = month + 1
            var diaString = "$dayOfMonth"
            var mesString = "$mesReal"
            if(mesReal <10){
                mesString = "0$mesReal"
            }
            if(dayOfMonth <10){
                diaString = "0$dayOfMonth"
            }
            Log.i("xxxx","$diaString/$mesString/$year")
            //exibindo data no input
            editDataNascimento.setText("$diaString/$mesString/$year")
        },ano,mes,dia)
        datePicker.show()
    }

    //Método que carrega o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //método para inflar o menu
        menuInflater.inflate(R.menu.menu_salvar, menu)
        return true
    }

    //Método que detecta botão do menu clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(validarCampos()){
            //gravar dados com sharedPreferences (nome e modo)
            //criando ou abrindo arquivo xml(caso já exista) chamado usuário
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            //chamando edit() para editar arquivo
            val editor = arquivo.edit()
            //recebendo dados no arquivo
            editor.putString("email", editEmail.text.toString())
            editor.putString("senha", editSenha.text.toString())
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putFloat("altura", editAltura.text.toString().toFloat())
            editor.putString("nascimento", editDataNascimento.text.toString())
            editor.putString("sexo", if(radioMasculino.isChecked) "M" else "F")
            //gravando
            editor.apply()

            Toast.makeText(this, "Usuário cadastrado com sucesso!!", Toast.LENGTH_SHORT).show()

            //encerrando activity
            finish()
        }
        else{
            //grava nada!!
        }
        return true
    }
    //criando função para validar campos (visibilidade, nome,  tipo retorno)
    private fun validarCampos() : Boolean{
        var valido = true
        //se estiver vazio isEmpty(retorna true ou false)
        if(editEmail.text.isEmpty()){
            editEmail.error = "Por favor insira seu E-mail"
            valido = false
        }
        else if(editSenha.text.isEmpty()){
            editSenha.error = "Senha obrigatório"
            valido = false
        }
        else if(editNome.text.isEmpty()){
            editNome.error = "Nome obrigatório"
            valido = false

        }
        else if(editAltura.text.isEmpty()){
            editAltura.error = "Altura Obrigatório"
            valido = false
        }
        else if(editDataNascimento.text.isEmpty()){
            editDataNascimento.error = "Data de nascimento Obrigatório"
            valido = false
        }
        else if(!radioFeminio.isChecked && !radioMasculino.isChecked){
            radioMasculino.error = "Gênero é obrigatório"
            valido = false
        }
        return valido
    }
}