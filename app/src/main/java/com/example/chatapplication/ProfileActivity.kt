package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var mDbRef: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val uid = FirebaseAuth.getInstance().currentUser?.uid
        val email = FirebaseAuth.getInstance().currentUser?.email

        mDbRef = FirebaseDatabase.getInstance().getReference()
        database = FirebaseDatabase.getInstance()

        val ref = database.getReference("user").child(uid!!)

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // getting name from database
                val name = dataSnapshot.getValue<ref>()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }



/*
        mDbRef.child("user").child(uid!!)
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val name = DataSnapshot.children(1)
                    val message = name.getValue(Message::class.java)

                    //messageAdapter.notifyDataSetChanged()


                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@ProfileActivity, "Database Error", Toast.LENGTH_SHORT).show()

                }
            })
*/

        supportActionBar?.title = "Profile"

        val profileName: TextView = findViewById(R.id.profile_name) as TextView
        profileName.text = "$name"


        val profileEmail: TextView = findViewById(R.id.profile_email) as TextView
        profileEmail.text = "$email"


        //mDbRef.child("user").child(uid!!).child(thing).push()
            //.setValue(thingToAdd)



    }
}