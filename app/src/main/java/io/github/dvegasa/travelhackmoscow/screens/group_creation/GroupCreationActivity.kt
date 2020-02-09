package io.github.dvegasa.travelhackmoscow.screens.group_creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.MyApplication
import io.github.dvegasa.travelhackmoscow.pojos.GroupFirestore
import kotlinx.android.synthetic.main.activity_group_creation.*
import kotlinx.android.synthetic.main.dialog_add_user.view.*
import kotlinx.android.synthetic.main.layout_invited.view.*

class GroupCreationActivity : AppCompatActivity() {

    private val invited = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_creation)
        supportActionBar?.hide()
        tvInvited.visibility = View.INVISIBLE
        ivNext.visibility = View.GONE

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

        ivNext.setOnClickListener {
            ivNext.isEnabled = false
            createGroup()
        }
    }

    private fun addUser(username: String) {
        if (invited.isEmpty()) {
            invited.add(MyApplication.username)
        }
        tvInvited.visibility = View.VISIBLE
        ivNext.visibility = View.VISIBLE
        invited.add(username + "#")
        val tv = LayoutInflater.from(this).inflate(R.layout.layout_invited, null)
        tv.tv.text = username
        llInvitedList.addView(tv)
    }

    private fun createGroup() {
        val group = GroupFirestore(etTitle.text.toString(), etDescription.text.toString(), invited)
        val db = FirebaseFirestore.getInstance()
        db.collection("lobbys").add(group).addOnSuccessListener {
            finish()
        }
    }
}
