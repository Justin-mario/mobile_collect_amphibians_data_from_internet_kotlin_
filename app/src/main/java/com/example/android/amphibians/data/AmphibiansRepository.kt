package com.example.android.amphibians.data

import com.example.android.amphibians.model.AmphibiansDetails
import com.example.android.amphibians.network.AmphibiansApiService


interface AmphibiansRepository {
    suspend fun getAmphibiansDetails() : List<AmphibiansDetails>
}


class DefaultAmphibiansDetailsRepository(
    private val amphibiansApiService: AmphibiansApiService) : AmphibiansRepository {
    override suspend fun getAmphibiansDetails(): List<AmphibiansDetails>  = amphibiansApiService.getDetails()


}