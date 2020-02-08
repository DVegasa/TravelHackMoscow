package io.github.dvegasa.travelhackmoscow.screens.main.discover

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.ImageHelper
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
        showCards()
        return root
    }

    fun showCards() {

    }
}
