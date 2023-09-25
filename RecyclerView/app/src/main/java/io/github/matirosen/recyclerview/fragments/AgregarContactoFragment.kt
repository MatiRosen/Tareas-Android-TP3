package io.github.matirosen.recyclerview.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import io.github.matirosen.recyclerview.R
import io.github.matirosen.recyclerview.entities.Contacto

class AgregarContactoFragment : Fragment() {

    private lateinit var v : View
    private lateinit var btnGuardarContacto : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_agregar_contacto, container, false)
        btnGuardarContacto = v.findViewById(R.id.btnGuardarContacto)

        return v
    }

    override fun onStart() {
        super.onStart()
        btnGuardarContacto.setOnClickListener {
            val nombre = v.findViewById<EditText>(R.id.editTxtNombre).text.toString()
            val ultimoMensaje = v.findViewById<EditText>(R.id.editTxtUltMsg).text.toString()
            val horaUltimoMsg = v.findViewById<EditText>(R.id.editTxtHora).text.toString()

            if (nombre.isNotEmpty() && ultimoMensaje.isNotEmpty() && horaUltimoMsg.isNotEmpty()){
                val contacto = Contacto(nombre, ultimoMensaje, horaUltimoMsg, 0)
                val action = AgregarContactoFragmentDirections.actionAgregarContactoFragmentToListaContactosFragment(contacto)
                v.findNavController().navigate(action)
                //v.findNavController().navigateUp()
            } else {
                Snackbar.make(v, "Por favor, complete todos los campos", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}