package com.kushalsharma.englishmedium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kushalsharma.englishmedium.Modals.Word
import com.kushalsharma.englishmedium.databinding.FragmentWordBinding


class WordFragment : Fragment() {

    private var _binding: FragmentWordBinding? = null
    private val binding get() = _binding
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWordBinding.inflate(inflater, container, false)
        val root = binding!!.root

        val words = ArrayList<Word>()

        words.add(Word("ambigue", "An ambiguous statement or expression."))
        words.add(Word("fantoosh", "stylish, sophisticated; fashionable, exotic."))
        words.add(Word("hench", "Of a person having a powerful, muscular physique."))
        words.add(Word("influencer","Someone who affects or changes the way that other people behave."))
        words.add(Word("pronoid", "A person who is convinced of the goodwill of others towards himself or herself."))
        words.add(Word("shero", "A female hero; a heroine."))
        words.add(Word("skunked", "Drunk, intoxicated. In later use also under the influence of marijuana."))
        words.add(Word("zoodle", "A spiralised strand of zucchini, sometimes used as a substitute for pasta."))
        words.add(Word("truthiness", "A seemingly truthful quality not supported by facts or evidence.")        )
        words.add(Word("Cajole", "persuade by flattery or coaxing."))
        words.add(Word("Clamor", "proclaim something noisily."))
        words.add(Word("Ostracism", "excluding a person or certain section from society by majority consent."))
        words.add(Word("Travesty", "distorting facts or imitation."))
        words.add(Word("Multifarious", "The university offers multifarious activities."))

        adapter = WordAdapter(words)
        binding!!.recylerViewWod.adapter = adapter
        return root
    }

}