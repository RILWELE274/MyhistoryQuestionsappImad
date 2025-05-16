package com.example.myhistoryquestionsappimad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference to the TextView and Button
        val welcomeText = findViewById<TextView>(R.id.welcomTextView)
        val startButton = findViewById<Button>(R.id.startButton)



        // Start quiz when button is clicked
        startButton.setOnClickListener {
            val intent = Intent(this, Questions::class.java)
            startActivity(intent)
        }
    }
}