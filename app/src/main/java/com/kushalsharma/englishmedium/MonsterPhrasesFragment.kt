package com.kushalsharma.englishmedium

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.kushalsharma.englishmedium.databinding.FragmentMonsterPhrasesBinding
import kotlinx.android.synthetic.main.fragment_monster_phrases.*

private var _binding: FragmentMonsterPhrasesBinding? = null
private val binding get() = _binding

val monsterGamesUrl = "https://www.gamestolearnenglish.com/monster-phrases/"


class MonsterPhrasesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMonsterPhrasesBinding.inflate(inflater, container, false)
        val view = binding!!.root

        //load webview with fetching url using function loadwebView
        loadWebView(monsterGamesUrl)

        //going back to mainFragment
        binding!!.goToHomeBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_monsterPhrasesFragment_to_mainFragment)
        }


        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView(url: String) {
        binding!!.monsterPhrasesWebView.settings.javaScriptEnabled = true
        binding!!.monsterPhrasesWebView.webViewClient = WebViewClient()
        binding!!.monsterPhrasesWebView.loadUrl(url)
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
            binding!!.progressBar.visibility = View.GONE
        }
    }


}