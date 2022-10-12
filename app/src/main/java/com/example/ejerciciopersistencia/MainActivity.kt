package com.example.ejerciciopersistencia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnListado.setOnClickListener{
            var intent = Intent(this , ListadoLibros::class.java)
            startActivity(intent)
        }
        btnIngresar.setOnClickListener{
            var intent = Intent(this , IngresarLibro::class.java)
            startActivity(intent)
        }

    }



}