package io.github.dvegasa.travelhackmoscow.screens.group_info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.dvegasa.travelhackmoscow.R
import io.github.dvegasa.travelhackmoscow.pojos.Poi
import kotlinx.android.synthetic.main.item_poi.view.*

/**
 * Created by Ed Khalturin @DVegasa
 */
class RvPoiAdapters(var pois: List<Poi>) : RecyclerView.Adapter<RvPoiAdapters.VH>() {
    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int) {
            val poi = pois[pos]
            itemView.apply {
                tvTitle.text = poi.title
                tvDesc.text = poi.description
                tvAddress.text = poi.address
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_poi, parent))
    }

    override fun getItemCount() = pois.size
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }
}
