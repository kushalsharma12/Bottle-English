package com.kushalsharma.englishmedium


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kushalsharma.englishmedium.Modals.Idiom

class IdiomAdapter(val idiomList: ArrayList<Idiom>) :
    RecyclerView.Adapter<IdiomAdapter.idiomViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): idiomViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wod, parent, false)
        return idiomViewHolder(v)
    }

    override fun onBindViewHolder(holder: idiomViewHolder, position: Int) {

        holder.bindItems(idiomList[position])

    }

    override fun getItemCount(): Int {
        return idiomList.size
    }

    class idiomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(idiom: Idiom) {
            val wordtv = itemView.findViewById(R.id.item_wordOfTheDay) as TextView
            val meaningtv = itemView.findViewById(R.id.item_meaning) as TextView

            wordtv.text = idiom.idiom
            meaningtv.text = idiom.meaning
        }

    }

}

