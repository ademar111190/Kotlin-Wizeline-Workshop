package com.wizeline.workshop

import io.reactivex.Single

class DollarBitcoinConverter(
        private val getBitcoinTicker: GetBitcoinTicker = GetBitcoinTicker()
) {

    fun execute(dollar: String?): Single<DollarBitcoinModel> {
        // TODO complete this function making the DollarBitcoinConverterTest tests pass
    }

}
