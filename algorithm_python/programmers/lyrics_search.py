from collections import defaultdict

def charToIdx(char):
    return ord(char) - 97


class Node:
    def __init__(self):
        self.lens = defaultdict(int)
        self.children = [None for _ in range(26)]
    def getChild(self, char):
        charIdx = charToIdx(char)
        if self.children[charIdx] == None:
            self.children[charIdx] = Node()
        return self.children[charIdx]
    def getNodes(self):
        return list(filter(lambda n: n != None, self.children))
        

def solution(words, queries):
    root = Node()
    rootReversed = Node()
    answer = []
    
    for word in words:
        wordLen = len(word)
        current = root
        currentReversed = rootReversed
        
        current.lens[wordLen] += 1
        currentReversed.lens[wordLen] += 1
        
        for i in range(wordLen):
            current = current.getChild(word[i])
            currentReversed = currentReversed.getChild(word[wordLen-i-1])
            
            current.lens[wordLen-i-1] += 1
            currentReversed.lens[wordLen-i-1] += 1
    
    for query in queries:
        queue = [rootReversed] if query[0] == '?' else [root]
        if query[0] == '?': query = reversed(query)
        wildCnt = 0
        
        for char in query:
            nextQueue = []
            if char == '?':
                wildCnt += 1
                continue
            for node in queue:
                nextQueue.append(node.getChild(char))
            queue = nextQueue
        cnt = 0
        for node in queue:
            cnt += node.lens[wildCnt]
        answer.append(cnt)
    
    
    return answer

print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
