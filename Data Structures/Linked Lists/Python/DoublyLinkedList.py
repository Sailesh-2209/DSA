class DoublyLinkedList:
    def __init__(self, data=None, next=None, prev=None):
        self.head = self.tail = self.Node(data, next, prev)
        self._size = 0

    def append(self, data):
        if self.isEmpty():
            self.head = self.tail = self.Node(data)
        else:
            self.tail.next = self.Node(data, None, self.tail)
            self.tail = self.tail.next
        self._size += 1

    def insert(self, index, data):
        if index < 0 or index > self._size: raise IndexError()
        elif index == self._size:
            self.append(data)
        elif index == 0:
            self._insert_at_head(data)
        else:
            curr = self.head
            i = 0
            while i != index - 1:
                curr = curr.next
                i += 1
            newNode = self.Node(data, curr.next, curr)
            curr.next.prev = newNode
            curr.next = newNode
            self._size += 1

    def _insert_at_head(self, data):
        dummy = self.head
        self.head = self.Node(data, dummy, None)
        dummy.prev = self.head
        self._size += 1

    def pop(self):
        if self.isEmpty(): raise ValueError("Cannot remove from empty list")
        node = self.tail
        self.tail = self.tail.prev
        node.next = None
        node.prev = None
        self._size -= 1
        return node.data

    def remove(self, index):
        if self.isEmpty(): raise ValueError("Cannot remove from empty list")
        elif index < 0 or index >= self._size: raise IndexError()
        elif index == 0:
            return self._remove_at_head()
        elif index == self._size - 1:
            return self.pop()
        else:
            i = 0
            curr = self.head
            while i != index - 1:
                curr = curr.next
                i += 1
            node = curr.next
            curr.next = curr.next.next
            curr.next.prev = curr
            self._size -= 1
            node.next = None
            node.prev = None
            return node.data

    def _remove_at_head(self):
        node = self.head
        self.head = self.head.next
        self.head.prev = None
        node.next = None
        node.prev = None
        self._size -= 1
        return node.data

    def size(self):
        return self._size

    def isEmpty(self):
        return self._size == 0
    
    def __str__(self):
        arr = []
        if not self.isEmpty():
            curr = self.head
            for i in range(self._size):
                arr.append(curr.data)
                curr = curr.next
        return arr.__str__()

    class Node:
        def __init__(self, data=None, next=None, prev=None):
            self.data = data
            self.next = next
            self.prev = prev