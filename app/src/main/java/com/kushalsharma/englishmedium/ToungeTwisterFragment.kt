package com.kushalsharma.englishmedium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kushalsharma.englishmedium.Modals.ToungeTwister
import com.kushalsharma.englishmedium.databinding.FragmentToungeTwisterBinding

class ToungeTwisterFragment : Fragment() {

    private var _binding: FragmentToungeTwisterBinding? = null
    private val binding get() = _binding

    private lateinit var adapter: ToungeTwistterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentToungeTwisterBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root

        val toungeTwisters = ArrayList<ToungeTwister>()

        toungeTwisters.add(ToungeTwister("She sells seashells by the seashore"))
        toungeTwisters.add(ToungeTwister("How can a clam cram in a clean cream can?"))
        toungeTwisters.add(ToungeTwister("I scream, you scream, we all scream for ice cream"))
        toungeTwisters.add(ToungeTwister("I saw Susie sitting in a shoeshine shop"))
        toungeTwisters.add(ToungeTwister("I saw a kitten eating chicken in the kitchen"))
        toungeTwisters.add(ToungeTwister("If a dog chews shoes, whose shoes does he choose?"))
        toungeTwisters.add(ToungeTwister("I thought I thought of thinking of thanking you"))
        toungeTwisters.add(ToungeTwister("Fuzzy Wuzzy was a bear. Fuzzy Wuzzy had no hair. Fuzzy Wuzzy wasn’t fuzzy, was he?"))
        toungeTwisters.add(ToungeTwister("I have got a date at a quarter to eight; I’ll see you at the gate, so don’t be late"))
        toungeTwisters.add(ToungeTwister("You know New York, you need New York, you know you need unique New York"))
        toungeTwisters.add(ToungeTwister("A skunk sat on a stump and thunk the stump stunk, but the stump thunk the skunk stunk"))


        adapter = ToungeTwistterAdapter(toungeTwisters)
        binding!!.recyclerViewTt.adapter = adapter
        return view
    }
}