package io.github.dvegasa.travelhackmoscow.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentScreen = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // fullscreen()
        supportActionBar?.hide()
        initBottomNav()
        updateUi()
    }

    private fun updateUi() {
        val bnavs = listOf(bnavDiscover, bnavGroups, bnavMap, bnavHelp)
        bnavs.forEach {
            DrawableCompat.setTint(
                DrawableCompat.wrap(it.drawable),
                ResourcesCompat.getColor(resources, R.color.colorBottomnavInactive, null)
            )
        }

        val active = when (currentScreen) {
            0 -> bnavDiscover
            1 -> bnavGroups
            2 -> bnavMap
            else -> bnavHelp
        }
        DrawableCompat.setTint(
            DrawableCompat.wrap(active.drawable),
            ResourcesCompat.getColor(resources, R.color.colorAccent, null)
        )
    }

    private fun initBottomNav() {
        bnavDiscover.setOnClickListener {
            currentScreen = 0
            updateUi()
        }

        bnavGroups.setOnClickListener {
            currentScreen = 1
            updateUi()
        }

        bnavMap.setOnClickListener {
            currentScreen = 2
            updateUi()
        }

        bnavHelp.setOnClickListener {
            currentScreen = 3
            updateUi()
        }
    }
}
