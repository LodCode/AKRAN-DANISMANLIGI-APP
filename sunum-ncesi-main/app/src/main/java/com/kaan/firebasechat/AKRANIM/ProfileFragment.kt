package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.fragment_ana_menu1.*
import kotlinx.android.synthetic.main.fragment_ana_menu1.geriButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.locationButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.kulupButton
import kotlinx.android.synthetic.main.fragment_ana_menu3.*
import kotlinx.android.synthetic.main.fragment_kulupler_sonuc_ekrani.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {
    private lateinit var firebaseUser: FirebaseUser
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference: DatabaseReference = firebaseDatabase.getReference("Users").child(firebaseUser.uid)
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUserName = snapshot.child("username").value.toString()
                val curentdepartment = snapshot.child("department").value.toString()
                val curentsection = snapshot.child("section").value.toString()
                val curentschoolId = snapshot.child("schoolId").value.toString()
                val currentUserProfileImg = snapshot.child("progileImg").value.toString()
                val currenClub = snapshot.child("Kulüpler").value.toString()
                val currenEmail = snapshot.child("e-mail").value.toString()
                val currentDurum = snapshot.child("Durum").value.toString()
                val currentDönem =snapshot.child("dönem").value.toString()

                profileUserName.setText(currentUserName)
                departmentAndSection.setText("Fakülte:${curentdepartment} \nBölümü: ${curentsection}")
                dahilOlunanKulüpler.setText("Kulüpler: ${currenClub}")
                kullanıcıMail.setText("E-mail: ${currenEmail}")
                ögrenciNumarasi.setText("Okul Numarası: ${curentschoolId}")
                durum.setText("Durum: ${currentDurum}")
                dönem.setText("Dönem: ${currentDönem}")

                Log.e("username", "onDataChange: ${currentUserName}", )
                Log.e("profileImg", "onDataChange: ${currentUserProfileImg}", )
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        geriButton.setOnClickListener {
            val action=ProfileFragmentDirections.actionProfileFragmentToAnaMenu1()
            Navigation.findNavController(it).navigate(action)
        }

        locationButton.setOnClickListener {
            val action=ProfileFragmentDirections.actionProfileFragmentToYeditepeHarita()
            Navigation.findNavController(it).navigate(action)
        }

        kulupButton.setOnClickListener {
            val action=ProfileFragmentDirections.actionProfileFragmentToKulupTestinOlduguEkran()
            Navigation.findNavController(it).navigate(action)
        }

        chatButton8.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToUsersActivity()
            Navigation.findNavController(it).navigate(action)
        }
    }

}