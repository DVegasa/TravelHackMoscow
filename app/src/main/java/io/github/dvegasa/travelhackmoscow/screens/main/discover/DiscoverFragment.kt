package io.github.dvegasa.travelhackmoscow.screens.main.discover

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.MyApplication
import io.github.dvegasa.travelhackmoscow.screens.group_creation.GroupCreationActivity
import io.github.dvegasa.travelhackmoscow.screens.main.MainActivity
import kotlinx.android.synthetic.main.fragment_discover.view.*

class DiscoverFragment : Fragment() {

    lateinit var root: View
    lateinit var host: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_discover, container, false)
        host = activity as MainActivity
        root.tvName.text = MyApplication.Storage.username
        root.flBCreate.setOnClickListener {
            startActivity(Intent(root.context, GroupCreationActivity::class.java))
        }
        showCards()
        return root
    }

    fun showCards() {

    }
}
