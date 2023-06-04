package boj1918

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj1918/testCase1.txt")
        main()
        isOutputStreamEqualTo("ABC+*")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj1918/testCase2.txt")
        main()
        isOutputStreamEqualTo("AB+")
    }

    @Test
    fun test3() {
        setFileInputStream("src/test/kotlin/boj1918/testCase3.txt")
        main()
        isOutputStreamEqualTo("ABC*+")
    }

    @Test
    fun test4() {
        setFileInputStream("src/test/kotlin/boj1918/testCase4.txt")
        main()
        isOutputStreamEqualTo("ABC*+DE/-")
    }
}