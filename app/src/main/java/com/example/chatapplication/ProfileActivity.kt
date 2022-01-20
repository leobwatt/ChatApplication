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

    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid
        val email = auth.currentUser?.email

        mDbRef = FirebaseDatabase.getInstance().getReference("user")
        database = FirebaseDatabase.getInstance()

        editButton = findViewById(R.id.edit_button)
        edtProfileName = findViewById(R.id.edt_profile_name)
        edtProfileEmail = findViewById(R.id.edt_profile_email)

        supportActionBar?.title = "Profile"


        fun getData(toGet: String) {
            mDbRef.child(uid!!).get().addOnSuccessListener {

                if (it.exists()){
                    Toast.makeText(this,"Successfully Read",Toast.LENGTH_SHORT).show()
                    //val thingToGet = it.child(toGet).value.toString()
                    //name = it.child("name").value.toString()

                }else{

                    Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


                }

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }
        }
        Toast.makeText(this,"$uid",Toast.LENGTH_SHORT).show()
        getData(name)

        //edtProfileName.setText(name)
        edtProfileEmail.setText(email)




        /*
        editButton.setOnClickListener {

            var edtProfileName = edtProfileName.toString()
            var edtProfileEmail = edtProfileEmail.toString()

        }
         */
    }
}