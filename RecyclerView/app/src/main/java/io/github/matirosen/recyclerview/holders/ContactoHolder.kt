package io.github.matirosen.recyclerview.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.matirosen.recyclerview.R

class ContactoHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var view: View

    init {
        this.view = view
    }

    fun setImagen(idImagen: Int) {
        // Por ahora seteamos imagen por defecto
        val img: ImageView = view.findViewById(R.id.imgPerfil)
        img.setImageResource(R.drawable.perro)

        /*val img: ImageView = view.findViewById(R.id.imgPerfil)
        img.setImageResource(idImagen)*/
    }
    fun setNombre(nombre: String) {
        val txt : TextView = view.findViewById(R.id.txtNombre)
        txt.text = nombre
    }

    fun setUltimoMensaje(ultimoMensaje: String) {
        val txt : TextView = view.findViewById(R.id.txtUltimoMensaje)
        txt.text = ultimoMensaje
    }
    fun setHora(hora: String) {
        val txt : TextView = view.findViewById(R.id.txtHora)
        txt.text = hora
    }

    fun getCardLayout(): View {
        return view.findViewById(R.id.card_view_item)
    }
}