package io.github.dvegasa.travelhackmoscow.screens.group_info

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.getRandomAva
import io.github.dvegasa.travelhackmoscow.pojos.GroupFirestore
import kotlinx.android.synthetic.main.activity_group_info.*
import kotlinx.android.synthetic.main.user_avatars.view.*

class GroupInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        supportActionBar?.hide()
        val group = Gson().fromJson(intent.extras?.getString("group"), GroupFirestore::class.java)

        linearLayout2.setOnClickListener {
            finish()
        }

        rvPois.adapter = RvPoiAdapters(group.poizzes?.pois ?: listOf())
        rvPois.layoutManager = LinearLayoutManager(this)

        tvTitle.text = group.title

        for (i in 0..group.users.size) {
            val v = View.inflate(this, R.layout.user_avatars, llUserAvas)
            v.civ.setImageResource(
                getRandomAva()
            )
        }
    }
}
