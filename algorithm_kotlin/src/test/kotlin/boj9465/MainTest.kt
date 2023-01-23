package boj9465

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainTest {

    @Test
    fun getMaxStickers1() {
        val stickers = arrayOf(arrayOf(50, 10, 100, 20, 40), arrayOf(30, 50, 70, 10, 60))
        assertThat(getMaxStickers(stickers)).isEqualTo(260)
    }

    @Test
    fun getMaxStickers2() {
        val stickers = arrayOf(arrayOf(10, 30, 10, 50, 100, 20, 40), arrayOf(20, 40, 30, 50, 60, 20, 80))
        assertThat(getMaxStickers(stickers)).isEqualTo(290)
    }
}