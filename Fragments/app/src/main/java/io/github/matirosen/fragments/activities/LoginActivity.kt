package io.github.matirosen.fragments.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import io.github.matirosen.fragments.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        iniciar()
    }

    private fun iniciar() {
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val txtUsuario = findViewById<EditText>(R.id.txtViewUsuario)
        val txtContra = findViewById<EditText>(R.id.txtViewContra)

        val usuario = "Matias"
        val contra = "Rosen"

        btnLogin.setOnClickListener {
            if (txtUsuario.text.toString() == usuario && txtContra.text.toString() == contra){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                Snackbar.make(it, "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
            }

        }

        val txtRecuperarContra = findViewById<TextView>(R.id.txtViewRecuperarContra)
        val txtRegistrarse = findViewById<TextView>(R.id.txtViewRegistrarse)

        txtRecuperarContra.setOnClickListener {
            Snackbar.make(it, "Recordala entonces...", Snackbar.LENGTH_SHORT).show()
        }

        txtRegistrarse.setOnClickListener {
            Snackbar.make(it, "No te registres", Snackbar.LENGTH_SHORT).show()
        }
    }
}