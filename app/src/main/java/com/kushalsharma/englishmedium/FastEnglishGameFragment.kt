package com.kushalsharma.englishmedium

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.kushalsharma.englishmedium.databinding.FragmentFastEnglishGameBinding

private var _binding: FragmentFastEnglishGameBinding? = null
private val binding get() = _binding

val fastEngGameUrl = "https://www.gamestolearnenglish.com/fast-english/"


class FastEnglishGameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFastEnglishGameBinding.inflate(inflater, container, false)
        val view = binding!!.root

        //load webview with fetching url using function loadwebView
        loadWebView(fastEngGameUrl)


        //going back to main fragment
        binding!!.goToHomeBtnFastEng.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fastEnglishGameFragment_to_mainFragment)
        }

        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView(url: String) {
        binding!!.fastEngWebView.settings.javaScriptEnabled = true
        binding!!.fastEngWebView.webViewClient = WebViewClient()
        binding!!.fastEngWebView.loadUrl(url)


    }

    inner class WebViewClient : android.webkit.WebViewClient() {

        // Load the URL
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding!!.fastEngprogressBar.visibility = View.GONE
        }
    }

}