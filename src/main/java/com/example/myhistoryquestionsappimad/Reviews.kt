package com.example.myhistoryquestionsappimad

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Reviews : AppCompatActivity() {


    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "The Berlin Wall fell in 1999",
        "World War II ended in 1945",
        "The first moon landing was in 1969",
        "The Great Fire of London was in 1666"
    )

    private val answers = booleanArrayOf(
        true,    // Mandela 1994 - True
        false,   // Berlin Wall 1999 - False
        true,    // WWII ended 1945 - True
        true,    // Moon landing 1969 - True
        true     // Fire of London 1666 - True
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviews)

        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)

        val reviewContent = buildReviewContent()
        reviewTextView.text = reviewContent
    }

    private fun buildReviewContent(): String {
        val builder = StringBuilder()
        for (i in questions.indices) {
            val correctAnswer = if (answers[i]) "True" else "False"
            builder.append("Q${i + 1}: ${questions[i]}\n")
            builder.append("Correct Answer: $correctAnswer\n\n")
        }
        return builder.toString()
    }
}