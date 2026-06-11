package com.example.miproyecto

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ctUsuario: EditText=findViewById(R.id.ctUsuario)
        val ctContraseña: EditText=findViewById(R.id.ctContraseña)
        val btnAcceder: Button=findViewById(R.id.btnAcceder)

        btnAcceder.setOnClickListener{
            if(ctUsuario.text.toString()=="admin")
            {
                if (ctContraseña.text.toString()=="12345")
                {
                    val intento= Intent(this,Principal::class.java)
                    startActivity(intento)
                }
                else
                {
                    Toast.makeText(this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "USUARIO INCORRECTO", Toast.LENGTH_SHORT).show()
            }
        }
    }
}