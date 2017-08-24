package com.wizeline.workshop

import com.google.gson.annotations.SerializedName

class Ticker {

    @SerializedName("price_usd")
    var price: String? = null

    @SerializedName("id")
    var id: String? = null

}
