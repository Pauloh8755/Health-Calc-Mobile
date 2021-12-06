package com.example.healthcalc.utils

import kotlin.math.pow
import kotlin.math.roundToInt

fun calcularIMC(peso: Float, altura: Float): Int{
   val imc = (peso / altura.pow(2)).roundToInt()
   return imc
}

fun calcularNCD(peso: Float, sexo: String, idade: Int, atividade: Int): Int{
    var ncd = 0.0

    if(sexo == "M"){
        //Quando a idade estiver entre 18 e 30
        when {
            idade in 18..30 -> {
                ncd = 15.3*peso+679

            }
            idade in 31..60 -> {
                ncd = 11.6*peso+879

            }
            idade > 60 -> {
                ncd = 13.5*peso+487
            }

        }

        //multiplicar ncd por ... quando atividade for igual a ...
        ncd *= when (atividade) {
            0 -> {
                1.5
            }
            1 -> {
                1.8
            }
            else -> {
                2.1
            }
        }
    }
    else{
        when {
            idade in 18..30 -> {
                ncd = 14.7*peso+492
            }
            idade in 31..60 -> {
                ncd = 8.7*peso+829
            }
            idade > 60 -> {
                ncd = 10.5*peso+596
            }

        }
        ncd *= when (atividade) {
            0 -> {
                1.6
            }
            1-> {
                1.6
            }
            else -> {
                1.8
            }
        }
    }
    return  ncd.roundToInt()
}