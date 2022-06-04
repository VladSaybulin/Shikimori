package ru.ironball.shikimori.utils.network

import okhttp3.Interceptor
import okhttp3.Response

class UserAgentInterceptor(private val userAgent: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("User-Agent", userAgent)
            .build()
        return chain.proceed(newRequest)
    }
}