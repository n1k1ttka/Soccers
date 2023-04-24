package com.example.soccers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.soccers.R
import com.example.soccers.core.base.BaseFragment
import com.example.soccers.core.base.BaseViewModel
import com.example.soccers.databinding.FragmentInformationBinding
import com.example.soccers.vm.InfoViewModel

class InformationFragment: BaseFragment() {

    private lateinit var binding: FragmentInformationBinding
    private val viewModel: InfoViewModel by activityViewModels()
    private val adapter = InformationListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInformationBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.fixturesList.adapter = adapter
        viewModel.items.observe(viewLifecycleOwner) { adapter.replaceItems(it.response) }

        binding.goToThird.setOnClickListener {
            val fragment = WebViewFragment.newInstance()
            parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.navigation_view, fragment)
                .commit()
        }

        return binding.root
    }

    companion object{
        fun newInstance() = InformationFragment()
    }
}