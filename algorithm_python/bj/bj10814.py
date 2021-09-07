import sys

caseNum = int(sys.stdin.readline())
memberDictionary = {}

for i in range(caseNum):
    line = sys.stdin.readline().strip().split(' ')
    age = int(line[0])
    name = line[1]
    existVal = memberDictionary.get(age)
    if existVal is not None:
        existVal.append(name)
        memberDictionary[age] = existVal
    else:
        memberDictionary[age] = [name]

for i in sorted(memberDictionary.items()):
    for j in i[1]:
        print(f'{i[0]} {j}')