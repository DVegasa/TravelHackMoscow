package io.github.dvegasa.travelhackmoscow.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.screens.main.discover.DiscoverFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentScreen = 0

    val discover = DiscoverFragment()

    val listFragment = listOf(DiscoverFragment(), DiscoverFragment(), DiscoverFragment(), DiscoverFragment())

    val nsvpAdapter = NsvpAdapter(supportFragmentManager, listFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        initBottomNav()
        initNsvp()
        updateUi()
    }

    private fun initNsvp() {
        nsvp.adapter = nsvpAdapter
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

        nsvp.currentItem = currentScreen
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
