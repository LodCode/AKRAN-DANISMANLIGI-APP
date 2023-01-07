package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_ana_menu1.*
import kotlinx.android.synthetic.main.fragment_ana_menu1.kulupButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.geriButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.ileriButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.locationButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.profileButton
import kotlinx.android.synthetic.main.fragment_ana_menu1.takvimButton
import kotlinx.android.synthetic.main.fragment_ana_menu2.*


class AnaMenu2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ana_menu2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ileriButton.setOnClickListener {
            val action=AnaMenu2Directions.actionAnaMenu2ToAnaMenu3()
            Navigation.findNavController(it).navigate(action)
        }

            geriButton.setOnClickListener {
                val action=AnaMenu2Directions.actionAnaMenu2ToAnaMenu1()
                Navigation.findNavController(it).navigate(action)
            }

        locationButton.setOnClickListener {
            val action=AnaMenu2Directions.actionAnaMenu2ToYeditepeHarita()
            Navigation.findNavController(it).navigate(action)
        }

        profileButton.setOnClickListener {
            val action=AnaMenu2Directions.actionAnaMenu2ToProfileFragment()
            Navigation.findNavController(it).navigate(action)
        }

        kulupButton.setOnClickListener {
            val action=AnaMenu2Directions.actionAnaMenu2ToKulupTestinOlduguEkran()
            Navigation.findNavController(it).navigate(action)
        }
        chatButton2.setOnClickListener {
            val action=AnaMenu2Directions.actionAnaMenu2ToUsersActivity()
            Navigation.findNavController(it).navigate(action)
        }

        takvimButton.setOnClickListener {
            val action=AnaMenu2Directions.actionAnaMenu2ToTakvim()
            Navigation.findNavController(it).navigate(action)
        }

    }


}