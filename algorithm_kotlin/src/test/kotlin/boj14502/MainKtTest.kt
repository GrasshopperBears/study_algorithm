package boj14502

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj14502/testCase1.txt")
        main()
        isOutputStreamEqualTo("27")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj14502/testCase2.txt")
        main()
        isOutputStreamEqualTo("9")
    }

    @Test
    fun test3() {
        setFileInputStream("src/test/kotlin/boj14502/testCase3.txt")
        main()
        isOutputStreamEqualTo("3")
    }
}