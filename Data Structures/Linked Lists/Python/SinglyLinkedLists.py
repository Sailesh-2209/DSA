class SinglyLinkedList:
    def __init__(self, data=None):
        self.head = self.__Node(data)

    def insert(data, pos):
        if pos == 0:
            dummyHead = head
            head = Node(data)
            dummyHead.next = head
            head = dummyHead
        elif pos == size():
            append(data)
        elif pos < 0 or pos > self.size():
            raise IndexError()
        else:
            curr = head
            p = 0
            while curr != None:
                p += 1
                if pos == p:
                    break
                curr = curr.next
            newNode = Node(data)
            newNode.next = curr.next
            curr.next = newNode

    def append(data):
        curr = self.head
        while curr.next != None:
            curr = curr.next
        curr.next = Node(data)

    def isEmpty(self):
        return N == 0

    def size(self):
        curr = self.head
        N = 0
        while curr != None:
            curr = curr.next
            N += 1
        return N

    def __str__(self):
        arr = []
        if self.head.data == None:
            return arr.__str__()
        curr = self.head
        while curr != None:
            arr.append(curr.data)
            curr = curr.next
        return arr.__str__()

    class __Node:
        def __init__(self, data=None, next=None):
            self.data = data
            self.next = next


sll = SinglyLinkedList()
print(sll)
