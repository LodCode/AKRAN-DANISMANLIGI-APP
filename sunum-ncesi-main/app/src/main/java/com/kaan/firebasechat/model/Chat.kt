package com.kaan.firebasechat.model

data class Chat(val senderId:String = "",
                val receiverId:String = "",
                val message:String = "")
