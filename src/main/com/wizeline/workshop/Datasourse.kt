package com.wizeline.workshop

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Datasourse {

    @GET("v1/ticker/{coin}/")
    fun getTickets(
            @Path("coin") coin: String
    ): Observable<Array<Ticker>>

}
