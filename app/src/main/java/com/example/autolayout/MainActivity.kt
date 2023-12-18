package com.example.autolayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var btnRegis : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.button1)
        btnRegis = findViewById(R.id.button2)

        btnLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        btnRegis.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}