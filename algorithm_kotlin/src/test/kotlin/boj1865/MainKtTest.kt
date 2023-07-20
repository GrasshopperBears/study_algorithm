package boj1865

import org.junit.jupiter.api.Test
import utils.OutputTest
import utils.setFileInputStream

class MainKtTest: OutputTest() {
    @Test
    fun test1() {
        setFileInputStream("src/test/kotlin/boj1865/testCase1.txt")
        main()
        isOutputStreamEqualTo("NO\n" +
                "YES")
    }
}
