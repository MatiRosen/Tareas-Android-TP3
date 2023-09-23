package io.github.matirosen.navgraph.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import io.github.matirosen.navgraph.R
import io.github.matirosen.navgraph.entities.User

class LoginFragment : Fragment() {

    private lateinit var v: View

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_login, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()

        val btnLogin = v.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = v.findViewById<EditText>(R.id.editTextTextEmailAddress)
            val password = v.findViewById<EditText>(R.id.editTextTextPassword)

            val user = User(email.text.toString(), password.text.toString())
            val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(user)
            v.findNavController().navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}