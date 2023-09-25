package io.github.matirosen.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.matirosen.recyclerview.R
import io.github.matirosen.recyclerview.entities.Contacto
import io.github.matirosen.recyclerview.holders.ContactoHolder
import io.github.matirosen.recyclerview.listeners.OnViewItemClickedListener

class ContactoListAdapter(
    private val listaContactos: MutableList<Contacto>,
    private val onItemClick: OnViewItemClickedListener

) : RecyclerView.Adapter<ContactoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)

        return ContactoHolder(view)
    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {
        val contacto = listaContactos[position]

        holder.setNombre(contacto.getNombre())
        holder.setImagen(contacto.getIdImagen())
        holder.setHora(contacto.getHora())
        holder.setUltimoMensaje(contacto.getUltimoMensaje())

        holder.getCardLayout().setOnClickListener {
            onItemClick.onViewItemDetail(contacto)
        }
    }
}