class LinearQueue:
    MAX_SIZE = 100

    def __init__(self):
        self.arr = [0] * self.MAX_SIZE
        self.front = -1
        self.rear = -1

    def is_empty(self):
        return self.front == -1 and self.rear == -1

    def is_full(self):
        return (self.rear + 1) % self.MAX_SIZE == self.front

    def enqueue(self, element):
        if self.is_full():
            print("\nQueue is Full")
            return
        if self.is_empty():
            self.front = self.rear = 0
        else:
            self.rear = (self.rear + 1) % self.MAX_SIZE
        self.arr[self.rear] = element
        print(f"Enqueued : {element}")

    def dequeue(self):
        if self.is_empty():
            print("Queue is Empty.")
            return
        print(f"Dequeued : {self.arr[self.front]}")
        if self.front == self.rear:
            self.front = self.rear = -1
        else:
            self.front = (self.front + 1) % self.MAX_SIZE

    def display(self):
        if self.is_empty():
            print("\nQueue is Empty")
            return
        i = self.front
        while i != self.rear:
            print(f" [{self.arr[i]}] ", end="")
            i = (i + 1) % self.MAX_SIZE
        print(f" [{self.arr[self.rear]}] ")


def menu():
    print("1. Enqueue")
    print("2. Dequeue")
    print("3. Display")
    print("4. Exit")
    choice = int(input("Enter your choice: "))
    return choice


if __name__ == "__main__":
    x = LinearQueue()
    ch = 0
    while True:
        ch = menu()
        if ch == 1:
            element = int(input("Enter element to enqueue: "))
            x.enqueue(element)
        elif ch == 2:
            x.dequeue()
        elif ch == 3:
            x.display()
        elif ch == 4:
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Try again.")