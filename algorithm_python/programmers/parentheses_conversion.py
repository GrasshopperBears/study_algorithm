def findBalanced(s):
    balance = 0
    for i in range(len(s)):
        char = s[i]
        if char == '(':
            balance += 1
        else:
            balance -= 1
        if balance == 0:
            return i
    return -1
            

def isRight(s):
    stack = 0
    
    for char in s:
        if char == '(':
            stack += 1
        else:
            if stack == 0: return False
            stack -= 1
    return stack == 0


def flip(s):
    result = ''
    for i in range(len(s)):
        if s[i] == '(': result += ')'
        else: result += '('
    return result


def solution(p):
    if len(p) == 0: return p
    
    mid = findBalanced(p) + 1
    u = p[:mid]
    v = p[mid:]
    if isRight(u): return u + solution(v)
    return '(' + solution(v) + ')' + flip(u[1:-1])

# print(solution("(()())()"))
# print(solution(")("))
print(solution("()))((()"))
