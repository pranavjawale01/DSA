class ArrayStack:
    MAX_SIZE = 100

    def __init__(self):
        self.top = -1
        self.arr = [0] * self.MAX_SIZE

    def push(self):
        if self.top >= self.MAX_SIZE - 1:
            print("Stack is Full !!!")
            return
        value = int(input("Enter the value to push >> "))
        self.top += 1
        self.arr[self.top] = value

    def pop(self):
        if self.top < 0:
            print("Stack is Empty")
            return
        print("Top Element Popped:", self.arr[self.top])
        self.top -= 1

    def peek(self):
        if self.top < 0:
            print("Stack is Empty")
            return
        print("Stack Top is >>", self.arr[self.top])

    def is_empty(self):
        if self.top == -1:
            print("Stack is Empty !!!")
        else:
            print("Stack is not Empty !!!")

    def is_full(self):
        if self.top >= self.MAX_SIZE - 1:
            print("Stack is Full ")
        else:
            print("Stack is not Full !!!")

    def count(self):
        print("\nNumber of Element's in Stack is >>", self.top + 1)

    def destroy(self):
        self.top = -1
        print("Stack Destroyed")

    def display(self):
        if self.top < 0:
            print("\nStack is Empty !!")
            return
        print("\nStack:", end="")
        for i in range(self.top + 1):
            print(" [", self.arr[i], end="")
        print("]")


def main():
    ch = 0
    x = ArrayStack()

    while ch != 9:
        print("\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ", end="")
        ch = int(input())
        if ch == 1:
            x.push()
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