package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var mDbRef: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    private lateinit var editButton: Button
    private lateinit var edtProfileName: EditText
    private lateinit var edtProfileEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val uid = auth.currentUser?.uid
        val email = auth.currentUser?.email

        auth = FirebaseAuth.getInstance()

        mDbRef = FirebaseDatabase.getInstance().getReference()
        database = FirebaseDatabase.getInstance()

        editButton = findViewById(R.id.edit_button)
        edtProfileName = findViewById(R.id.edt_profile_name)
        edtProfileEmail = findViewById(R.id.edt_profile_email)

        supportActionBar?.title = "Profile"

        var classUser = User()

        var edtProfileName = User().name
        var edtProfileEmail = User().email

        Toast.makeText(this@ProfileActivity, "$edtProfileName", Toast.LENGTH_SHORT).show()

        /*
        editButton.setOnClickListener {

            var edtProfileName = edtProfileName.toString()
            var edtProfileEmail = edtProfileEmail.toString()

        }
         */
    }
}