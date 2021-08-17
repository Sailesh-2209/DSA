import random
import sys
sys.path.append(".")
from SinglyLinkedLists import *  # noqa

sll = SinglyLinkedList()
for i in range(10):
    sll.append(random.randint(0, 1000))
print(sll)
