package com.wizeline.workshop

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DoubleExtTest {

    @Test
    fun testToDollar_basicValue() {
        val dollar = 1.00.toDollar()
        assertThat(dollar).isEqualTo("$ 1.00")
    }

    @Test
    fun testToDollar_decimalValue() {
        val dollar = 0.23456.toDollar()
        assertThat(dollar).isEqualTo("$ 0.23")
    }

    @Test
    fun testToDollar_thousandValue() {
        val dollar = 1234.56.toDollar()
        assertThat(dollar).isEqualTo("$ 1,234.56")
    }

    @Test
    fun testToDollar_basicNegativeValue() {
        val dollar = (-1.00).toDollar()
        assertThat(dollar).isEqualTo("-$ 1.00")
    }

    @Test
    fun testToDollar_decimalNegativeValue() {
        val dollar = (-0.23456).toDollar()
        assertThat(dollar).isEqualTo("-$ 0.23")
    }

    @Test
    fun testToDollar_thousandNegativeValue() {
        val dollar = (-1234.56).toDollar()
        assertThat(dollar).isEqualTo("-$ 1,234.56")
    }

    @Test
    fun testToBitcoin_basicValue() {
        val bitcoin = 1.00.toBitcoin()
        assertThat(bitcoin).isEqualTo("1.00000000 BTC")
    }

    @Test
    fun testToBitcoin_decimalValue() {
        val bitcoin = 0.1234567890.toBitcoin()
        assertThat(bitcoin).isEqualTo("0.12345679 BTC")
    }

    @Test
    fun testToBitcoin_thousandValue() {
        val bitcoin = 1234.56.toBitcoin()
        assertThat(bitcoin).isEqualTo("1234.56000000 BTC")
    }

    @Test
    fun testToBitcoin_basicNegativeValue() {
        val bitcoin = (-1.00).toBitcoin()
        assertThat(bitcoin).isEqualTo("-1.00000000 BTC")
    }

    @Test
    fun testToBitcoin_decimalNegativeValue() {
        val bitcoin = (-0.1234567890).toBitcoin()
        assertThat(bitcoin).isEqualTo("-0.12345679 BTC")
    }

    @Test
    fun testToBitcoin_thousandNegativeValue() {
        val bitcoin = (-1234.56).toBitcoin()
        assertThat(bitcoin).isEqualTo("-1234.56000000 BTC")
    }

}
