package com.example.timecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var timeInput1: EditText
    private lateinit var timeInput2: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var resultTextView: TextView
    private val timeCalculatorProcess = TimeCalculatorProcess()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeInput1 = findViewById(R.id.timeInput1)
        timeInput2 = findViewById(R.id.timeInput2)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        resultTextView = findViewById(R.id.resultTextView)
        addButton.setOnClickListener { calculateTime(true) }
        subtractButton.setOnClickListener { calculateTime(false) }
    }
    private fun calculateTime(isAddition: Boolean) {
        val time1 = timeInput1.text.toString()
        val time2 = timeInput2.text.toString()
        val result = if (isAddition) {
            timeCalculatorProcess.addTimes(time1, time2)
        } else {
            timeCalculatorProcess.subtractTimes(time1, time2)
        }
        resultTextView.text = result
    }
}