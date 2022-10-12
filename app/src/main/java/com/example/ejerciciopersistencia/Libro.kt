package com.example.ejerciciopersistencia

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Libro")
class Libro (
val nombre:String,
val descripcion:String,
val disponibilidad:Boolean,
val imagen:String,
@PrimaryKey(autoGenerate = true)
var idLibro:Int = 0):java.io.Serializable