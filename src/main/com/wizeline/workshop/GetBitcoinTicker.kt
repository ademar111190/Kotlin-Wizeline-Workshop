package com.wizeline.workshop

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GetBitcoinTicker(
        private val baseUrl: String = "https://api.coinmarketcap.com/"
) {

    private val datasourse by lazy {
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
                .create(Datasourse::class.java)
    }

    fun execute(): Single<Ticker> {
        return datasourse.getTickets("bitcoin")
                .map { it.asIterable() }
                .flatMapIterable { it }
                .filter { it.id == "bitcoin" }
                .firstOrError()
    }

}
