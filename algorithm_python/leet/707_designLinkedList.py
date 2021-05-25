class MyLinkedListNode:
    def __init__(self, value, prev=None, nxt=None):
        self.value = value
        self.prev = prev
        self.next = nxt


class MyLinkedList(object):

    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def get(self, index):
        if index >= self.size:
            return -1
        currIdx = 0
        curr = self.head
        while (currIdx < index):
            if curr == None:
                return -1
            curr = curr.next
            currIdx += 1
        return curr.value if curr != None else -1

    def addAtHead(self, val):
        newNode = MyLinkedListNode(val)
        self.size += 1
        if self.head == None:
            self.head = newNode
            self.tail = newNode
            return
        self.head.prev = newNode
        newNode.next = self.head
        self.head = newNode

    def addAtTail(self, val):
        newNode = MyLinkedListNode(val)
        self.size += 1
        if self.head == None:
            self.head = newNode
            self.tail = newNode
            return
        self.tail.next = newNode
        newNode.prev = self.tail
        self.tail = newNode

    def addAtIndex(self, index, val):
        if index > self.size:
            return
        if index == 0:
            return self.addAtHead(val)
        currIdx = 0
        curr = self.head
        while (currIdx < index):
            if curr == None:
                return
            curr = curr.next
            currIdx += 1
        if curr == None:
            return self.addAtTail(val)
        newNode = MyLinkedListNode(val)
        curr.prev.next = newNode
        newNode.prev = curr.prev
        curr.prev = newNode
        newNode.next = curr
        self.size += 1

    def deleteAtIndex(self, index):
        if index >= self.size:
            return
        if self.size == 1:
            self.head = None
            self.tail = None
            self.size -= 1
            return
        if index == 0:
            self.head.next.prev = None
            self.head = self.head.next
            self.size -= 1
            return
        if index == self.size - 1:
            self.tail.prev.next = None
            self.tail = self.tail.prev
            self.size -= 1
            return
        currIdx = 0
        curr = self.head
        while (currIdx < index):
            if curr == None:
                return
            curr = curr.next
            currIdx += 1
        curr.next.prev = curr.prev
        curr.prev.next = curr.next
        self.size -= 1


# Your MyLinkedList object will be instantiated and called as such:
obj = MyLinkedList()
obj.addAtHead(5)
obj.addAtIndex(1, 2)
obj.addAtHead(6)
obj.addAtTail(2)
print(obj.get(3))
# obj.addAtIndex(0, 20)
# obj.addAtIndex(1, 30)
# obj.addAtHead(7)
# obj.addAtHead(2)
# obj.addAtHead(1)
# obj.addAtTail(3)
# obj.addAtIndex(3, 0)
# param_2 = obj.get(1)
# obj.deleteAtIndex(0)
# param_3 = obj.get(1)
# print( param_3)
