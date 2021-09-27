package com.kushalsharma.englishmedium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kushalsharma.englishmedium.Modals.Word

class WordAdapter(val wordList: ArrayList<Word>) :
    RecyclerView.Adapter<WordAdapter.wordViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wordViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_wod, parent, false)
        return wordViewHolder(v)
    }

    override fun onBindViewHolder(holder: wordViewHolder, position: Int) {

        holder.bindItems(wordList[position])
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    class wordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(word: Word) {
            val wordtv = itemView.findViewById(R.id.item_wordOfTheDay) as TextView
            val meaningtv = itemView.findViewById(R.id.item_meaning) as TextView

            wordtv.text = word.word
            meaningtv.text = word.meaning
        }
    }

}