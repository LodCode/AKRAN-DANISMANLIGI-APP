package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_kulupler_sonuc_ekrani.*



class KuluplerSonucEkrani : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MCT.text = MCT.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kulupler_sonuc_ekrani, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        muzikKulubu.setOnClickListener {
            val action = KuluplerSonucEkraniDirections.actionKuluplerSonucEkraniToKulup1()
            Navigation.findNavController(it).navigate(action)
        }


        imageButton22.setOnClickListener {
            val action = KuluplerSonucEkraniDirections.actionKuluplerSonucEkraniToKulup2()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton9.setOnClickListener {
            val action = KuluplerSonucEkraniDirections.actionKuluplerSonucEkraniToKulupTestinOlduguEkran()
            Navigation.findNavController(it).navigate(action)
        }

        imageButton3.setOnClickListener {
            val action = KuluplerSonucEkraniDirections.actionKuluplerSonucEkraniToBilisimkulubu()
            Navigation.findNavController(it).navigate(action)
        }

        chatButton7.setOnClickListener {
            val action = KuluplerSonucEkraniDirections.actionKuluplerSonucEkraniToUsersActivity()
            Navigation.findNavController(it).navigate(action)
        }

    }

}