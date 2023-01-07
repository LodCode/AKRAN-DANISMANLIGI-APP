package com.kaan.firebasechat.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.gson.Gson
import com.kaan.firebasechat.R
import com.kaan.firebasechat.RetrofitInstance
import com.kaan.firebasechat.adapter.ChatAdapter
import com.kaan.firebasechat.model.Chat
import com.kaan.firebasechat.model.NotificationData
import com.kaan.firebasechat.model.PushNotification
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatActivity : AppCompatActivity() {
    var firebaseUser:FirebaseUser? = null
    var reference:DatabaseReference? = null
    var chatList = ArrayList<Chat>()
    private var topic = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        chatRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val intent = getIntent()
        val userId = intent.getStringExtra("userId")
        val userName = intent.getStringExtra("userName")

        firebaseUser = FirebaseAuth.getInstance().currentUser
        reference = FirebaseDatabase.getInstance().getReference("Users").child(userId!!)

        imgBack.setOnClickListener {
            onBackPressed()
        }

        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUserName = snapshot.child("username").value.toString()
                val currentUserProfileImg = snapshot.child("progileImg").value.toString()

                tvUserName.setText(currentUserName)
                Log.e("username", "onDataChange: ${currentUserName}", )
                Log.e("profileImg", "onDataChange: ${currentUserProfileImg}", )
                if (currentUserProfileImg == "null") {
                    imgProfile.setImageResource(R.drawable.profile_image)
                }
                else {
                    Glide.with(this@ChatActivity).load(currentUserProfileImg).into(imgProfile)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        btnSendMessage.setOnClickListener {
            var message: String = etMessage.text.toString()
            Log.e("firebaseUser!!.uid", "onCreate: ${firebaseUser!!.uid}", )
            Log.e("currentUserId", "onCreate: ${userId}", )


            if (message.isEmpty()) {
                Toast.makeText(applicationContext, "message is empty",Toast.LENGTH_SHORT).show()
                etMessage.setText("")
            }
            else {
                sendMessage(firebaseUser!!.uid,userId,message)
                etMessage.setText("")
                topic = "/topics/$userId"
                PushNotification(NotificationData(userName!!,message),//firebaseUser!!.displayName!!
                topic).also {
                    sendNotification(it)
                }
            }
        }

        readMessage(firebaseUser!!.uid,userId)
    }
    private fun sendMessage(senderId:String,receiverId:String,message:String) {
        var reference:DatabaseReference? = FirebaseDatabase.getInstance().getReference()

        var hashMap:HashMap<String,String> = HashMap()
        hashMap.put("senderId",senderId)
        hashMap.put("receiverId",receiverId)
        hashMap.put("message",message)

        reference!!.child("Chat").push().setValue(hashMap)

    }
    fun readMessage(senderId: String,receiverId: String) {
        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference: DatabaseReference = firebaseDatabase.getReference("Chat")

        databaseReference.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                chatList.clear()
                for (Ds in snapshot.children) {
                    val chat = Ds.getValue(Chat::class.java)
                    val message = Ds.child("message").value.toString()
                    val receiverIdControl = Ds.child("receiverId").value.toString()
                    val senderIdControl = Ds.child("senderId").value.toString()

                    if (chat!!.senderId.equals(senderId) && chat!!.receiverId.equals(receiverId) ||
                        chat!!.senderId.equals(senderId) && chat!!.receiverId.equals(receiverId)) {
                        chatList.add(Chat( "$senderIdControl", "$receiverIdControl", "${message}"))
                    }
                }
                val chatAdapter = ChatAdapter(this@ChatActivity,chatList)

                chatRecyclerView.adapter = chatAdapter
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.api.postNotification(notification)
            if ( response.isSuccessful) {
                Toast.makeText(this@ChatActivity, "Response ${Gson().toJson(response)}",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this@ChatActivity, response.errorBody().toString(),Toast.LENGTH_SHORT).show()

            }
        }catch (e:java.lang.Exception) {
            runOnUiThread(Runnable {
                kotlin.run {
                    Toast.makeText(this@ChatActivity,e.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}