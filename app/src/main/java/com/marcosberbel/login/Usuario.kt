package com.marcosberbel.login

import android.os.Parcelable


data class Usuario(
    var nombre: String,
    var contrasena: String,
    var idPreguntas: ArrayList<Int>,
    var correctas: ArrayList<Int>,
    var token: String
)

data class Preguntas (
    var id :Int,
    var pregunta :String,
    var respuesta1:String,
    var respuesta2:String,
    var respuesta3:String,
    var respuesta4:String
)


data class Respuestas (
    var respuesta :String
)
