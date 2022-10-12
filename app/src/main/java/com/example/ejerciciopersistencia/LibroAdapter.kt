package com.example.ejerciciopersistencia

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.libro_item.view.*

class LibroAdapter(val contexto:Context, val libro:List<Libro>):RecyclerView.Adapter<LibroAdapter.Holder>() {

    class Holder(val vista: View):RecyclerView.ViewHolder(vista){
        fun render(libro: Libro){
            vista.txtNombre.text = libro.nombre
            vista.txtDescripcion.text = libro.descripcion
            var disponibilidad = ""
            if( libro.disponibilidad == true){
                disponibilidad = "Disponible"
            }else{
                disponibilidad = "Agotado"
            }
            vista.txtDisponibilidad.text = disponibilidad
            Picasso.get().load(libro.imagen).into(vista.imgLibro)

            vista.setOnClickListener{
                var intent = Intent(vista.getContext() , DescripcionLibro::class.java)
                intent.putExtra("nombre", libro.nombre)
                vista.getContext().startActivity(intent)
                Toast.makeText(vista.context, "asldkfjalsfd", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.libro_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.render(libro[position])
    }

    override fun getItemCount(): Int {
        return libro.size
    }

}