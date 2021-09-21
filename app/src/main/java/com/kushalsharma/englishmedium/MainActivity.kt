package com.kushalsharma.englishmedium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kushalsharma.englishmedium.databinding.ActivityMainBinding
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.MalformedURLException
import java.net.URL

private lateinit var binding : ActivityMainBinding
private var jitsiRepo = JitsiRepo()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jitsiRepo.settingUpJitsi()


    }

    fun onRoomClicked(text : String) {

        if (text.length > 0) {
            // creating a room using  JitsiMeetConferenceOptions class
            // here .setRoom() method will set the text in room name
            // here launch method with launch a new room to user where
            // they can invite others too.
            val options = JitsiMeetConferenceOptions.Builder()
                .setRoom(text)
                .setAudioMuted(false)
                .setFeatureFlag("chat.enabled", false)
                .setFeatureFlag("live-streaming.enabled", false)
                .setFeatureFlag("raise-hand.enabled", false)
                .setFeatureFlag("recording.enabled", false)
                .setFeatureFlag("toolbox.alwaysVisible", true)
                .setFeatureFlag("video-share.enabled", false)
                .setFeatureFlag("video-mute.enabled", false)
                .setFeatureFlag("help.enabled", false)
                .setFeatureFlag("reactions.enabled", true)
                .setVideoMuted(true)
                .setAudioOnly(true)
                .build()
            JitsiMeetActivity.launch(this, options)
        }

    }

}