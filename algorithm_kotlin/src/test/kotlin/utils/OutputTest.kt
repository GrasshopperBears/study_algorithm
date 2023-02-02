package utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class OutputTest {
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    fun isOutputStreamEqualTo(expected: String) {
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expected)
    }
}