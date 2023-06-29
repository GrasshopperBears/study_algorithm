package boj18110

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj18110/testCase1.txt")
        main()
        isOutputStreamEqualTo("6")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj18110/testCase2.txt")
        main()
        isOutputStreamEqualTo("13")
    }
}
