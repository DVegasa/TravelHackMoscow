package io.github.dvegasa.travelhackmoscow.screens.main.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.screens.main.MainActivity

class HelpFragment : Fragment() {

    lateinit var root: View
    lateinit var host: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_help, container, false)
        host = activity as MainActivity
        bindViews()
        return root
    }

    private fun bindViews() {

    }
}
