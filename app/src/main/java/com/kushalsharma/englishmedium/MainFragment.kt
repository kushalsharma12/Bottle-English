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
        /*  Currently there are theree section of this bottom sheet
         1) Jitsi Rooms creating section
         2) Games Section
         3) Words/Slangs/Tounge Twistters/ idioms section   */


        // Jitsi Room Creating Section

        // adding text to speech
        textToSpeech = TextToSpeech(
            this.requireContext()
        ) { i ->
            // if No error is found then only it will run
            if (i != TextToSpeech.ERROR) {
                // To Choose language of speech
                textToSpeech!!.language = Locale.ENGLISH
            }
        }

        //creating JitsiRooms by clicking on buttons

        view.btn_room1.setOnClickListener {
            buildingJitsi("Room-1 Bottle English")
        }
        view.btn_room2.setOnClickListener {
            buildingJitsi("Room-2 Bottle English")
        }
        view.btn_room3.setOnClickListener {
            buildingJitsi("Room-3 Bottle English")
        }
        view.btn_room4.setOnClickListener {
            buildingJitsi("Room-4 Bottle English")

        }
        view.btn_room5.setOnClickListener {
            buildingJitsi("Room-5 Bottle English")

        }
        view.btn_room6.setOnClickListener {
            buildingJitsi("Room-6 Bottle English")

        }

        // creating jitsi room with user's room name
        view.btn_CreateRoom.setOnClickListener {
            alertDialog()
        }

        // Games Sections

        //FastEnglish Game
        view.game_card_1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_fastEnglishGameFragment)
        }

        // Monster English Game
        view.game_card_2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_monsterPhrasesFragment)
        }

//        Words/Slangs/Tounge Twistters/ idioms section

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

        view.wordOfTheDay_cardView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_wordFragment)
        }
        view.slangOfTheDay_caarview.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_slangFragment)
        }
        view.idiom_cardView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_idiomFragment)
        }
        view.toungeTwistter_cardView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_toungeTwisterFragment)
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
                    buildingJitsi(editText.text.toString())
                }
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
            .create()
            .show()


    }

    private fun buildingJitsi(roomName: String) {
        jitsiRepo.buildJitsiRoom(roomName, this.requireContext())
    }


    override fun onStart() {
        super.onStart()
        // sheet should be expanded when fragment starts
        if (sheetBehavior!!.state == BottomSheetBehavior.STATE_COLLAPSED) {
            sheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}

