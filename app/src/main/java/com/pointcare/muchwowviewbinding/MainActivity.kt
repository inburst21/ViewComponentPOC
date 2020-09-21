package com.pointcare.muchwowviewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pointcare.features.SelectTextFieldController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        val controller = SelectTextFieldController(this)
        controller.observe(this)
        setContentView(controller.getView())
    }
}