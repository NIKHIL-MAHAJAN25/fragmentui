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

class Createaccount : AppCompatActivity() {
    var signin: Button?=null
    var emailfield1:EditText?=null
    var psswrdfield1:TextInputEditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_createaccount)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        emailfield1=findViewById(R.id.mailbelow)
        psswrdfield1=findViewById(R.id.psswrd1below)
        intent?.let{
            val mailrec=it.getStringExtra("EMAIL")
            val passrec=it.getStringExtra("PASSWORD")
            if(!mailrec.isNullOrEmpty()) emailfield1?.setText(mailrec)
            if(!passrec.isNullOrEmpty()) psswrdfield1?.setText(passrec)
        }
        signin=findViewById(R.id.btn_bottom)
        signin?.setOnClickListener {
            val email=emailfield1?.text.toString()
            val password=psswrdfield1?.text.toString()
            val intent= Intent(this,signinpage::class.java).apply {
                putExtra("EMAIL", email)
                putExtra("PASSWORD", password)

        }
            startActivity(intent)


        }

    }
}
