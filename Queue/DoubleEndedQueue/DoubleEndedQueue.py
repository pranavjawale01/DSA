class Node:
    def __init__(self, value):
        self.data = value
        self.next = None
        self.prev = None

class Deque:
    def __init__(self):
        self.front = None
        self.rear = None

    def is_empty(self) -> bool:
        return self.front is None

    def add_to_front(self, element):
        new_node = Node(element)
        if self.is_empty():
            self.front = self.rear = new_node
        else:
            new_node.next = self.front
            self.front.prev = new_node
            self.front = new_node

    def add_to_rear(self, element):
        new_node = Node(element)
        if self.is_empty():
            self.front = self.rear = new_node
        else:
            new_node.prev = self.rear
            self.rear.next = new_node
            self.rear = new_node

    def remove_from_front(self) -> int:
        if self.is_empty():
            raise RuntimeError("Deque is Empty")
        value = self.front.data
        temp = self.front
        if self.front == self.rear:
            self.front = self.rear = None
        else:
            self.front = self.front.next
            self.front.prev = None
        del temp
        return value

    def remove_from_rear(self) -> int:
        if self.is_empty():
            raise RuntimeError("Deque is Empty")
        value = self.rear.data
        temp = self.rear
        if self.front == self.rear:
            self.front = self.rear = None
        else:
            self.rear = self.rear.prev
            self.rear.next = None
        del temp
        return value

    def size(self) -> int:
        count = 0
        current = self.front
        while current is not None:
            current = current.next
            count += 1
        return count

    def print_deque(self):
        current = self.front
        print("NULL", end="")
        while current is not None:
            print(" <->", current.data, end="")
            current = current.next
        print(" <-> NULL")

if __name__ == "__main__":
    deque = Deque()

    while True:
        print("\n1. Insert at Front\n2. Insert at End\n3. Delete from Front\n4. Delete from End\n5. Print\n6. Size\n7. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            data = int(input("Enter data: "))
            deque.add_to_front(data)
        elif choice == 2:
            data = int(input("Enter data: "))
            deque.add_to_rear(data)
        elif choice == 3:
            try:
                print("Removed from front:", deque.remove_from_front())
            except RuntimeError as e:
                print("Error:", e)
        elif choice == 4:
            try:
                print("Removed from end:", deque.remove_from_rear())
            except RuntimeError as e:
                print("Error:", e)
        elif choice == 5:
            print("Deque elements:", end=" ")
            deque.print_deque()
        elif choice == 6:
            print("Deque size:", deque.size())
        elif choice == 7:
            print("Exiting the program.")
            break
        else:
            print("Invalid choice. Please enter a valid option.")