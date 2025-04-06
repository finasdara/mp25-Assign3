package com.android.assign3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val user = intent.getParcelableExtra<User>("user_data")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)

        tvWelcome.text = "Welcome, ${user?.name}!\nEnjoy Bikini Bottom 🧽"
    }
}
