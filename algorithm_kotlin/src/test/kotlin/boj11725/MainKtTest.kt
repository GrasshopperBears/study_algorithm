package boj11725

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj11725/testCase1.txt")
        main()
        isOutputStreamEqualTo("4\n" +
                "6\n" +
                "1\n" +
                "3\n" +
                "1\n" +
                "4")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj11725/testCase2.txt")
        main()
        isOutputStreamEqualTo("1\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "3\n" +
                "4\n" +
                "4\n" +
                "5\n" +
                "5\n" +
                "6\n" +
                "6")
    }
}
