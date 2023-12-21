package com.example.coffeeAndTea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.coffee_and_tea.R

class LoginActivity : AppCompatActivity() {
    private lateinit var btnlogin : Button
    private lateinit var editUsername : EditText
    private lateinit var editPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin = findViewById(R.id.btn_login)
        editUsername = findViewById(R.id.edit_username)
        editPassword = findViewById(R.id.edit_password)

        btnlogin.setOnClickListener {
            val userName = editUsername.text.toString()
            val passWord = editPassword.text.toString()
            startActivity(
                Intent(this, HomeActivity::class.java)
                .putExtra("username",userName)
                .putExtra("password",passWord)
            )
        }
    }
}