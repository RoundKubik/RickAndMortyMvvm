package ru.kubov.feature.data.remote.api

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.kubov.feature.data.remote.api.FeatureApiService.Companion.BASE_URL
import ru.kubov.feature.data.remote.api.FeatureApiService.Companion.CHARACTER_ENDPOINT
import javax.inject.Inject

class OkHttpFeatureApiImpl @Inject constructor(private val okHttpClient: OkHttpClient) : FeatureApiService {

    override fun getCharacters(): String {
        val request = Request.Builder()
            .url((BASE_URL + CHARACTER_ENDPOINT).toHttpUrl())
            .build()
        return try {
            handleRequest(request = request)
        } catch (e: Exception) {
            e.toString()
        }
    }

    private fun handleRequest(request: Request): String {
        okHttpClient.newCall(request = request).execute().use {
            return if (it.isSuccessful) {
                val body = it.body
                body?.string() ?: "No content"
            } else {
                "Response code: ${it.code}"
            }
        }
    }
}