package com.example.android.amphibians.network

import com.example.android.amphibians.model.AmphibiansDetails
import retrofit2.http.GET


interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getDetails(): List<AmphibiansDetails>
}