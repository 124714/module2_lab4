package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // поля для ввода чисел
        val km = findViewById<EditText>(R.id.km)
        val m = findViewById<EditText>(R.id.m)
        val dm = findViewById<EditText>(R.id.dm)
        val sm = findViewById<EditText>(R.id.sm)
        val mm = findViewById<EditText>(R.id.mm)


        val inspect = findViewById<Button>(R.id.inspect)
        val rezult = findViewById<TextView>(R.id.rezult) // текстовое поле для вывода результата
        val answer = findViewById<ImageView>(R.id.answer)

        inspect.setOnClickListener({
            if (mm.text.toString().toFloatOrNull() == sm.text.toString().toFloatOrNull()?.times(10) &&
                        mm.text.toString().toFloatOrNull() == dm.text.toString().toFloatOrNull()?.times(100) &&
                        mm.text.toString().toFloatOrNull() == m.text.toString().toFloatOrNull()?.times(1000) &&
                        mm.text.toString().toFloatOrNull() == km.text.toString().toFloatOrNull()?.times(1000000)) {
                rezult.setText(R.string.good)
                answer.setImageResource(R.drawable.cool)
            }
            else {

                rezult.setText(R.string.bad)
//                rezult.setTextColor(R.color.red)
                answer.setImageResource(R.drawable.bad)
            }
        })

        answer.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action) {
                MotionEvent.ACTION_DOWN -> if (answer.alpha >= 0.1f) answer.alpha -= 0.1f else answer.alpha = 1.0f
            }
            true

        }

    }



}