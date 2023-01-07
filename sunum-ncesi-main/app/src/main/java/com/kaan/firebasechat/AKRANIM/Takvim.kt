package com.kaan.firebasechat.AKRANIM

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kaan.firebasechat.R

class Takvim: AppCompatActivity() {
    // on below line we are creating
    // variables for text view and calendar view
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_takvim)

        val geributonu= findViewById<ImageButton>(R.id.imageButton7)
        geributonu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // initializing variables of
        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)

        // on below line we are adding set on
        // date change listener for calendar view.
        calendarView
            .setOnDateChangeListener(
                OnDateChangeListener { view, year, month, dayOfMonth ->
                    // In this Listener we are getting values
                    // such as year, month and day of month
                    // on below line we are creating a variable
                    // in which we are adding all the variables in it.
                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    dateTV.setText(Date)
                })

    }
}