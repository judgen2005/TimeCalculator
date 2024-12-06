package com.example.timecalculator

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toolBar: Toolbar
    private lateinit var timeInput1: EditText
    private lateinit var timeInput2: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var resultTextView: TextView
    private val timeCalculatorProcess = TimeCalculatorProcess()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolBar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)
        title = "Калькулятор времени"
        toolBar.subtitle = "Считает разницу времени"
        toolBar.setLogo(R.drawable.time_calculator)

        timeInput1 = findViewById(R.id.timeInput1)
        timeInput2 = findViewById(R.id.timeInput2)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        resultTextView = findViewById(R.id.resultTextView)
        addButton.setOnClickListener { calculateTime(true) }
        subtractButton.setOnClickListener { calculateTime(false) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.clearInputMain ->{
                timeInput1.text.clear()
                timeInput2.text.clear()
                Toast.makeText(applicationContext, "Данные ввода очищены", Toast.LENGTH_LONG).show()
            }
            R.id.clearOutputMain ->{
                resultTextView.text = ""
                resultTextView.setTextColor(Color.BLACK)
                Toast.makeText(applicationContext, "Данные вывода очищены", Toast.LENGTH_LONG).show()
            }
            R.id.exitMain -> {
                Toast.makeText(applicationContext, "Приложение закрыто", Toast.LENGTH_LONG).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun calculateTime(isAddition: Boolean) {
        val time1 = timeInput1.text.toString()
        val time2 = timeInput2.text.toString()
        val result = if (isAddition) {
            timeCalculatorProcess.addTimes(time1, time2)
        } else {
            timeCalculatorProcess.subtractTimes(time1, time2)
        }
        Toast.makeText(applicationContext, "Результат: $result", Toast.LENGTH_LONG).show()
        resultTextView.setTextColor(Color.parseColor("#8B0000"))
        resultTextView.text = result
    }
}