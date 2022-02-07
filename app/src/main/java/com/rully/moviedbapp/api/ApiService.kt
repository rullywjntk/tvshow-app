package com.rully.moviedbapp.api

import com.rully.moviedbapp.helper.Constants
import com.rully.moviedbapp.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows():Response<TvShowResponse>

}