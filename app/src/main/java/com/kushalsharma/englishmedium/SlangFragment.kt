package com.kushalsharma.englishmedium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kushalsharma.englishmedium.Modals.Slang
import com.kushalsharma.englishmedium.databinding.FragmentSlangBinding

class SlangFragment : Fragment() {

    private var _binding: FragmentSlangBinding? = null
    private val binding get() = _binding

    private lateinit var adapter: SlangAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlangBinding.inflate(inflater, container, false)
        val view = binding!!.root

        val slangs = ArrayList<Slang>()

        slangs.add(Slang("lit","When something is very good, enjoyable, or exciting"))
        slangs.add(Slang("Yeet","This refers to throwing something away from yourself at high velocity"))
        slangs.add(Slang("Mutuals"," If two people are following each other, they are mutuals"))
        slangs.add(Slang("Big yikes","you can use this one when you see something that makes you recoil in mild horror or embarrassment"))
        slangs.add(Slang("Dope","Cool or awesome"))
        slangs.add(Slang("Sic/Sick","Cool or sweet"))
        slangs.add(Slang("Fire","Hot, trendy, amazing, or on point (formerly straight fire)"))
        slangs.add(Slang("TBH","To be honest"))
        slangs.add(Slang("Thirsty","Trying to get attention"))
        slangs.add(Slang("YOLO","You Only Live Once"))
        slangs.add(Slang("Sus","Suspicious, shady, not to be trusted"))
        slangs.add(Slang("Netflix and Chill","Used as a front for inviting someone over to make out (or maybe more)"))
        slangs.add(Slang("OMG","An abbreviation for \"Oh my gosh\" or \"Oh my God\"\n"))

        adapter = SlangAdapter(slangs)
        binding!!.recyclerViewSlang.adapter = adapter
        return view
    }

}