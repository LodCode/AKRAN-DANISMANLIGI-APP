package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_kulup1.*
import kotlinx.android.synthetic.main.fragment_kulup2.*

class Kulup2 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kulup2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton7.setOnClickListener {
            val action = Kulup2Directions.actionKulup2ToKuluplerSonucEkrani4()
            Navigation.findNavController(it).navigate(action)
        }

         imageButton16.setOnClickListener {
             val action = Kulup2Directions.actionKulup2ToKulupTestinOlduguEkran()
             Navigation.findNavController(it).navigate(action)
         }

        imageButton18.setOnClickListener {
            val action= Kulup2Directions.actionKulup2ToYeditepeHarita()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton19.setOnClickListener {
            val action= Kulup2Directions.actionKulup2ToProfileFragment()
            Navigation.findNavController(it).navigate(action)
        }

        chatButton6.setOnClickListener {
            val action= Kulup2Directions.actionKulup2ToUsersActivity()
            Navigation.findNavController(it).navigate(action)
        }

    }

}