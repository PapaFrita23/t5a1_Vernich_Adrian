package com.example.t5a1_vernich_adrian

data class Comida (var name:String, var url:String, var wiki : String) {
    fun getFullName(): String = "$name"
}