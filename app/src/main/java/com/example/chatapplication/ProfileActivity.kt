package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity : AppCompatActivity() {

    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = FirebaseAuth.getInstance().currentUser?.displayName
        val uid = FirebaseAuth.getInstance().currentUser?.uid

        mDbRef = FirebaseDatabase.getInstance().getReference()


        supportActionBar?.title = "Profile"

        val profileName: TextView = findViewById(R.id.profile_name) as TextView
        profileName.text = name


        val profileEmail: TextView = findViewById(R.id.profile_email) as TextView
        profileEmail.text = name


        //mDbRef.child("user").child(uid!!).child(thing).push()
            //.setValue(thingToAdd)



    }
}