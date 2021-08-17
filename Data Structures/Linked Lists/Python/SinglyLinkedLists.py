class SinglyLinkedList:
    def __init__(self, data=None):
        self.__head = self.__Node(data)

    def insert(self, data, pos):
        if pos == 0:
            if self.__head.data == None:
                self.__head = self.__Node(data)
            else:
                dummyHead = self.__head
                self.__head = self.__Node(data)
                self.__head.next = dummyHead
        elif pos == self.size():
            self.append(data)
        elif pos < 0 or pos > self.size():
            raise IndexError()
        else:
            curr = self.__head
            p = 0
            while curr != None:
                p += 1
                if pos == p:
                    break
                curr = curr.next
            newNode = self.__Node(data)
            newNode.next = curr.next
            curr.next = newNode

    def append(self, data):
        if data == None:
            raise ValueError("None type data not allowed")
        if self.__head.data == None:
            self.__head = self.__Node(data)
        else:
            curr = self.__head
            while curr.next != None:
                curr = curr.next
            curr.next = self.__Node(data)

    def remove(self, index):
        if index == 0:
            return self.removeHead()
        elif index == self.size() - 1:
            return self.removeTail()
        elif index < 0 or index >= self.size():
            raise IndexError()
        else:
            p = 0
            curr = self.__head
            while curr.next.next != None:
                if index == p + 1:
                    data = curr.next.data
                    curr.next = curr.next.next
                    return data
                curr = curr.next
                p += 1
        return None

    def removeHead(self):
        if self.__head.data == None:
            raise ValueError("Cannot remove head from empty list")
        data = self.__head.data
        self.__head = self.__head.next
        return data

    def removeTail(self):
        if self.__head.data == None:
            raise ValueError("Cannot remove tail from empyty list")
        curr = self.__head
        while curr.next.next != None:
            curr = curr.next
        data = curr.next.data
        curr.next = None
        return data

    def get(self, index):
        if index == 0:
            return self.__head.data
        elif index == self.size() - 1:
            curr = self.__head
            while curr.next != None:
                curr = curr.next
            return curr.data
        elif index < 0 or index >= self.size():
            raise IndexError()
        else:
            p = 0
            curr = self.__head
            while curr.next != None:
                p += 1
                curr = curr.next
                if index == p:
                    return curr.data

    def isEmpty(self):
        return self.size() == 0

    def size(self):
        curr = self.__head
        N = 0
        while curr != None:
            curr = curr.next
            N += 1
        return N

    def __str__(self):
        arr = []
        curr = self.__head
        while curr != None:
            if curr.data != None:
                arr.append(curr.data)
            curr = curr.next
        return arr.__str__()

    class __Node:
        def __init__(self, data=None, next=None):
            self.data = data
            self.next = next
