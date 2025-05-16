package com.example.myhistoryquestionsappimad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myhistoryquestionsappimad.Reviews
import com.example.myhistoryquestionsappimad.R

class Scores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextV)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Display score
        scoreTextView.text = "Your Score: $score / 5"

        // Give feedback based on score
        feedbackTextView.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practising!"
        }

        // Review button opens ReviewActivity
        reviewButton.setOnClickListener {
            val intent = Intent(this, Reviews::class.java).apply {
                putExtra("questions", questions)
                putExtra("answers", answers)
            }
            startActivity(intent)
        }

        // Exit button closes the app
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}