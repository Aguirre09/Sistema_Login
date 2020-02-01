package com.example.barberiapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  txtSaludo: TextView
     lateinit var  txt_pass : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      txtSaludo = findViewById(R.id.txtSaludo) as TextView
      txt_pass = findViewById(R.id.txt_pass) as TextView


        var objetoIntent: Bundle? = intent.extras
        var Nombre = objetoIntent?.getString("Correo").toString()
        var Clave = objetoIntent?.getString("pass").toString()

        txtSaludo.text= Nombre
        txt_pass.text = Clave
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.Out -> {
                var name: String = txtSaludo.text.toString()
                var pass: String = txt_pass.text.toString()
                val intent = Intent(this, Login::class.java)
                intent.putExtra("Correo",name).toString()
                intent.putExtra("pass",pass).toString()
                startActivity(intent)
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)

            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        //var name: String = txtSaludo.text.toString()
        //var pass: String = txt_pass.text.toString()
        val intent = Intent(this, Login::class.java)
        //intent.putExtra("Correo",name).toString()
        //intent.putExtra("pass",pass).toString()
        startActivity(intent)
        finish()
    }
}
