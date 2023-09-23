package io.github.matirosen.navgraph.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.matirosen.navgraph.R

class ProfileFragment : Fragment() {

    private lateinit var v: View

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_profile, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()
        val user = ProfileFragmentArgs.fromBundle(requireArguments()).user

        val email = v.findViewById<TextView>(R.id.txtEmail)
        val pass = v.findViewById<TextView>(R.id.txtPass)
        email.text = user.getEmail()
        pass.text = user.getPassword()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}