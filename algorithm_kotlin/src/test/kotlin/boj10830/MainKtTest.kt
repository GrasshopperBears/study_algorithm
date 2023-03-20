package boj10830

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj10830/testCase1.txt")
        main()
        isOutputStreamEqualTo("69 558\n" +
                "337 406")
    }

    @Test
    fun test2() {
        setFileInputStream("src/test/kotlin/boj10830/testCase2.txt")
        main()
        isOutputStreamEqualTo("468 576 684\n" +
                "62 305 548\n" +
                "656 34 412")
    }

    @Test
    fun test3() {
        setFileInputStream("src/test/kotlin/boj10830/testCase3.txt")
        main()
        isOutputStreamEqualTo("512 0 0 0 512\n" +
                "512 0 0 0 512\n" +
                "512 0 0 0 512\n" +
                "512 0 0 0 512\n" +
                "512 0 0 0 512")
    }
}
