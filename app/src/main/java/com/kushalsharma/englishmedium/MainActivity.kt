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
}



