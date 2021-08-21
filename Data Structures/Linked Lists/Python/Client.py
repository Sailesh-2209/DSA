"""
Testing singly linked list and doubly linked list
"""

import random
import sys
sys.path.append(".")
from SinglyLinkedLists import *  
from DoublyLinkedList import *

sll = SinglyLinkedList()
for i in range(10):
    sll.append(random.randint(0, 1000))
print(sll)

dll = DoublyLinkedList()
for i in range(10):
    dll.append(random.randint(0, 100))
print(dll)