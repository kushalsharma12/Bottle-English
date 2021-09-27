package com.kushalsharma.englishmedium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kushalsharma.englishmedium.Modals.ToungeTwister

class ToungeTwistterAdapter(val ttList: ArrayList<ToungeTwister>) :
    RecyclerView.Adapter<ToungeTwistterAdapter.ttViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ttViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wod, parent, false)
        return ttViewHolder(v)
    }

    override fun onBindViewHolder(holder: ttViewHolder, position: Int) {

        holder.bindItems(ttList[position])
    }

    override fun getItemCount(): Int {
        return ttList.size
    }

    class ttViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(tt: ToungeTwister) {
            val wordtv = itemView.findViewById(R.id.item_wordOfTheDay) as TextView

            wordtv.text = tt.toungeTwister
        }
    }

}