package io.github.dvegasa.travelhackmoscow.screens.main.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.GroupItem
import io.github.dvegasa.travelhackmoscow.pojos.GroupInviteData
import io.github.dvegasa.travelhackmoscow.pojos.GroupNormalData
import io.github.dvegasa.travelhackmoscow.screens.main.MainActivity
import kotlinx.android.synthetic.main.fragment_groups.view.*

class GroupsFragment : Fragment() {

    lateinit var root: View
    lateinit var host: MainActivity

    var rvAdapter = RvGroupsAdapter(listOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_groups, container, false)
        host = activity as MainActivity
        root.rvGroups.adapter = rvAdapter
        root.rvGroups.layoutManager = LinearLayoutManager(root.rvGroups.context)
        loadData()
        bindViews()
        return root
    }

    private fun loadData() {
        val groups = ArrayList<GroupItem>()
        groups.add(
            GroupInviteData(
                1,
                "Поездка в Москву",
                "Где-то в феврале отправимся в путь!",
                "DVegasa",
                "http://none.com/"
            )
        )

        groups.add(
            GroupInviteData(
                2,
                "На ВДНХ!",
                "Ведь там красиво",
                "Никита Штанько",
                "http://none.com/"
            )
        )

        groups.add(
            GroupNormalData(
                3,
                "Февраль. Волгоград!",
                "А почему бы и не?",
                "Через два месяца",
                listOf()
            )
        )

        rvAdapter.update(groups)
    }

    private fun bindViews() {

    }

}
