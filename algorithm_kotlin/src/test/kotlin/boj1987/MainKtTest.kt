package boj1987

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj1987/testCase1.txt")
        main()
        isOutputStreamEqualTo("3")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj1987/testCase2.txt")
        main()
        isOutputStreamEqualTo("6")
    }

    @Test
    fun test3() {
        setFileInputStream("src/test/kotlin/boj1987/testCase3.txt")
        main()
        isOutputStreamEqualTo("10")
    }
}
