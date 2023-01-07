package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_kulup__testin_oldugu_ekran.*
import kotlinx.android.synthetic.main.fragment_kulupler_sonuc_ekrani.*


class Kulup_Testin_oldugu_ekran : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kulup__testin_oldugu_ekran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton24.setOnClickListener {
            val action = Kulup_Testin_oldugu_ekranDirections.actionKulupTestinOlduguEkranToKulup1()
            Navigation.findNavController(it).navigate(action)
        }
        imageButton21.setOnClickListener {
            val action = Kulup_Testin_oldugu_ekranDirections.actionKulupTestinOlduguEkranToKulup2()
            Navigation.findNavController(it).navigate(action)

        }

        imageButton4.setOnClickListener {
            val action = Kulup_Testin_oldugu_ekranDirections.actionKulupTestinOlduguEkranToBilisimkulubu()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton37.setOnClickListener {
            val action = Kulup_Testin_oldugu_ekranDirections.actionKulupTestinOlduguEkranToAnaMenu1()
            Navigation.findNavController(it).navigate(action)
        }
        btnAnket.setOnClickListener {
            val action = Kulup_Testin_oldugu_ekranDirections.kulupAnket()
            Navigation.findNavController(it).navigate(action)
        }


    }

}