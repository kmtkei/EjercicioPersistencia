package com.example.ejerciciopersistencia

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autor")
class Autor (
    val Nombre:String,
    val Apellido:String,
    val imagen:String,
    @PrimaryKey(autoGenerate = true)
    var idAutor:Int = 0):java.io.Serializable