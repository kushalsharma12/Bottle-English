package com.kushalsharma.englishmedium

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.MalformedURLException
import java.net.URL

class JitsiRepo {

    fun settingUpJitsi() {
        try {
            // object creation of JitsiMeetConferenceOptions
            // class by the name of options
            val options = JitsiMeetConferenceOptions.Builder()
                .setServerURL(URL(""))
                .setWelcomePageEnabled(false)
                .build()
        } catch (e: MalformedURLException) {
            e.printStackTrace();
        }

    }

    fun buildJitsiRoom(text: String, context: Context) {
        if (text.length > 0) {
            // creating a room using  JitsiMeetConferenceOptions class
            // here .setRoom() method will set the text in room name
            // here launch method with launch a new room to user where
            // they can invite others too.
            GlobalScope.launch(Dispatchers.IO) {
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
                JitsiMeetActivity.launch(context, options)


            }
        }

    }


}