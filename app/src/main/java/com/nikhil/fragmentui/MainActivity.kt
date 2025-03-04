package com.nikhil.fragmentui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    var button: Button?=null
    var button2:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button=findViewById(R.id.btnsign)
        button2=findViewById(R.id.btnsignin)
        button?.setOnClickListener()
        {
            var intent=Intent(this,signinpage::class.java)
            startActivity(intent)


        }

        button2?.setOnClickListener()
        {

            var intent1=Intent(this,Createaccount::class.java)
            startActivity(intent1)

        }

    }
}