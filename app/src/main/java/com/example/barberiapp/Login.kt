package com.example.barberiapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class Login : AppCompatActivity() {


    lateinit var usuario: EditText
    lateinit var contrasena: EditText

    // obtencion de variables de Registro
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //var objetoIntent: Bundle? = intent.extras
        // para obtener variables totales que le llegan de Registro
        var nombre:String= data?.extras?.getString("Correo").toString()
        var claves:String= data?.extras?.getString("pass").toString()

        if((requestCode==1 ) && (resultCode==Activity.RESULT_OK) ){
            et_Ingreso.setOnClickListener {
                // comparacion
                var name:String = usuario.text.toString()
                var pass: String = contrasena.text.toString()
                ///////// si los campos estan vacios
                if (TextUtils.isEmpty(name)){
                    user.error = "Ingrese nombre de usuario"
                    return@setOnClickListener
                }
                else if (TextUtils.isEmpty(pass)) {
                    contra.error = "Ingrese Contraseña"
                    return@setOnClickListener
                         }
                ///////////////////////////// junto con las variables que devuelve Main
                else {  if ((name == nombre ) && (pass == claves) ) {

                    val intent = Intent(this, MainActivity::class.java)

                    intent.putExtra("Correo", name).toString()
                    intent.putExtra("pass", pass).toString()


                    // user.text.clear()
                    //contra.text.clear()
                    startActivity(intent)
                    finish()
                            }
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usuario = findViewById(R.id.user) as EditText
        contrasena = findViewById(R.id.contra) as EditText

        /// para obtener los datos otra vez
        var objetoIntent: Bundle? = intent.extras
        var Nombre = objetoIntent?.getString("Correo").toString()
        var Clavee = objetoIntent?.getString("pass").toString()

        // LOGGIN
        et_Ingreso.setOnClickListener {
            // comparacion
           var name:String = usuario.text.toString()
            var pass: String = contrasena.text.toString()
            ///////// si los campos estan vacios

            if ((name != Nombre ) || (pass != Clavee) ) {
                Toast.makeText(this, "  Datos erroneos o no has ingresado datos ", Toast.LENGTH_SHORT).show()
            }

            else if (TextUtils.isEmpty(name)){
                user.error = "Ingrese nombre de usuario"
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(pass)) {
                contra.error = "Ingrese Contraseña"
                return@setOnClickListener
            }
            ///////////////////////////// junto con las variables que devuelve Main
            else   if ((name == Nombre ) && (pass == Clavee) ) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Correo",name).toString()
                intent.putExtra("pass",pass).toString()

               // user.text.clear()
                //contra.text.clear()
                startActivity(intent)
                finish()
            }
        }

        // REGISTRO
        et_registro.setOnClickListener {
            val intent= Intent(this, Registro::class.java)
            startActivityForResult(intent,1)
        }



    }




    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show()
    }

}












