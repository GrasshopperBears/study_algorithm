package boj2407

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj2407/testCase1.txt")
        main()
        isOutputStreamEqualTo("1192052400")
    }
}
