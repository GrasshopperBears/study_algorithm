import re

def indexPairs(text, words):
    regexs = map(re.compile, words)
    for regex in regexs:
        print(regex.findall(text))
        results = (regex.finditer(text))
        for result in results:
            print(result)


print(indexPairs("ababa", ["aba", "ab"]))