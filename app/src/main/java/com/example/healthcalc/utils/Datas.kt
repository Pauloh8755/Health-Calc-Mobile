package com.example.healthcalc.utils

import android.util.Log
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.format.DateTimeFormatter


fun calcularIdade(dataNascimento: String): Int{
    //Obter a data atual
    val hoje = LocalDate.now()

    //separando data
    val data = dataNascimento.split("/")

    //converter data de nascimento (String)em LocalDate
    val dataNascimento = LocalDate.of(data.get(2).toInt(),data.get(1).toInt(),data.get(0).toInt())

    //calcular intervalo entre a data atual e a data de nascimento
    val idade = dataNascimento.until(hoje, ChronoUnit.YEARS).toInt()
    return idade
}
fun obterDataAtual():String{
    val hoje = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataAtual =  hoje.format(formatter)
//    val data = hoje.split("-")
//    val dataAtual = data.get(2) + "/" + data.get(1) + "/" + data.get(0)
    return dataAtual.toString()
}