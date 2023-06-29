package boj15654

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj15654/testCase1.txt")
        main()
        isOutputStreamEqualTo("2\n" +
                "4\n" +
                "5")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj15654/testCase2.txt")
        main()
        isOutputStreamEqualTo("1 7\n" +
                "1 8\n" +
                "1 9\n" +
                "7 1\n" +
                "7 8\n" +
                "7 9\n" +
                "8 1\n" +
                "8 7\n" +
                "8 9\n" +
                "9 1\n" +
                "9 7\n" +
                "9 8")
    }

    @Test
    fun test3() {
        setFileInputStream("src/test/kotlin/boj15654/testCase3.txt")
        main()
        isOutputStreamEqualTo("1231 1232 1233 1234\n" +
                "1231 1232 1234 1233\n" +
                "1231 1233 1232 1234\n" +
                "1231 1233 1234 1232\n" +
                "1231 1234 1232 1233\n" +
                "1231 1234 1233 1232\n" +
                "1232 1231 1233 1234\n" +
                "1232 1231 1234 1233\n" +
                "1232 1233 1231 1234\n" +
                "1232 1233 1234 1231\n" +
                "1232 1234 1231 1233\n" +
                "1232 1234 1233 1231\n" +
                "1233 1231 1232 1234\n" +
                "1233 1231 1234 1232\n" +
                "1233 1232 1231 1234\n" +
                "1233 1232 1234 1231\n" +
                "1233 1234 1231 1232\n" +
                "1233 1234 1232 1231\n" +
                "1234 1231 1232 1233\n" +
                "1234 1231 1233 1232\n" +
                "1234 1232 1231 1233\n" +
                "1234 1232 1233 1231\n" +
                "1234 1233 1231 1232\n" +
                "1234 1233 1232 1231")
    }
}
