package io.github.dvegasa.travelhackmoscow.screens.group_creation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.activity_group_creation.*

class GroupCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_creation)
        supportActionBar?.hide()

        tvMainScreen.setOnClickListener {
            finish()
        }
        ivBackArrow.setOnClickListener {
            finish()
        }
    }
}
