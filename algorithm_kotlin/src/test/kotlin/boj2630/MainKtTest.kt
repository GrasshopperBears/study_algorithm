package boj2630

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import java.io.ByteArrayInputStream

class MainKtTest {

    @Test
    fun makeColorPapersTest() {
        val len = 8
        System.setIn(ByteArrayInputStream(("1 1 0 0 0 0 1 1\n" +
                "1 1 0 0 0 0 1 1\n" +
                "0 0 0 0 1 1 0 0\n" +
                "0 0 0 0 1 1 0 0\n" +
                "1 0 0 0 1 1 1 1\n" +
                "0 1 0 0 1 1 1 1\n" +
                "0 0 1 1 1 1 1 1\n" +
                "0 0 1 1 1 1 1 1").toByteArray()))

        assertThat(count(parseInput(len), 0, 0, len)).isEqualTo(CountResult(9, 7))
    }
}
