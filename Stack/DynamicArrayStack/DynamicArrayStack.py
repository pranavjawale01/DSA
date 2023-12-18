class DynamicArrayStack:
    def __init__(self, initial_capacity=10):
        self.capacity = initial_capacity
        self.array = [None] * self.capacity
        self.size = 0

    def is_empty(self):
        if self.size == 0:
            print("\nStack is Empty")
        else:
            print("\nStack is not Empty")
        return self.size == 0

    def is_full(self):
        if self.size == self.capacity:
            print("Stack is Full. But you can increment size")
        else:
            print("Stack is not full")
        return self.size == self.capacity

    def get_size(self):
        print("The size of stack is >>", self.size)
        return self.size

    def push(self, value):
        if self.size == self.capacity:
            self.resize(self.capacity * 2)
        self.array[self.size] = value
        self.size += 1

    def pop(self):
        if self.is_empty():
            raise ValueError("Stack is Empty")
        popped_element = self.array[self.size - 1]
        self.size -= 1
        if 0 < self.size < self.capacity // 2:
            self.resize(self.capacity // 2)
        print("Element", popped_element, "is popped")
        return popped_element

    def peek(self):
        if self.is_empty():
            raise ValueError("Stack is Empty")
        print("Peek element of stack is", self.array[self.size - 1])
        return self.array[self.size - 1]

    def display(self):
        if self.is_empty():
            return
        print(" ".join(f"[{element}" for element in self.array[:self.size]))

    def count(self):
        print("Number of elements in stack is", self.size)

    def destroy(self):
        self.array = [None] * self.capacity
        self.size = 0
        print("Stack is Destroyed")

    def resize(self, new_capacity):
        new_array = [None] * new_capacity
        for i in range(self.size):
            new_array[i] = self.array[i]
        self.array = new_array
        self.capacity = new_capacity


def main():
    x = DynamicArrayStack()
    ch = 0

    while ch != 9:
        print("\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ", end="")
        ch = int(input())

        if ch == 1:
            value = int(input("Enter Value to push >> "))
            x.push(value)
        elif ch == 2:
            x.pop()
        elif ch == 3:
            x.peek()
        elif ch == 4:
            x.is_empty()
        elif ch == 5:
            x.is_full()
        elif ch == 6:
            x.count()
        elif ch == 7:
            x.destroy()
        elif ch == 8:
            x.display()

if __name__ == "__main__":
    main()
