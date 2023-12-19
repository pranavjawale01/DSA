class Node:
    def __init__(self, value):
        self.data = value
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def push(self, value):
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node

    def pop(self):
        if self.head is None:
            print("Stack is Empty")
            return -1
        popped_value = self.head.data
        temp = self.head
        self.head = self.head.next
        temp.next = None
        return popped_value

    def peek(self):
        if self.head is None:
            print("Stack is Empty")
            return -1
        print("Top Element is >>", self.head.data)
        return self.head.data

    def count(self):
        count = 0
        current = self.head
        while current is not None:
            count += 1
            current = current.next
        print("Number of Stack Elements is >>", count)
        return count

    def destroy(self):
        while self.head is not None:
            self.pop()
        print("Stack Destroyed")

    def display(self):
        if self.is_empty():
            return
        current = self.head
        while current is not None:
            print(current.data, end="] ")
            current = current.next
        print()

    def is_empty(self):
        if self.head is None:
            print("Stack is Empty")
        else:
            print("Stack is not Empty")
        return self.head is None

def main():
    ch = 0
    x = LinkedList()
    while ch != 9:
        print("\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ")
        ch = int(input())
        if ch == 1:
            data = int(input("Enter data >> "))
            x.push(data)
        elif ch == 2:
            x.pop()
        elif ch == 3:
            x.peek()
        elif ch == 4:
            x.is_empty()
        elif ch == 6:
            x.count()
        elif ch == 7:
            x.destroy()
        elif ch == 8:
            x.display()

if __name__ == "__main__":
    main()
