package io.github.dvegasa.travelhackmoscow.screens.main.groups

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.getRandomAva
import io.github.dvegasa.travelhackmoscow.pojos.GroupFirestore
import io.github.dvegasa.travelhackmoscow.pojos.GroupInviteData
import io.github.dvegasa.travelhackmoscow.pojos.GroupNormalData
import io.github.dvegasa.travelhackmoscow.screens.group_info.GroupInfoActivity
import kotlinx.android.synthetic.main.item_group_invite.view.*
import kotlinx.android.synthetic.main.item_group_invite.view.tvDescription
import kotlinx.android.synthetic.main.item_group_invite.view.tvStatus
import kotlinx.android.synthetic.main.item_group_invite.view.tvTitle
import kotlinx.android.synthetic.main.item_group_waiting.view.*
import kotlinx.android.synthetic.main.user_avatars.view.*

/**
 * Created by Ed Khalturin @DVegasa
 */
const val INVITE = 0
const val NORMAL = 1

class RvGroupsAdapter(private var list: List<GroupFirestore>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun update(list: List<GroupFirestore>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class InviteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int) {
            itemView.apply {
                val group = list[pos].toPojo() as GroupInviteData
                tvTitle.text = group.title
                tvDescription.text = group.description
                tvInviter.text = group.inviterName
            }
        }
    }

    inner class NormalVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int) {
            itemView.apply {
                val group = list[pos].toPojo() as GroupNormalData
                tvTitle.text = group.title
                tvDescription.text = group.description
                tvStatus.text = "Предстоящая поездка"

                for (i in 0..list[pos].users.size) {
                    val v = View.inflate(itemView.context, R.layout.user_avatars, llAvas)
                    v.civ.setImageResource(getRandomAva())
                }


                setOnClickListener {
                    if (list[pos].toPojo() is GroupNormalData) {
                        val intent = Intent(itemView.context, GroupInfoActivity::class.java)
                        val json = Gson().toJson(list[pos])
                        intent.putExtra("group", json)
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position].toPojo() is GroupInviteData) return INVITE
        return NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            INVITE -> InviteVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_group_invite,
                    parent,
                    false
                )
            )

            else -> NormalVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_group_waiting,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is InviteVH) holder.bind(position)
        if (holder is NormalVH) holder.bind(position)
    }
}