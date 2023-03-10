package boj15666

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj15666/testCase1.txt")
        main()
        isOutputStreamEqualTo("2\n" +
                "4")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj15666/testCase2.txt")
        main()
        isOutputStreamEqualTo("1 1\n" +
                "1 7\n" +
                "1 9\n" +
                "7 7\n" +
                "7 9\n" +
                "9 9")
    }

    @Test
    fun test3() {
        setFileInputStream("src/test/kotlin/boj15666/testCase3.txt")
        main()
        isOutputStreamEqualTo("1 1 1 1\n" +
                "1 1 1 2\n" +
                "1 1 2 2\n" +
                "1 2 2 2\n" +
                "2 2 2 2")
    }
}