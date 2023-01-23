package sample

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.assertThat

class MainTest {

    @Test
    fun main() {
        val testMain = Main()
        assertThat(testMain.main()).isEqualTo("hello first")
    }
}