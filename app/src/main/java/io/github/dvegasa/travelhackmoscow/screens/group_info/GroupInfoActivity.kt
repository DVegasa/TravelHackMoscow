package io.github.dvegasa.travelhackmoscow.screens.group_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.pojos.GroupFirestore
import kotlinx.android.synthetic.main.activity_group_info.*

class GroupInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        supportActionBar?.hide()

        linearLayout2.setOnClickListener {
            finish()
        }

        val group = Gson().fromJson(intent.extras?.getString("group"), GroupFirestore::class.java)
        rvPois.adapter = RvPoiAdapters(group.poizzes?.pois ?: listOf())
        rvPois.layoutManager = LinearLayoutManager(this)
    }
}
