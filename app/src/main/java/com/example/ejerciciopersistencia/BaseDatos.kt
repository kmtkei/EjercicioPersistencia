package com.example.ejerciciopersistencia

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Libro::class], version=1)
abstract  class BaseDatos : RoomDatabase(){
abstract   fun Libros():LibroDAO

companion object{
    @Volatile
    private var INSTANCIA:BaseDatos? = null
    fun obtenerBaseDatos(contexto:Context):BaseDatos{
        val bdInstancia = INSTANCIA
        if (bdInstancia != null){
            return bdInstancia
        }

        synchronized(this){
            val instancia = Room.databaseBuilder(
                contexto.applicationContext,
                BaseDatos::class.java,
                "biblioApp"
            ).build()
            INSTANCIA = instancia
            return instancia
        }
    }
}

}