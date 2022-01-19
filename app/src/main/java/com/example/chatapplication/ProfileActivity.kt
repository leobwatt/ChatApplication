package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var mDbRef: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    private lateinit var editButton: Button
    private lateinit var edtProfileName: EditText
    private lateinit var edtProfileEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()

        mDbRef = FirebaseDatabase.getInstance().getReference()
        database = FirebaseDatabase.getInstance()

        editButton = findViewById(R.id.editButton)
        edtProfileName = findViewById(R.id.edtProfileName)
        edtProfileEmail = findViewById(R.id.edtProfileEmail)

        supportActionBar?.title = "Profile"

        val uid = auth.currentUser?.uid
        val edtProfileEmail = auth.currentUser?.email

        //var classUser = User()

        //var edtProfileName = classUser.name

        //Toast.makeText(this@ProfileActivity, "$edtProfileName", Toast.LENGTH_SHORT).show()


        editButton.setOnClickListener {


        }

    }
}