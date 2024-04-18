package com.cfuentes.clases6

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var btEnviar: FloatingActionButton
    lateinit var etNombre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btEnviar = findViewById(R.id.btEnviar)
        etNombre = findViewById(R.id.etNombre)
        btEnviar.setOnClickListener {
            validarDatos()
        }
    }

    private fun validarDatos() {
        //Validaciones
        //1-> Largo del texto max 20
        //2-> Minimo del texto min 1
        //3-> Solo texto "A-Za-z "
        val nombre = etNombre.text.toString()
        val a:Boolean = validarNombre(nombre)
        if (a){
            Toast.makeText(this,"Formulario enviado correctamente",Toast.LENGTH_SHORT).show()
        }
    }

    private fun validarNombre(nombre: String): Boolean {
        val patron : Pattern = Pattern.compile("^[A-Za-z ]+$")
        if(nombre.length <=20 && nombre.length >=1 && patron.matcher(nombre).matches()) {
            return true
        }
        else{
            etNombre.setError("Nombre invalido")
            return false
        }

    }


}