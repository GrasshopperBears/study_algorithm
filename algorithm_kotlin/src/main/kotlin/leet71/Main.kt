package leet71

class Main {
    companion object {
        private const val CURRENT = "."
        private const val PARENT = ".."
    }

    fun simplifyPath(path: String): String {
        val tokens = path.split('/')
        val stack = mutableListOf<String>()

        for (token in tokens) {
            if (token == CURRENT || token.isEmpty()) {
                continue
            }
            if (token == PARENT) {
                if (stack.size > 0) {
                    stack.removeLast()
                }
                continue
            }
            stack.add(token)
        }

        return "/${stack.joinToString("/")}"
    }
}
