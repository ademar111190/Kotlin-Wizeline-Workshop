package com.wizeline.workshop

import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class DollarBitcoinConverterTest {

    @Mock lateinit var mockGetBitcoinTicker: GetBitcoinTicker

    private lateinit var mockTicker: Ticker

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockTicker = Ticker().apply {
            price = "4075.22"
        }
    }

    @Test
    fun testExecute_successCase() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
                .test()
                .assertValue(DollarBitcoinModel("$ 1.00", "0.00024539 BTC"))
                .assertNoErrors()
    }

    @Test
    fun testExecute_nullAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute(null)
                .test()
                .assertError(IllegalArgumentException::class.java)
    }

    @Test
    fun testExecute_invalidAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("An invalid string")
                .test()
                .assertError(IllegalArgumentException::class.java)
    }

    @Test
    fun testExecute_zeroAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("0")
                .test()
                .assertValue(DollarBitcoinModel("$ 0.00", "0.00000000 BTC"))
                .assertNoErrors()
    }

    @Test
    fun testExecute_negativeAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("-1")
                .test()
                .assertValue(DollarBitcoinModel("-$ 1.00", "-0.00024539 BTC"))
                .assertNoErrors()
    }

    @Test
    fun testExecute_nullPrice() {
        mockTicker.price = null
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
                .test()
                .assertError(NullPointerException::class.java)
    }

    @Test
    fun testExecute_invalidPrice() {
        mockTicker.price = "An invalid price"
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
                .test()
                .assertError(NullPointerException::class.java)
    }

    @Test
    fun testExecute_zeroPrice() {
        mockTicker.price = "0"
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
                .test()
                .assertError(NoSuchElementException::class.java)
    }

    @Test
    fun testExecute_negativePrice() {
        mockTicker.price = "-1"
        whenever(mockGetBitcoinTicker.execute()).thenReturn(Single.just(mockTicker))

        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
                .test()
                .assertError(NoSuchElementException::class.java)
    }

}
