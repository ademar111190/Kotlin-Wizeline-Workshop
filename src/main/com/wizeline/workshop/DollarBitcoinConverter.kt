package com.wizeline.workshop

import io.reactivex.Single

class DollarBitcoinConverter(
        private val getBitcoinTicker: GetBitcoinTicker = GetBitcoinTicker()
) {

    fun execute(dollar: String?): Single<DollarBitcoinModel> {
        val amount = dollar?.toDoubleOrNull()
        return if (amount is Double) {
            getBitcoinTicker.execute()
                    .map { it.price?.toDoubleOrNull() }
                    .filter { it > 0.0 }
                    .map { amount / it }
                    .map { DollarBitcoinModel(amount.toDollar(), it.toBitcoin()) }
                    .toSingle()
        } else {
            Single.error(IllegalArgumentException("Cannot convert $dollar"))
        }
    }

}
