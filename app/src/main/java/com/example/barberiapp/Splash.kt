package com.example.barberiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import java.util.*
import kotlin.concurrent.timerTask

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        val timer = Timer()
        timer.schedule(timerTask {
            goToMainActivity()

        }, 2000 )

    }

    private fun goToMainActivity() {
        val intent = Intent(this , Login::class.java)
        startActivity(intent)
        finish()
    }





}
