package com.example.healthcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton

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

        }
        else{
            
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
            editSenha.error = "Senha obrigatótia"
            valido = false
        }
        else if(editNome.text.isEmpty()){
            editNome.error = "Nome obrigatório"
            valido = false

        }
        else if(editProfissao.text.isEmpty()){
            editProfissao.error = "Profissao Obrigatória"
            valido = false
        }
        return valido
    }
}