package io.github.dvegasa.travelhackmoscow.screens.main.groups

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.MyApplication
import io.github.dvegasa.travelhackmoscow.helpers.info
import io.github.dvegasa.travelhackmoscow.pojos.GroupFirestore
import io.github.dvegasa.travelhackmoscow.screens.group_creation.GroupCreationActivity
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
        root.ivCreate.setOnClickListener {
            startActivity(Intent(root.context, GroupCreationActivity::class.java))
        }
        // loadData()
        subscribeToData()
        return root
    }

    private fun subscribeToData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("lobbys")
            .addSnapshotListener {value, e ->
                e?.printStackTrace()

                var list = ArrayList<GroupFirestore>()
                for (doc in value!!) {
                    val obj = doc.toObject(GroupFirestore::class.java)
                    list.add(obj)
                }
                list.sortByDescending { it.time }
                list = ArrayList(list.filter {MyApplication.Storage.username in it.users})
                info(list)
                info(MyApplication.username)

                rvAdapter.update(list)
            }
    }
}
