package com.example.soccers.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import com.example.soccers.R
import com.example.soccers.core.base.BaseFragment
import com.example.soccers.core.base.BaseViewModel
import com.example.soccers.core.domain.model.Resource
import com.example.soccers.core.domain.model.ResourceState
import com.example.soccers.databinding.FragmentSplashBinding
import com.example.soccers.utils.getDate
import com.example.soccers.vm.InfoViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SplashFragment: BaseFragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel: InfoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel.getInfo(getDate())
            .onEach {
            Log.d("Soccers_getDate()", getDate())
                navigate(it) }
            .launchIn(viewModel.viewModelScope)

        return binding.root
    }


    private fun navigate(result: Resource<String>){
        when(result.state){
            ResourceState.SUCCESS -> {
                val fragment = InformationFragment.newInstance()
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.navigation_view, fragment)
                    .commit()
            }
            ResourceState.ERROR -> {
                Toast.makeText(activity, "Something do wrong... Please, reboot application", Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object{
        fun newInstance() = SplashFragment()
    }
}