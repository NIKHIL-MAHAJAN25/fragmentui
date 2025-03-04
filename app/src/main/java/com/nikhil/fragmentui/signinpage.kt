package com.nikhil.fragmentui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class signinpage : AppCompatActivity() {
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signinpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var emailField = findViewById<EditText>(R.id.mail)
        var passwordField = findViewById<TextInputEditText>(R.id.passwordEditText)
        intent?.let {
            val receivedEmail = it.getStringExtra("EMAIL")
            val receivedPassword = it.getStringExtra("PASSWORD")

            if (!receivedEmail.isNullOrEmpty()) emailField.setText(receivedEmail)
            if (!receivedPassword.isNullOrEmpty()) passwordField.setText(receivedPassword)
        }
        button = findViewById(R.id.btn_signdata)
        button?.setOnClickListener {
            val email = emailField?.text.toString()
            val password = passwordField?.text.toString()
            val intent = Intent(this, Createaccount::class.java).apply {
                putExtra("EMAIL", email)
                putExtra("PASSWORD", password)
            }
            startActivity(intent)

        }

    }
}