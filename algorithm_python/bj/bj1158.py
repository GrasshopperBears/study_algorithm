import sys


class Node:
    def __init__(self, val = None):
        self.val = val
        self.next = None
        self.prev = None


stdin = sys.stdin
(a, b) = map(int, stdin.readline().split())
ans = []

head = Node(1)
tail = head
head.next = tail
tail.prev = head

for i in range(2, a+1):
    newNode = Node(i)
    tail.next = newNode
    newNode.prev = tail
    tail = newNode

tail.next = head
head.prev = tail
curr = tail

while True:
    for i in range(b):
        curr = curr.next
    ans.append(curr.val)
    if curr.next == curr:
        break
    curr.prev.next = curr.next
    curr.next.prev = curr.prev


print(f'<{", ".join(map(str, ans))}>')
