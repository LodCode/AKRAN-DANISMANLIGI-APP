package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_kulup1.*

class Kulup1 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kulup1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    imageButton.setOnClickListener {
        val action = Kulup1Directions.actionKulup1ToKuluplerSonucEkrani()
        Navigation.findNavController(it).navigate(action)
    }

        clubBtn.setOnClickListener {
            val action = Kulup1Directions.actionKulup1ToKulupTestinOlduguEkran2()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton13.setOnClickListener {
            val action= Kulup1Directions.actionKulup1ToYeditepeHarita()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton15.setOnClickListener {
            val action= Kulup1Directions.actionKulup1ToProfileFragment()
            Navigation.findNavController(it).navigate(action)
        }

        chatButton5.setOnClickListener {
            val action= Kulup1Directions.actionKulup1ToUsersActivity()
            Navigation.findNavController(it).navigate(action)
        }

    }
}