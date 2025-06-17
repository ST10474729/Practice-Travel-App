package com.example.practicetravelapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Get reference to the "Main Menu" button by its ID from the XML Layout
        val mainMenubutton = findViewById<Button>(R.id.btnStart)
        //Get reference to the "Exit" button by its ID from the XML Layout
        val exitButton = findViewById<Button>(R.id.btnExit)
        //Get reference to the "welcome text" textview by its ID from the XML layout.
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        //Get reference to the "name text" textview by its ID from the XML layout.
        val nameText = findViewById<TextView>(R.id.nameText)


        //Set a click listener on the button to respond to user interaction.
        findViewById<Button>(R.id.btnStart).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        }
    }
