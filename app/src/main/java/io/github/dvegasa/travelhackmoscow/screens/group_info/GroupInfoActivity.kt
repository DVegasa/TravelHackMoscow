package io.github.dvegasa.travelhackmoscow.screens.group_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.activity_group_info.*

class GroupInfoActivity : AppCompatActivity() {

    var adapter = RvPoiAdapters(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        supportActionBar?.hide()

        linearLayout2.setOnClickListener {
            finish()
        }

        rvPois.adapter = adapter
    }
}
