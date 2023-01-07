package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_ana_menu1.*
import kotlinx.android.synthetic.main.fragment_bilisimkulubu.*
import kotlinx.android.synthetic.main.fragment_bilisimkulubu.kulupButton


class bilisimkulubu : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bilisimkulubu, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton2.setOnClickListener {
            val action = bilisimkulubuDirections.actionBilisimkulubuToKuluplerSonucEkrani()
            Navigation.findNavController(it).navigate(action)
        }

        kulupButton.setOnClickListener {
            val action = bilisimkulubuDirections.actionBilisimkulubuToKulupTestinOlduguEkran()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton25.setOnClickListener {
            val action= bilisimkulubuDirections.actionBilisimkulubuToYeditepeHarita()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton27.setOnClickListener {
            val action= bilisimkulubuDirections.actionBilisimkulubuToProfileFragment()
            Navigation.findNavController(it).navigate(action)
        }

        chatButton4.setOnClickListener {
            val action=bilisimkulubuDirections.actionBilisimkulubuToUsersActivity()
            Navigation.findNavController(it).navigate(action)
        }

    }

}