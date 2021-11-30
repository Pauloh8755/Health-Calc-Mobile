package com.example.healthcalc.utils

import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.roundToInt

fun calcularIMC(peso: Float, altura: Float): Int{
   val imc = (peso / altura.pow(2)).roundToInt()
   return imc
}

fun calcularNCD(peso: Float,sexo: String, idade: Int, atividade: String): Int{
    var ncd = 0.0
    if(sexo.equals('M')){
        if(idade in 18..30){
            ncd = 15.3*peso+679
        }
        else if(idade in 31..60){
            ncd = 11.6*peso+879
        }
        else if(idade > 60){
            ncd = 13.5*peso+487
        }
        if(atividade.equals("leve")){
            ncd = ncd * 1.5
        }
        else if(atividade.equals("moderada")){
            ncd = ncd * 1.8
        }
        else{
            ncd = ncd * 2.1
        }
    }
    else{
        if(idade in 18..30){
            ncd = 14.7*peso+492
        }
        else if(idade in 31..60){
            ncd = 8.7*peso+829
        }
        else if(idade > 60){
            ncd = 10.5*peso+596
        }
        if(atividade.equals("leve")){
            ncd = ncd * 1.6
        }
        else if(atividade.equals("moderada")){
            ncd = ncd * 1.6
        }
        else{
            ncd = ncd * 1.8
        }
    }
    return  ncd.roundToInt()
}