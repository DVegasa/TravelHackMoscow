package io.github.dvegasa.travelhackmoscow.screens.main.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.helpers.GroupItem
import io.github.dvegasa.travelhackmoscow.pojos.GroupInviteData
import io.github.dvegasa.travelhackmoscow.pojos.GroupNormalData
import kotlinx.android.synthetic.main.item_group_invite.view.*

/**
 * Created by Ed Khalturin @DVegasa
 */
const val INVITE = 0
const val NORMAL = 1

class RvGroupsAdapter(private var list: List<GroupItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun update(list: List<GroupItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class InviteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int) {
            itemView.apply {
                val group = list[pos] as GroupInviteData
                tvTitle.text = group.title
                tvDescription.text = group.description
                tvInviter.text = group.inviterName
            }
        }
    }

    inner class NormalVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int) {
            itemView.apply {
                val group = list[pos] as GroupNormalData
                tvTitle.text = group.title
                tvDescription.text = group.description
                tvStatus.text = group.status
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position] is GroupInviteData) return INVITE
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