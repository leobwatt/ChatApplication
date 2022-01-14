package com.example.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    //defining variables
    private lateinit var edt_email: EditText
    private lateinit var edt_password: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_sign_up: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //sends user to activity_login
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        //why?
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)
        btn_login = findViewById(R.id.btn_login)
        btn_sign_up = findViewById(R.id.btn_sign_up)

        //if signup button is pressed, this will send user to sign up page
        btn_sign_up.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        //enter key thingy (not done at all)
        btn_login.setOnClickListener() {
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()

            login(email,password)
        }
    }

    private fun login(email: String, password: String) {

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    //sends user to MainActivity
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(this@Login, "User not found", Toast.LENGTH_SHORT).show()

                }
            }
    }

}