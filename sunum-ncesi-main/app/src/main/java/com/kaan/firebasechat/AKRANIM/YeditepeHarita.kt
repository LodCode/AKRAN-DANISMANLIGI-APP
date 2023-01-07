package com.kaan.firebasechat.AKRANIM

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kaan.firebasechat.R
import kotlinx.android.synthetic.main.fragment_ana_menu1.*



class YeditepeHarita : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yeditepe_harita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        geriButton.setOnClickListener {
            val action=YeditepeHaritaDirections.actionYeditepeHaritaToAnaMenu1()
            Navigation.findNavController(it).navigate(action)
        }

    }
}