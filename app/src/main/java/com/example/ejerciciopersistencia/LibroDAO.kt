package com.example.ejerciciopersistencia

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LibroDAO {
    @Query("SELECT * FROM Libro")
    fun obtenerLibros():LiveData<List<Libro>>
    @Query("SELECT * FROM Libro WHERE idLibro = :id")
    fun obtenerLibro(id:Int):LiveData<Libro>
    @Insert
    fun insertarLibro(vararg libro: Libro):List<Long>
    @Delete
    fun eliminarLibro(libro: Libro)
    @Update
    fun actualizarLibro(libro: Libro)
}