class DEPQ:
    INITIAL_CAPACITY = 10

    def __init__(self):
        self.data = [None] * self.INITIAL_CAPACITY
        self.front = 0
        self.back = 0
        self.capacity = self.INITIAL_CAPACITY

    class Node:
        def __init__(self, value, priority):
            self.value = value
            self.priority = priority

    def resize(self):
        new_capacity = self.capacity * 2
        new_data = [None] * new_capacity
        new_data[:self.front] = self.data[:self.front]
        new_data[new_capacity - self.back:] = self.data[self.capacity - self.back:]
        self.data = new_data
        self.capacity = new_capacity

    def print_queue(self):
        print("\nFront Heap : ")
        for i in range(self.front):
            print(f" ({self.data[i].value}, {self.data[i].priority}) ", end="")
        print("\nBack Heap : ")
        for i in range(self.capacity - self.back, self.capacity):
            print(f" ({self.data[i].value}, {self.data[i].priority}) ", end="")
        print()

    def push_front(self, value, priority):
        if self.front == self.capacity // 2:
            self.resize()
        self.data[self.front] = self.Node(value, priority)
        self.front += 1
        self.data[:self.front] = sorted(self.data[:self.front], key=lambda x: x.priority, reverse=True)
        self.print_queue()

    def push_back(self, value, priority):
        if self.back == self.capacity // 2:
            self.resize()
        self.data[self.capacity - self.back - 1] = self.Node(value, priority)
        self.back += 1
        self.data[self.capacity - self.back:] = sorted(self.data[self.capacity - self.back:], key=lambda x: x.priority)
        self.print_queue()

    def pop_front(self):
        if self.front == 0:
            return None
        self.data[:self.front] = sorted(self.data[:self.front], key=lambda x: x.priority, reverse=True)
        value = self.data[self.front - 1].value
        self.front -= 1
        self.print_queue()
        return value

    def pop_back(self):
        if self.back == 0:
            return None 
        self.data[self.capacity - self.back:] = sorted(self.data[self.capacity - self.back:], key=lambda x: x.priority)
        value = self.data[self.capacity - self.back].value
        self.back -= 1
        self.print_queue()
        return value


def main():
    depq = DEPQ()

    while True:
        print("\n1. Push Front\n2. Push Back\n3. Pop Front\n4. Pop Back\n5. Print\n6. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            data, priority = map(int, input("Enter data and priority: ").split())
            depq.push_front(data, priority)
        elif choice == 2:
            data, priority = map(int, input("Enter data and priority: ").split())
            depq.push_back(data, priority)
        elif choice == 3:
            print("Popped from front:", depq.pop_front())
        elif choice == 4:
            print("Popped from back:", depq.pop_back())
        elif choice == 5:
            depq.print_queue()
        elif choice == 6:
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")


if __name__ == "__main__":
    main()