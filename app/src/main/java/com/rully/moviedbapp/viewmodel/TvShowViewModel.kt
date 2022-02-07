package com.rully.moviedbapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rully.moviedbapp.model.TvShowItem
import com.rully.moviedbapp.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow:LiveData<List<TvShowItem>> get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG, "getAllTvShows Error: ${response.code()}")
            }
        }
    }

    companion object {
        const val TAG = "TAG"
    }
}