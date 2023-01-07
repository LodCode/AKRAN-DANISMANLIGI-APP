package com.kaan.firebasechat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kaan.firebasechat.AKRANIM.MainActivity
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btnLogin
import kotlinx.android.synthetic.main.activity_sign_up.btnSignUp
import kotlinx.android.synthetic.main.activity_sign_up.etEmail
import kotlinx.android.synthetic.main.activity_sign_up.etPassword

private lateinit var auth:FirebaseAuth
private lateinit var databaseReference: DatabaseReference


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        btnSignUp.setOnClickListener {
            val userName = etName.text.toString()
            val schoolId = schoolID.text.toString()
            val department = department.text.toString()
            val section = section.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (TextUtils.isEmpty(userName) ||
                TextUtils.isEmpty(schoolId) ||
                TextUtils.isEmpty(department) ||
                TextUtils.isEmpty(section) ||
                TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(password) ||
                TextUtils.isEmpty(confirmPassword) ||
                password.equals(confirmPassword).not()
                ) {
                Toast.makeText(applicationContext, "confirmPassword is not match", Toast.LENGTH_SHORT).show()
            }else {
                registerUser(userName, email, password, schoolId, department, section)
            }
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun registerUser(userName:String, email:String, password:String, schoolId:String, department:String, section:String,) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user: FirebaseUser? = auth.currentUser
                    val userId:String = user!!.uid

                    databaseReference = FirebaseDatabase.getInstance().getReference( "Users").child(userId)

                    val hashMap:HashMap<String,String> = HashMap()
                    hashMap.put("userId", userId)
                    hashMap.put("username", userName)
                    hashMap.put("schoolId", schoolId)
                    hashMap.put("department", department)
                    hashMap.put("section", section)
                    hashMap.put("progileImage", "")

                    databaseReference.setValue(hashMap).addOnCompleteListener(this){
                        if (it.isSuccessful) {
                            //open home activity
                            etName.setText("")
                            etEmail.setText("")
                            etPassword.setText("")
                            etConfirmPassword.setText("")
                            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
            }
    }
}

