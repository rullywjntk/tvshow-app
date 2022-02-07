package com.rully.moviedbapp.repository

import com.rully.moviedbapp.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService){

    suspend fun getTvShows() = apiService.getTvShows()
}