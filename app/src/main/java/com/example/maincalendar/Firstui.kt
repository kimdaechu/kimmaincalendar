package com.example.maincalendar

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Firstui : AppCompatActivity() {
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstui)

        startButton = findViewById(R.id.btn_A)
        startButton.setOnClickListener {
            // MainActivity로 이동하는 코드 추가
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}