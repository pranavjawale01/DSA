class CircularQueue:
    def __init__(self, size=100):
        self.rear = -1
        self.front = -1
        self.arr = [None] * size
    
    def enqueue(self, data: int):
        if self.isFull():
            print("Queue is Full")
        else:
            self.rear = (self.rear + 1) % len(self.arr)
            self.arr[self.rear] = data
            print("Data Added")
        
    def dequeue(self):
        if self.isEmpty():
            print("Queue is empty")
        else:
            self.front = (self.front + 1) % len(self.arr)
        
    def display(self):
        if self.isEmpty():
            print("Queue is empty")
        else:
            print("<-")
            for i in range(self.front, self.rear + 1):
                print(" [", self.arr[i], "] ", end="")
            print("->")
    
    def isFull(self) -> bool:
        return (self.rear + 1) % len(self.arr) == self.front
        
    def isEmpty(self) -> bool:
        return self.rear == self.front == -1
    
    def size(self) -> int:
        if self.isEmpty():
            return 0
        elif self.front <= self.rear:
            return self.rear - self.front + 1
        else:
            return len(self.arr) - self.front + self.rear + 1
        
    def clear(self):
        self.rear = -1
        self.front = -1
        print("Queue cleared")
    
if __name__ == "__main__":
    x = CircularQueue()
    
    while True:
        ch = int(input("\n1.Enqueue \n2.Dequeue \n3.Display \n4.Size \n5.Clear \n6.Exit\n"))
        if ch == 1:
            data = int(input("Enter the data >> "))
            x.enqueue(data)
        elif ch == 2:
            x.dequeue()
        elif ch == 3:
            x.display()
        elif ch == 4:
            print("Size: ", x.size())
        elif ch == 5:
            x.clear()
        elif ch == 6:
            break