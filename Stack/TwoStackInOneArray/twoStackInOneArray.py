class TwoStackInOneArray:
    def __init__(self, capacity):
        self.size = capacity
        self.array = [0] * self.size
        self.top1 = -1
        self.top2 = self.size

    def push1(self, data):
        if self.top1 < self.top2 - 1:
            self.top1 += 1
            self.array[self.top1] = data
            print("Element added >>", data)
        else:
            print("Stack 1 Overflow")

    def push2(self, data):
        if self.top1 < self.top2 - 1:
            self.top2 -= 1
            self.array[self.top2] = data
            print("Element added >>", data)
        else:
            print("Stack 2 Overflow")

    def pop1(self):
        if self.top1 >= 0:
            print("Stack 1 Popped element is >>", self.array[self.top1])
            self.top1 -= 1
        else:
            print("Stack 1 Underflow")

    def pop2(self):
        if self.top2 < self.size:
            print("Stack 2 Popped element is >>", self.array[self.top2])
            self.top2 += 1
        else:
            print("Stack 2 Underflow")

    def display(self):
        print("Stack 1 elements:", end=" ")
        for i in range(self.top1 + 1):
            print("[", self.array[i], end="]")
        print()

        print("Stack 2 elements:", end=" ")
        for i in range(self.size - 1, self.top2 - 1, -1):
            print("[", self.array[i], end="]")
        print()

    def peek1(self):
        if self.top1 >= 0:
            return self.array[self.top1]
        else:
            print("Stack 1 is empty")
            return -1

    def peek2(self):
        if self.top2 < self.size:
            return self.array[self.top2]
        else:
            print("Stack 2 is empty")
            return -1

    def count1(self):
        return self.top1 + 1

    def count2(self):
        return self.size - self.top2

    def is_empty1(self):
        return self.top1 == -1

    def is_empty2(self):
        return self.top2 == self.size

    def is_full(self):
        return self.top1 == self.top2 - 1

    def destroy(self):
        self.array = [0] * self.size
        self.top1 = -1
        self.top2 = self.size
        print("Array destroyed")


def main():
    ch = 0
    data = 0
    x = TwoStackInOneArray(100)

    while ch != 14:
        print("\n1.Push 1\n2.Push 2\n3.Pop 1\n4.Pop 2\n5.Display\n6.Peek 1\n7.Peek 2\n8.Count 1\n9.Count 2\n10.IsEmpty 1\n11.IsEmpty 2\n12.IsFull\n13.Destroy\n14.Exit")
        ch = int(input("Enter choice >> "))

        if ch == 1:
            data = int(input("Enter data to push >> "))
            x.push1(data)
        elif ch == 2:
            data = int(input("Enter data to push >> "))
            x.push2(data)
        elif ch == 3:
            x.pop1()
        elif ch == 4:
            x.pop2()
        elif ch == 5:
            x.display()
        elif ch == 6:
            print("Peek 1 result:", x.peek1())
        elif ch == 7:
            print("Peek 2 result:", x.peek2())
        elif ch == 8:
            print("Count 1 result:", x.count1())
        elif ch == 9:
            print("Count 2 result:", x.count2())
        elif ch == 10:
            print("IsEmpty 1 result:", x.is_empty1())
        elif ch == 11:
            print("IsEmpty 2 result:", x.is_empty2())
        elif ch == 12:
            print("IsFull result:", x.is_full())
        elif ch == 13:
            x.destroy()
        elif ch == 14:
            print("Exiting program")
        else:
            print("Invalid choice")


if __name__ == "__main__":
    main()