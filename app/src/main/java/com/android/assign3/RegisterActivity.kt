package com.android.assign3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameField = findViewById<EditText>(R.id.etName)
        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val currentPasswordField = findViewById<EditText>(R.id.etCurrentPassword)
        val registerButton = findViewById<Button>(R.id.btnRegister)

        registerButton.setOnClickListener {
            val name = nameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val currentPassword = currentPasswordField.text.toString()

            var isValid = true

            if (name.isEmpty()) {
                nameField.error = "Name cannot be empty"
                isValid = false
            }

            if (email.isEmpty()) {
                emailField.error = "Email cannot be empty"
                isValid = false
            } else if (!email.endsWith("@gmail.com")) {
                emailField.error = "Email must end with @gmail.com"
                isValid = false
            }

            if (password.isEmpty()) {
                passwordField.error = "Password cannot be empty"
                isValid = false
            } else if (password.length < 8) {
                passwordField.error = "Password must be at least 8 characters"
                isValid = false
            }

            if (currentPassword.isEmpty()) {
                currentPasswordField.error = "Current Password cannot be empty"
                isValid = false
            } else if (currentPassword.length < 8) {
                currentPasswordField.error = "Password must be at least 8 characters"
                isValid = false
            }

            if (isValid) {
                val user = User(name, email)
                val intent = Intent(this, LandingActivity::class.java)
                intent.putExtra("user_data", user)
                startActivity(intent)
            }
        }
    }
}