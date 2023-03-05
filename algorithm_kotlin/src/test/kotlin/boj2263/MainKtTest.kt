package boj2263

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun testCase1() {
        setFileInputStream("src/test/kotlin/boj2263/testCase1.txt")
        main()
        isOutputStreamEqualTo("2 1 3")
    }
}