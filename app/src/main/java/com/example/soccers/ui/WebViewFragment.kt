package com.example.soccers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.soccers.core.base.BaseFragment
import com.example.soccers.databinding.FragmentWebviewBinding
import com.example.soccers.vm.InfoViewModel
import com.onesignal.OneSignal

class WebViewFragment: BaseFragment() {

    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebviewBinding.inflate(inflater)

        // OneSignal Initialization
        OneSignal.initWithContext(requireContext())
        // on below line we are setting app id for our one signal
        OneSignal.setAppId("ca7c89d3-9207-4887-a697-2a1324f07740")

        binding.webView.settings.javaScriptEnabled
        binding.webView.loadUrl("https://www.championat.com/stat/football/")
        return binding.root
    }

    companion object{
        fun newInstance() = WebViewFragment()
    }
}