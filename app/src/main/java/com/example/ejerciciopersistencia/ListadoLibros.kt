package com.example.ejerciciopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listado_libros.*

class ListadoLibros : AppCompatActivity() {

    private lateinit var basedatos :BaseDatos
    private lateinit var libro: Libro
    private lateinit var libroliveData: LiveData<Libro>
    private val Editar = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_libros)
        cargarLibros()
    }

    fun cargarLibros(){
        var listaLibros = emptyList<Libro>()
        val basedatos = BaseDatos.obtenerBaseDatos(this)
        basedatos.Libros().obtenerLibros().observe(this, Observer{
            ListaLibros.layoutManager = LinearLayoutManager(this)
            listaLibros = it
            val adaptador = LibroAdapter(this, listaLibros)
            ListaLibros.adapter = adaptador
        })
    }

    /*fun iniciarRecycler(){

        val adapter = LibroAdapter(listaLibros)
        ListaLibros.adapter = adapter
    }*/
}
