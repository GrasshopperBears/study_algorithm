import re

def solution(str1, str2):    
    str1Set = []
    str2Set = []
    regex = re.compile(r'[a-zA-Z]{2}')
    
    for i in range(len(str1)-1):
        el = str1[i:i+2].lower()
        if bool(regex.match(el)): str1Set.append(el)
    for i in range(len(str2)-1):
        el = str2[i:i+2].lower()
        if bool(regex.match(el)): str2Set.append(el)
    
    str1Set = sorted(str1Set)
    str2Set = sorted(str2Set)
    
    str1Ptr = 0
    str2Ptr = 0
    result = [0, 0]
    
    while str1Ptr < len(str1Set) or str2Ptr < len(str2Set):
        if str1Ptr == len(str1Set):
            result[1] += len(str2Set) - str2Ptr
            break
        if str2Ptr == len(str2Set):
            result[1] += len(str1Set) - str1Ptr
            break
        if str1Set[str1Ptr] < str2Set[str2Ptr]:
            str1Ptr += 1
            result[1] += 1
        elif str1Set[str1Ptr] > str2Set[str2Ptr]:
            str2Ptr += 1
            result[1] += 1
        else:
            str1Cts = 1
            str2Cts = 1
            while str1Ptr < len(str1Set)-1 and str1Set[str1Ptr] == str1Set[str1Ptr+1]:
                str1Ptr += 1
                str1Cts += 1
            while str2Ptr < len(str2Set)-1 and str2Set[str2Ptr] == str2Set[str2Ptr+1]:
                str2Ptr += 1
                str2Cts += 1
            result[0] += min(str1Cts, str2Cts)
            result[1] += max(str1Cts, str2Cts)
            str1Ptr += 1
            str2Ptr += 1
            
    
    if result[1] == 0: return 65536
    return int(result[0] * 65536 / result[1])
        
print(solution('FRANCE', 'french'))
print(solution('handshake', 'shake hands'))
print(solution('aa1+aa2', 'AAAA12'))
print(solution('E=M*C^2', 'e=m*c^2'))
  