package com.example.ejerciciopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingresar_libro.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IngresarLibro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_libro)
        guardar.setOnClickListener{
            registrarLibro()
        }
    }

    fun registrarLibro(){
        val basedatos  = BaseDatos.obtenerBaseDatos(this)
        val nombre = etnombre.text.toString()
        val descripcion= etnombre.text.toString()
        var disponibilidad = false
        if(etdisponibilidad.text.toString() == "disponible"){
            disponibilidad = true
        }
        val libro  = Libro(nombre, descripcion, disponibilidad, "https://4.bp.blogspot.com/-p3WLzI73jiU/W3F9nOfRZdI/AAAAAAAABOU/6Umu0QlXe4UZCnvE_MR2_8tJh2NWZ1jPwCLcBGAs/s1600/libro.png")
        CoroutineScope(Dispatchers.IO).launch {
            val id = basedatos.Libros().insertarLibro(libro)[0]
            this@IngresarLibro.finish()
        }

    }
}