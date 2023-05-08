package boj13549

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj13549/testCase1.txt")
        main()
        isOutputStreamEqualTo("2")
    }
}
