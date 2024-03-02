package com.example.guidegap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class CrearCuentaActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)
        val txtnombre_nuevo : TextView = findViewById(R.id.edtNombre)
        val txtcorreo : TextView = findViewById(R.id.edtcorreo)
        val txtcontraseña : TextView = findViewById(R.id.edtContraseña)
        val txtconfirmar : TextView = findViewById(R.id.edtConfContraseña)
        val btncrear : Button = findViewById(R.id.btnCrearCuentaNueva)
        btncrear.setOnClickListener()
        {
            var pass1 = txtcontraseña.text.toString()
            var pass2 = txtconfirmar.text.toString()
            if (pass1.equals(pass2))
            {
                creaAccount(txtcorreo.text.toString(), txtcontraseña.text.toString())
            }
            else
            {
                Toast.makeText(baseContext,"Error:La Contraseña no Coincide",Toast.LENGTH_SHORT).show()
                txtcontraseña.requestFocus()
            }


            }
        firebaseAuth= Firebase.auth
    }
    private fun creaAccount(email:String, password:String)
    {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->
            if (task.isSuccessful)
            {
                Toast.makeText(baseContext,"Cuneta Creada Correctamente",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(baseContext,"UPS Algo Salio Mal"+ task.exception,Toast.LENGTH_SHORT).show()
            }
        }
    }
}