package com.example.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    //these are the text boxes and buttons
    private lateinit var edt_name: EditText
    private lateinit var edt_email: EditText
    private lateinit var edt_password: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_sign_up: Button

    //this is what we call when we want to use Firebase authentication
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    //this function runs once when the code is run
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this sets the page to activity_sign_up
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()

        //renames the variables for some reason
        edt_name = findViewById(R.id.edt_name)
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)
        btn_sign_up = findViewById(R.id.btn_sign_up)

        btn_sign_up.setOnClickListener {
            //this code runs when the signup button is pressed
            val name = edt_name.text.toString()
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()

            //calls signUp function below
            signUp(name, email, password)
        }
    }

    private fun signUp(name: String, email: String, password: String) {

        //signs up user
        if (password.length > 3  && password.length < 20) {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        //adds info to database
                        addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                        //sends user to MainActivity
                        val intent = Intent(this@SignUp, MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        //this runs if the code fails
                        Toast.makeText(this@SignUp, "Error Occurred", Toast.LENGTH_SHORT).show()

                    }
                }
        } else {
            Toast.makeText(this@SignUp, "Passwords must be between 3-20 characters", Toast.LENGTH_SHORT).show()
        }



    }

    private fun addUserToDatabase(name: String, email: String, uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()

        //adds a user to the database with a name, email, and uid
        mDbRef.child("user").child(uid).setValue(User(name,email,uid))
    }
}

