class ArrayStack:
    def __init__(self):
        self.stack = []
        self._size = 0

    def push(self, data):
        self.stack.append(data)
        self._size += 1

    def pop(self):
        return self.stack.pop()

    def peek(self):
        return self.stack[len(self.stack) - 1]

    def find(self, item):
        for index, ele in enumerate(self.stack):
            if item == ele:
                return index
        return -1

    def size(self):
        return self._size

    def isEmpty(self):
        return self._size == 0

    def __str__(self):
        return self.stack.__str__()