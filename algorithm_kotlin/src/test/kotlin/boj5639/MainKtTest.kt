package boj5639

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj5639/testCase1.txt")
        main()
        isOutputStreamEqualTo("5\n" +
                "28\n" +
                "24\n" +
                "45\n" +
                "30\n" +
                "60\n" +
                "52\n" +
                "98\n" +
                "50")
    }
}
