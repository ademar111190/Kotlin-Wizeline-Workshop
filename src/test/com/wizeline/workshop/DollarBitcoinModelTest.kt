package com.wizeline.workshop

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DollarBitcoinModelTest {

    private val DOLLAR = "dollar"
    private val BITCOIN = "bitcoin"

    @Test
    fun testInstantiate() {
        val dollarBitcoinModel = DollarBitcoinModel(DOLLAR, BITCOIN)
        assertThat(dollarBitcoinModel.dollar).isEqualTo(DOLLAR)
        assertThat(dollarBitcoinModel.bitcoin).isEqualTo(BITCOIN)
    }

    @Test
    fun testEquals() {
        assertThat(
                DollarBitcoinModel(DOLLAR, BITCOIN)
        ).isEqualTo(
                DollarBitcoinModel(DOLLAR, BITCOIN)
        )

        assertThat(
                DollarBitcoinModel(DOLLAR, BITCOIN)
        ).isNotEqualTo(
                DollarBitcoinModel("Any", "Thing")
        )
    }

    @Test
    fun testToString() {
        assertThat(
                DollarBitcoinModel(DOLLAR, BITCOIN).toString()
        ).isEqualTo(
                "DollarBitcoinModel(dollar=$DOLLAR, bitcoin=$BITCOIN)"
        )
    }

    @Test
    fun testComponentN() {
        val (dollar, bitcoin) = DollarBitcoinModel(DOLLAR, BITCOIN)
        assertThat(dollar).isEqualTo(DOLLAR)
        assertThat(bitcoin).isEqualTo(BITCOIN)
    }

    @Test
    fun testCopy() {
        val original = DollarBitcoinModel(DOLLAR, BITCOIN)
        val copy = original.copy()
        val different = DollarBitcoinModel("Any", "Thing")

        assertThat(original).isEqualTo(copy)
        assertThat(different).isNotEqualTo(copy)
    }

}
