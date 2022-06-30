def solution(word):
    chars = 'AEIOU'
    charMap = {"A": 0, "E": 1, "I": 2, "O": 3, "U": 4}
    stack = []
    stackMax = 5
    cnt = 0
    
    while True:
        if len(stack) == len(word):
            matched = True
            for i, char in enumerate(stack):
                if char != word[i]:
                    matched = False
                    break
            if matched:
                return cnt
        
        if len(stack) < 5:
            stack.append("A")
            cnt += 1
            continue
        last = stack.pop()
        while last == "U" and len(stack) > 0:
            last = stack.pop()
        stack.append(chars[charMap[last]+1])
        cnt += 1
        
print(solution("AAAAE"))
print(solution("AAAE"))
print(solution("I"))
print(solution("EIO"))
