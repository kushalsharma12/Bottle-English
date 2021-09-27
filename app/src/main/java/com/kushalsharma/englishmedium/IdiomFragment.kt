package com.kushalsharma.englishmedium

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kushalsharma.englishmedium.Modals.Idiom
import com.kushalsharma.englishmedium.Modals.Slang
import com.kushalsharma.englishmedium.databinding.FragmentIdiomBinding
import com.kushalsharma.englishmedium.databinding.FragmentSlangBinding
import java.util.*
import kotlin.collections.ArrayList

class IdiomFragment : Fragment() {

    private var _binding: FragmentIdiomBinding? = null
    private val binding get() = _binding

    private lateinit var adapter: IdiomAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIdiomBinding.inflate(inflater, container, false)
        val view = binding!!.root

        val idioms = ArrayList<Idiom>()

        idioms.add(Idiom("See eye to eye","To agree completely"))
        idioms.add(Idiom("Jump on the bandwagon","Following a trend"))
        idioms.add(Idiom("As right as rain","Perfect"))
        idioms.add(Idiom("Beat around the bush","Avoid saying something"))
        idioms.add(Idiom("Hit the sack","Go to bed"))
        idioms.add(Idiom("Once in a blue moon","Rarely"))
        idioms.add(Idiom("Come rain or shine","No matter what"))
        idioms.add(Idiom("Sat on the fence","To be undecided"))
        idioms.add(Idiom("Break a leg","To wish someone luck"))
        idioms.add(Idiom("Spill the beans","To give away a secret"))

        adapter = IdiomAdapter(idioms)
        binding!!.recyclerViewIdiom.adapter = adapter



        return view

    }

}