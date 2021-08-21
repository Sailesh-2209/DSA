"""
Problem statement and test for the solution
"""

from ListNode import *
from Solution import *
import random

# generating a linked list of random integers
dummyHead = ListNode(0)
curr = dummyHead
size = random.randint(1, 10)
for _ in range(size):
    curr.next = ListNode(random.randint(1, size * 10))
    curr = curr.next

# printing out the linked list
arr = []
curr = dummyHead.next
for _ in range(size):
    arr.append(curr.val)
    curr = curr.next
print("Linked List: ")
print(arr)

# calling the method to reverse the linked list
reversedHead = Solution.reverseList(dummyHead.next)

# printint out the reversed list for verfication
arr = []
curr = reversedHead
for _ in range(size):
    arr.append(curr.val)
    curr = curr.next
print("Reversed List: ")
print(arr)