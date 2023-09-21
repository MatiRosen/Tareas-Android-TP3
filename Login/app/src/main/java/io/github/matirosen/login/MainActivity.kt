package io.github.matirosen.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var olvidastePass: TextView
    lateinit var registrate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciar()
    }

    private fun iniciar() {
        button = findViewById(R.id.loginButtonId)

        val usuarioText: EditText = findViewById(R.id.usuarioEditTextId)
        val contraText: EditText = findViewById(R.id.passEditTextId)

        button.setOnClickListener {
            if (usuarioText.text.toString().equals("Mati") && contraText.text.toString().equals("Rosen")){
                Toast.makeText(this, "Entraste!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nope", Toast.LENGTH_SHORT).show()
            }
        }

        olvidastePass = findViewById(R.id.perdidaContraseñaTextViewId)
        registrate = findViewById(R.id.registrateTextViewId)

        olvidastePass.setOnClickListener {
            Toast.makeText(this, "Recordala entonces...", Toast.LENGTH_SHORT).show()
        }

        registrate.setOnClickListener {
            Toast.makeText(this, "No te registres", Toast.LENGTH_SHORT).show()
        }
    }
}