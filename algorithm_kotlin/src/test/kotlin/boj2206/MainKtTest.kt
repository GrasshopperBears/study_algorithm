package boj2206

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj2206/testCase1.txt")
        main()
        isOutputStreamEqualTo("15")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj2206/testCase2.txt")
        main()
        isOutputStreamEqualTo("-1")
    }
}
