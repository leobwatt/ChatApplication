package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import java.time.ZoneId

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var rp_email: EditText
    private lateinit var new_password: EditText
    private lateinit var confirm_new_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        rp_email = findViewById(R.id.reset_password_email)
        new_password = findViewById(R.id.new_password)
        confirm_new_password = findViewById(R.id.confirm_new_password)

        val email = FirebaseAuth.getInstance().currentUser?.email
        val rp_email = rp_email.text.toString()

        if(rp_email == email && new_password == confirm_new_password) {

        }

    }
}