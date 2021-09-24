package com.kushalsharma.englishmedium

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kushalsharma.englishmedium.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import java.util.*

class MainFragment : Fragment() {

    private var mBottomSheetLayout: CardView? = null
    private var sheetBehavior: BottomSheetBehavior<*>? = null
    private var header_bottom_sheet: ImageView? = null

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    private var jitsiRepo = JitsiRepo()

    private var textToSpeech: TextToSpeech? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding!!.root

        mBottomSheetLayout = view.findViewById(R.id.bottom_sheet)
        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout!!)
        header_bottom_sheet = view.findViewById(R.id.bottom_sheet_arrow)

        header_bottom_sheet!!.setOnClickListener {
            if (sheetBehavior!!.state != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                sheetBehavior!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }

        // adding text to spreech
        textToSpeech = TextToSpeech(
            this.requireContext()
        ) { i ->
            // if No error is found then only it will run
            if (i != TextToSpeech.ERROR) {
                // To Choose language of speech
                textToSpeech!!.language = Locale.ENGLISH
            }
        }

        view.btn_room1.setOnClickListener {
            jitsiRepo.buildJitsiRoom("Room-1 Bottle English", this.requireContext())
        }
        view.btn_room2.setOnClickListener {
            jitsiRepo.buildJitsiRoom("Room-2 Bottle English", this.requireContext())

        }
        view.btn_room3.setOnClickListener {
            jitsiRepo.buildJitsiRoom("Room-3 Bottle English", this.requireContext())

        }
        view.btn_room4.setOnClickListener {
            jitsiRepo.buildJitsiRoom("Room-4 Bottle English", this.requireContext())

        }
        view.btn_room5.setOnClickListener {
            jitsiRepo.buildJitsiRoom("Room-5 Bottle English", this.requireContext())

        }
        view.btn_room6.setOnClickListener {
            jitsiRepo.buildJitsiRoom("Room-6 Bottle English", this.requireContext())

        }

        view.btn_CreateRoom.setOnClickListener {
            alertDialog()
        }

        view.playAudio_wod.setOnClickListener {
            textToSpeech!!.speak(view.wordOfTheDay.text.toString(), TextToSpeech.QUEUE_FLUSH, null)
        }

        view.playAudio_sod.setOnClickListener {
            textToSpeech!!.speak(view.slangOfTheDay.text.toString(), TextToSpeech.QUEUE_FLUSH, null)

        }
        view.playAudio_ttod.setOnClickListener {
            textToSpeech!!.speak(
                view.toungeTwistterOfDay.text.toString(),
                TextToSpeech.QUEUE_FLUSH,
                null
            )
        }
        view.playAudio_idiom.setOnClickListener {
            textToSpeech!!.speak(view.title_idiom.text.toString(), TextToSpeech.QUEUE_FLUSH, null)
        }

        view.game_card_1.setOnClickListener {
            //FastEnglish Game
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_fastEnglishGameFragment)
        }

        view.game_card_2.setOnClickListener {
            // Monster English Game
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_monsterPhrasesFragment)

        }

        return view
    }

    private fun alertDialog() {
        //creating editText to take name of room
        val editText = EditText(this.requireContext())
        editText.hint = "Room Zarvis"

        //creating alert Dialog and adding editText in it.
        AlertDialog.Builder(this.requireContext())
            .setTitle("Enter Your Room Name")
            .setView(editText)
            .setPositiveButton("Create", DialogInterface.OnClickListener { dialog, id ->
                if (editText.text.toString() == "") {
                    Toast.makeText(
                        this.requireContext(), "Please enter room name.", Toast.LENGTH_SHORT
                    ).show()

                } else {
                    jitsiRepo.buildJitsiRoom(editText.text.toString(), this.requireContext())

                }
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener({ dialog, id ->
                dialog.cancel()
            }))

            .create()
            .show()


    }


    override fun onStart() {
        super.onStart()
        if (sheetBehavior!!.state == BottomSheetBehavior.STATE_COLLAPSED) {
            sheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
        }

    }
}

