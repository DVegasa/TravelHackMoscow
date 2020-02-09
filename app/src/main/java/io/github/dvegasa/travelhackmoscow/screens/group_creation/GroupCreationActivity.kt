package io.github.dvegasa.travelhackmoscow.screens.group_creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import kotlinx.android.synthetic.main.activity_group_creation.*
import kotlinx.android.synthetic.main.dialog_add_user.view.*
import kotlinx.android.synthetic.main.layout_invited.view.*

class GroupCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_creation)
        supportActionBar?.hide()
        tvInvited.visibility = View.INVISIBLE

        tvMainScreen.setOnClickListener {
            finish()
        }
        ivBackArrow.setOnClickListener {
            finish()
        }

        llAdd.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.dialog_add_user, null)
            AlertDialog.Builder(this).setView(view)
                .setPositiveButton("Добавить") { dialog, id ->
                    addUser(view.etUsername.text.toString())
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun addUser(username: String) {
        tvInvited.visibility = View.VISIBLE
        val tv = LayoutInflater.from(this).inflate(R.layout.layout_invited, null)
        tv.tv.text = username
        llInvitedList.addView(tv)
    }
}
