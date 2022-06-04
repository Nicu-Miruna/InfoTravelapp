package com.fmi.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LocationAdapter(
    private var locationModalArrayList: ArrayList<LocationModal>,
    context: Context?,
    private val onNoteListener: OnNoteListener
) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {
    fun filterList(filterlist: ArrayList<LocationModal>) {
        locationModalArrayList = filterlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.location_rv_item, parent, false)
        return ViewHolder(view, onNoteListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal = locationModalArrayList[position]
        holder.locationNameTV.text = modal.locationName
        holder.locationDescTV.text = modal.locationDescription
    }

    override fun getItemCount(): Int {
        return locationModalArrayList.size
    }

    inner class ViewHolder(itemView: View, onNoteListener: OnNoteListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val locationNameTV: TextView
        val locationDescTV: TextView
        var onNoteListener: OnNoteListener
        var parentLayout: RelativeLayout
        override fun onClick(v: View) {
            onNoteListener.onNoteClick(adapterPosition)
        }

        init {
            locationNameTV = itemView.findViewById(R.id.idTVLocationName)
            locationDescTV = itemView.findViewById(R.id.idTVLocationDescription)
            parentLayout = itemView.findViewById(R.id.parent_layout)
            this.onNoteListener = onNoteListener
            itemView.setOnClickListener(this)
        }
    }

    interface OnNoteListener {
        fun onNoteClick(position: Int)
    }
}