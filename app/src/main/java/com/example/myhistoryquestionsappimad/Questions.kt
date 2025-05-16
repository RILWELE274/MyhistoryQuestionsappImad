package com.example.myhistoryquestionsappimad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Questions : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "The Berlin Wall fell in 1999",
        "World War II ended in 1945",
        "The first moon landing was in 1969",
        "The Great Fire of London was in 1666"
    )

    private val answers = arrayOf(true, false, true, true, true)

    private var currentIndex = 0
    private var score = 0
    private var answered = false

    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        showQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener { goToNextQuestion() }
    }

    private fun showQuestion() {
        questionTextView.text = questions[currentIndex]
        feedbackTextView.text = ""
        answered = false
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (answered) return

        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct!"
            score++
        } else {
            feedbackTextView.text = "Incorrect"
        }
        answered = true
    }

    private fun goToNextQuestion() {
        if (currentIndex < questions.size - 1) {
            currentIndex++
            showQuestion()
        } else {
            val intent = Intent(this, Scores::class.java).apply {
                putExtra("score", score)
                putExtra("questions", questions)
                putExtra("answers", answers)
            }
            startActivity(intent)
            finish()
        }
    }
}