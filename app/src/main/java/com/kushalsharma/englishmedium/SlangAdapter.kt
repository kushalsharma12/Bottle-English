package com.kushalsharma.englishmedium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kushalsharma.englishmedium.Modals.Slang
import com.kushalsharma.englishmedium.Modals.Word

class SlangAdapter(val slangList: ArrayList<Slang>) :
    RecyclerView.Adapter<SlangAdapter.slangViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): slangViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wod, parent, false)
        return slangViewHolder(v)
    }

    override fun onBindViewHolder(holder: slangViewHolder, position: Int) {

        holder.bindItems(slangList[position])
    }

    override fun getItemCount(): Int {
        return slangList.size
    }

    class slangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(slang: Slang) {
            val wordtv = itemView.findViewById(R.id.item_wordOfTheDay) as TextView
            val meaningtv = itemView.findViewById(R.id.item_meaning) as TextView

            wordtv.text = slang.slang
            meaningtv.text = slang.meaning
        }
    }

}