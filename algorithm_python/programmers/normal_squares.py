import math


def solution(w,h):
    prevH = 0
    dead = 0
    x = 1
    if w > h:
        h, w = w, h
    
    while x <= w:
        currH = h * x / w
        dead += math.ceil(currH) - prevH
        if x == w:
            break
        
        if math.floor(currH) == currH:
            mult = math.floor(w / x)
            dead *= mult
            x *= mult
            prevH = math.floor(currH * mult)
        else:
            prevH = math.floor(currH)
            x += 1
    return w * h - dead

    
# print(solution(8, 12))
print(solution(5, 3))
