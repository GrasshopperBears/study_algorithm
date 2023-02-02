package utils

import java.io.FileInputStream

fun setFileInputStream(path: String) {
    System.setIn(FileInputStream(path))
}
