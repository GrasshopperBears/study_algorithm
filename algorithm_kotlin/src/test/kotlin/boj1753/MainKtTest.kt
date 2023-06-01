package boj1753

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj1753/testCase1.txt")
        main()
        isOutputStreamEqualTo("0\n" +
                "2\n" +
                "3\n" +
                "7\n" +
                "INF")
    }
}