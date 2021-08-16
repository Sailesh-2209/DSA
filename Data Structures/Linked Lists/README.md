# Linked Lists

- Linked lists are data structures in which elements are **not** stored in contiguous memory locations.
- The elements of a linked list are linked to each other by the use of pointers.

## Representaion of a linked list

![Linked Lists](https://miro.medium.com/max/2000/1*foYFeuEFVBsEPyKG0Jhd7w.png)

- Linked lists are made up of `nodes`. A `node` is an object that contains two fields
  - A data field
  - An address field
- The data field holds the data that is stored in the linked list and the address field is a pointer that holds the memory location of the next `node` of the linked list.
- The `first node` in a linked list is called `HEAD` and the `last node` in a linked lists is called the `TAIL` of the linked list.

## Types of Linked Lists

- Linked Lists are mainly of three types
  - Singly Linked Lists
  - Double Linked Lists
  - Circular Linked Lists
- `Singly Linked Lists` consist of nodes that have one data field and one address field. The address field always points to the next node in the linked list. The `TAIL` of a singly linked list will always point to `NULL`.

  ![Singly Linked Lists](https://static.javatpoint.com/ds/images/linked-list.png)

- `Doubly Linked Lists` consist of nodes having one data field and **two** address fields. One of the two address fields (usually called `prev`) points to the previous node in the linked lists and the other address field (usually called `next`) points to the next node in the linked list. The `prev` pointer of the `HEAD` node in a doubly linked list points to `NULL` and the `next` pointer of the `TAIL` node also points to `NULL`.

  ![Doubly Linked Lists](https://static.javatpoint.com/ds/images/doubly-linked-list2.png)

- `Circular Linked Lists` are linked lists in which all the nodes are connected together in the form of a circle. The `TAIL` node of this type of linked lists points to the `HEAD` node of the linked list. In this way, none of the nodes point to `NULL`.

  ![Circular Linked Lists](https://media.geeksforgeeks.org/wp-content/uploads/CircularLinkeList.png)

## Pros and Cons of Singly Linked Lists vs Doubly Linked Lists

|                     | Pros                                 | Cons                            |
| ------------------- | ------------------------------------ | ------------------------------- |
| Singly Linked Lists | Uses less memory Easier to implement | Cannot access previous elements |
| Doubly Linked Lists | Can be traversed backwards           | Uses up twice as much memory    |

## Complexity Analysis of Linked Lists

|                        | Singly Linked Lists  | Doubly Linked Lists  |
| ---------------------- | -------------------- | -------------------- |
| Searching an element   | O(n) - Linear Time   | O(n) - Linear Time   |
| Inserting at head      | O(1) - Constant Time | O(1) - Constant Time |
| Inserting at tail      | O(1) - Constant Time | O(1) - Constant Time |
| Inserting at any index | O(n) - Linear Time   | O(n) - Linear Time   |
| Removing at head       | O(1) - Constant Time | O(1) - Constant Time |
| Removing at tail       | O(n) - Linear Time   | O(1) - Constant Time |
| Removing at any index  | O(n) - Linear Time   | O(n) - Linear Time   |
