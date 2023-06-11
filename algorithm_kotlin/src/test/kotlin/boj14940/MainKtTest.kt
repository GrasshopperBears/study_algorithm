package boj14940

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj14940/testCase1.txt")
        main()
        isOutputStreamEqualTo("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14\n" +
                "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15\n" +
                "2 3 4 5 6 7 8 9 10 11 12 13 14 15 16\n" +
                "3 4 5 6 7 8 9 10 11 12 13 14 15 16 17\n" +
                "4 5 6 7 8 9 10 11 12 13 14 15 16 17 18\n" +
                "5 6 7 8 9 10 11 12 13 14 15 16 17 18 19\n" +
                "6 7 8 9 10 11 12 13 14 15 16 17 18 19 20\n" +
                "7 8 9 10 11 12 13 14 15 16 17 18 19 20 21\n" +
                "8 9 10 11 12 13 14 15 16 17 18 19 20 21 22\n" +
                "9 10 11 12 13 14 15 16 17 18 19 20 21 22 23\n" +
                "10 11 12 13 14 15 16 17 18 19 20 21 22 23 24\n" +
                "11 12 13 14 15 16 17 18 19 20 0 0 0 0 25\n" +
                "12 13 14 15 16 17 18 19 20 21 0 29 28 27 26\n" +
                "13 14 15 16 17 18 19 20 21 22 0 30 0 0 0\n" +
                "14 15 16 17 18 19 20 21 22 23 0 31 32 33 34")
    }
}
