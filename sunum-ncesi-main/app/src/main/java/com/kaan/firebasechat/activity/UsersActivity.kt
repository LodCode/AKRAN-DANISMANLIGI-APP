package com.kaan.firebasechat.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.kaan.firebasechat.adapter.UserAdapter
import com.kaan.firebasechat.R
import com.kaan.firebasechat.firebase.FirebaseService
import com.kaan.firebasechat.model.User
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.activity_users.imgBack




class UsersActivity : AppCompatActivity() {
    var userList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        FirebaseService.sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        FirebaseInstallations.getInstance().getToken(false).addOnSuccessListener {
            FirebaseService.token = it.token
        }

        userRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        imgBack.setOnClickListener {
            //FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        getUserList()
    }

    fun getUserList() {
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!

        val userid = firebase.uid
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/$userid")

        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference: DatabaseReference = firebaseDatabase.getReference("Users")

        databaseReference.addValueEventListener(object :ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,error.message,Toast.LENGTH_SHORT).show()

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                val currentUser = snapshot.getValue(User::class.java)


                for (Ds in snapshot.children) {
                    val user = Ds.getValue(User::class.java)
                    val id = Ds.key
                    val name = Ds.child("username").value.toString()
                    val profileImg = Ds.child("progileImage").value.toString()


                    if (!user!!.userId.equals(firebase.uid)) {
                        userList.add(User( "${id}", "${name}", "${profileImg}"))
                    }
                }

                val useradapter = UserAdapter(this@UsersActivity,userList)

                userRecyclerView.adapter = useradapter

            }
        })
    }
}