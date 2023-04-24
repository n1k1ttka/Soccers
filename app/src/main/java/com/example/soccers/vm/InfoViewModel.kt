package com.example.soccers.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.soccers.core.base.BaseViewModel
import com.example.soccers.core.domain.model.Resource
import com.example.soccers.core.domain.model.ResourceState
import com.example.soccers.core.network.model.NetworkResult
import com.example.soccers.core.network.model.onError
import com.example.soccers.core.network.model.onSuccess
import com.example.soccers.network.ApiFootballService
import com.example.soccers.network.ApiFootballSource
import com.example.soccers.network.RetrofitClient
import com.example.soccers.network.RetrofitFootballApiSource
import com.example.soccers.network.model.FixtureResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext


class InfoViewModel: BaseViewModel() {

    private val apiFootballService = RetrofitClient.getInstance().create(ApiFootballService::class.java)
    private val apiFootballSource: ApiFootballSource = RetrofitFootballApiSource(apiFootballService)

    private val _items = MutableLiveData<FixtureResponce>()
    val items: LiveData<FixtureResponce> = _items

    fun getInfo(date: String): Flow<Resource<String>> = flow {
        emit(Resource(ResourceState.LOADING))
        try {
            val data = withContext(Dispatchers.IO){
                apiFootballSource.getFixtures(date)
            }

            Log.d("Kolgushkin_data", "$data")

            when (data) {
                is NetworkResult.Success -> {
                    data.onSuccess().apply {
                        emit(Resource(ResourceState.SUCCESS))
                        _items.value = this
                        Log.d("Kolgushkin_inResult", "$this")
                    }
                }
                is NetworkResult.Error -> {
                    data.onError().apply {
                        emit(Resource(ResourceState.ERROR))
                        Log.d("Kolgushkin_Error", "$this")
                    }
                }
            }
        } catch (e: Throwable){
            emit(Resource(ResourceState.ERROR))
        }
    }

    companion object {
//        fun factory(
//            geckoApiSource: ApiFootballSource
//        ) = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return InfoViewModel(geckoApiSource) as T
//            }
//        }
    }
}