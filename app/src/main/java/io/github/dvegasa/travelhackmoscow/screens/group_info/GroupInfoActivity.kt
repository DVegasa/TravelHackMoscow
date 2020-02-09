package io.github.dvegasa.travelhackmoscow.screens.group_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.pojos.Poi
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

        rvPois.adapter = RvPoiAdapters(
            listOf(
                Poi(
                    "Красная площадь",
                    "Consequat pariatur dolor velit excepteur proident fugiat exercitation enim irure dolor sit ame lorem",
                    "Волгоградский проспект, 49"
                ),
                Poi(
                    "Красная площадь",
                    "Consequat pariatur dolor velit excepteur proident fugiat exercitation enim irure dolor sit ame lorem",
                    "Волгоградский проспект, 49"
                ),
                Poi(
                    "Красная площадь",
                    "Consequat pariatur dolor velit excepteur proident fugiat exercitation enim irure dolor sit ame lorem",
                    "Волгоградский проспект, 49"
                ),
                Poi(
                    "Красная площадь",
                    "Consequat pariatur dolor velit excepteur proident fugiat exercitation enim irure dolor sit ame lorem",
                    "Волгоградский проспект, 49"
                ),
                Poi(
                    "Красная площадь",
                    "Consequat pariatur dolor velit excepteur proident fugiat exercitation enim irure dolor sit ame lorem",
                    "Волгоградский проспект, 49"
                )
            )
        )

    }
}
