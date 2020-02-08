package io.github.dvegasa.travelhackmoscow.screens.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNav()
    }

    private fun initBottomNav() {
        val item1 = AHBottomNavigationItem("", R.drawable.ic_discover)
        val item2 = AHBottomNavigationItem("", R.drawable.ic_group)
        val item3 = AHBottomNavigationItem("", R.drawable.ic_map)
        val item4 = AHBottomNavigationItem("", R.drawable.ic_help)

        bottomnav.addItem(item1)
        bottomnav.addItem(item2)
        bottomnav.addItem(item3)
        bottomnav.addItem(item4)

        bottomnav.defaultBackgroundColor = Color.parseColor("#FFFFFF")

        bottomnav.accentColor = Color.parseColor("#F2694F") // accent

        bottomnav.isColored = false

        bottomnav.titleState = AHBottomNavigation.TitleState.ALWAYS_HIDE

        bottomnav.setOnTabSelectedListener { pos, wasSelected ->

            true
        }
    }
}
