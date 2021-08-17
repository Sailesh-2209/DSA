export class SinglyLinkedList {
    constructor(data=null) {
        this.head = new Node(data);
    }

    insert = function(index, data) {
        if (data === null) {
            throw new Error("Null value not allowed");
        }
        if (index === 0) {
            if (this.head.data === null) {
                this.head = new Node(data);
            } else {
                let dummyHead = new Node(data);
                dummyHead.next = head;
                head = dummyHead;
            }
        } else if (index === this.size()) {
            let curr = this.head;
            while (curr.next !== null) {
                curr = curr.next;
            }
            curr.next = new Node(data);
        } else if (index < 0 || index > this.size()) {
            throw new Error("Index out of bounds");
        } else {
            let curr = this.head;
            let p = 0;
            while (curr.next != null) {
                if (index === p + 1) {
                    let newNode = new Node(data);
                    newNode.next = curr.next;
                    curr.next = newNode;
                }
                p++;
                curr = curr.next;
            }
        }
    }

    append = function(data) {
        if (data === null) {
            throw new Error("Null value not allowed");
        }
        if (this.head.data === null) {
            this.head = new Node(data);
        } else {
            let curr = this.head;
            while (curr.next != null) {
                curr = curr.next
            }
            curr.next = new Node(data);
        }
    }

    remove = function(index) {
        if (this.size() === 0) {
            throw new Error("Cannot remove from empty list");
        }
        if (index < 0 || index >= this.size()) {
            throw new Error("Index out of bounds");
        }
        if (index == 0) {
            return this.removeHead();
        }
        if (index == this.size() - 1) {
            return this.removeTail();
        }
        let curr = this.head;
        let p = 0;
        while (curr.next != null) {
            p++;
            if (index == p) {
                let data = curr.next.data;
                curr.next = curr.next.next;
                return data;
            }
            curr = curr.next;
        }
    }

    removeHead = function() {
        if (this.head.data == null) {
            throw new Error("Cannot remove head of empty list");
        }
        let data = this.head.data;
        this.head = this.head.next;
        return data;
    }

    removeTail = function() {
        if (this.head.data == null) {
            throw new Error("Cannot remove tail of empty list");
        }
        let curr = this.head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        let data = curr.next.data;
        curr.next = null;
        return data;
    }

    get = function(index) {
        if (this.head.data === null) {
            return null;
        } 
        let curr = this.head;
        let p = 0;
        while (curr != null) {
            if (index === p) {
                return curr.data;
            }
            curr = curr.next;
            p++;
        }
    }

    size = function() {
        if (this.head.data == null) return 0;
        let curr = this.head;
        let N = 0;
        while (curr != null) {
            curr = curr.next;
            N++;
        }
        return N;
    }

    isEmpty = function() {
        return this.size() === 0;
    }

    toString = function() {
        if (this.head == null) {
            return "[]";
        } else {
            let arr = []
            let curr = this.head;
            while (curr != null) {
                arr.push(curr.data);
                curr = curr.next;
            }
            return `[${arr.toString()}]`;
        }
    }
}

class Node {
    constructor(data, next) {
        this.data = data;
        this.next = next;
    }
}