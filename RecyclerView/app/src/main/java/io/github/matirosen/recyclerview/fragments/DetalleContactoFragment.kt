package io.github.matirosen.recyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.github.matirosen.recyclerview.R

class DetalleContactoFragment : Fragment() {

    private lateinit var v : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_detalle_contacto, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()

        val contacto = DetalleContactoFragmentArgs.fromBundle(requireArguments()).contacto

        v.findViewById<TextView>(R.id.txtNombreChat).text = contacto.getNombre()
        v.findViewById<TextView>(R.id.txtMensajeChat).text = contacto.getUltimoMensaje()
        v.findViewById<TextView>(R.id.txtHoraChat).text = contacto.getHora()
        //v.findViewById<ImageView>(R.id.img_contact_chat).setImageResource(contacto.getIdImagen())
    }
}