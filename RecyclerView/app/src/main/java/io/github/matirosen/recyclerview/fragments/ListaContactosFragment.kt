package io.github.matirosen.recyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import io.github.matirosen.recyclerview.R
import io.github.matirosen.recyclerview.adapters.ContactoListAdapter
import io.github.matirosen.recyclerview.entities.Contacto
import io.github.matirosen.recyclerview.listeners.OnViewItemClickedListener

class ListaContactosFragment : Fragment(), OnViewItemClickedListener {

    private lateinit var v : View
    private lateinit var recyclerContactos : RecyclerView
    private lateinit var btnAgregarContacto : Button

    private var contactos : MutableList<Contacto> = ArrayList()

    private lateinit var contactoListAdapter: ContactoListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_lista_contactos, container, false)

        recyclerContactos = v.findViewById(R.id.recycler_contactos)
        btnAgregarContacto = v.findViewById(R.id.btnAgregarContacto)

        // Lo hacemos acá para que no se vuelva a agregar el contacto cuando sale de la app y vuelve a entrar
        if (contactos.size == 0) {
            agregarContactos()
        }

        return v
    }

    private fun agregarContactos(){
        val contacto = ListaContactosFragmentArgs.fromBundle(requireArguments()).contacto

        if ((contacto != null) && (contacto.getNombre() != "")) {
            contactos.add(contacto)
        }

        contactos.add(Contacto("Pedro", "Buen día!","15:45", 0))
        contactos.add(Contacto("Rodolfo", "Hola!","15:43", 1))
        contactos.add(Contacto("Emilio", "Buenas tardes!","12:42", 2))
        contactos.add(Contacto("Luis", "Buenas noches!","11:32", 3))
        contactos.add(Contacto("Carlos", "¿Como estas?","10:45", 4))
    }

    override fun onStart() {
        super.onStart()

        btnAgregarContacto.setOnClickListener {
            val action = ListaContactosFragmentDirections.actionListaContactosFragmentToAgregarContactoFragment()
            v.findNavController().navigate(action)
        }

        requireActivity()
        recyclerContactos.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerContactos.layoutManager = linearLayoutManager
        contactoListAdapter = ContactoListAdapter(contactos, this)
        recyclerContactos.adapter = contactoListAdapter
    }

    override fun onViewItemDetail(contacto: Contacto) {
        val action = ListaContactosFragmentDirections.actionListaContactosFragmentToDetalleContactoFragment(contacto)
        this.findNavController().navigate(action)
    }

}