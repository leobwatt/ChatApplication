package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var btn_submit: Button
    private lateinit var edt_fp_email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btn_submit = findViewById(R.id.btn_submit)
        edt_fp_email = findViewById(R.id.edt_fp_email)

        btn_submit.setOnClickListener(){

            val email: String = edt_fp_email.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this@ForgotPasswordActivity, "Please enter an email address", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@ForgotPasswordActivity, "Email sent successfully", Toast.LENGTH_SHORT).show()

                            finish()
                        }
                    }
            }

        }

    }
}