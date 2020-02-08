package io.github.dvegasa.travelhackmoscow.screens.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by Ed Khalturin @DVegasa
 */
class NsvpAdapter(fm: FragmentManager, val list: List<Fragment>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = list[position]

    override fun getCount() = 4
}