package com.android.assign3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailField = findViewById<EditText>(R.id.etUsername)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerRedirect = findViewById<TextView>(R.id.tvGoToRegister)

        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            var isValid = true

            // Email validation
            if (email.isEmpty()) {
                emailField.error = "Email cannot be empty"
                isValid = false
            } else if (!email.endsWith("@gmail.com")) {
                emailField.error = "Email must end with @gmail.com"
                isValid = false
            }

            // Password validation
            if (password.isEmpty()) {
                passwordField.error = "Password cannot be empty"
                isValid = false
            } else if (password.length < 8) {
                passwordField.error = "Password must be at least 8 characters"
                isValid = false
            }

            if (isValid) {
                val user = User(email, email)
                val intent = Intent(this, LandingActivity::class.java)
                intent.putExtra("user_data", user)
                startActivity(intent)
            }
        }

        registerRedirect.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}