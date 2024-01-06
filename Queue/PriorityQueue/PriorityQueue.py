class PriorityQueue:
    def __init__(self):
        self.capacity = 100
        self.arr = [0] * self.capacity
        self.size = 0
    
    def resize(self):
        self.capacity *= 2
        self.arr = self.arr[:self.capacity]
    
    def swap(self, a, b):
        self.arr[a] , self.arr[b] = self.arr[b] , self.arr[a]
        
    def heapifyUp(self, index):
        while index > 0:
            parent = (index - 1) // 2
            if self.arr[index] < self.arr[parent]:
                self.swap(index, parent)
                index = parent
            else:
                break
            
    def heapifyDown(self , index):
        leftChild = 2 * index + 1
        rightChild = 2 * index + 2
        smallest = index
        
        if leftChild < self.size and self.arr[leftChild] < self.arr[smallest]:
            smallest = leftChild
        if rightChild < self.size and self.arr[rightChild] < self.arr[smallest]:
            smallest = rightChild
        if smallest != index:
            self.swap(index, smallest)
            self.heapifyDown(smallest)
            
    def isEmpty(self) -> bool:
        return self.size == 0
    
    def push(self, value):
        if self.size >= self.capacity:
            self.resize()
        self.arr[self.size] = value
        self.heapifyUp(self.size)
        self.size += 1
        
    def pop(self):
        if self.isEmpty():
            print('Queue is Empty')
            return
        top = self.arr[0]
        self.arr[0] = self.arr[self.size - 1]
        self.size -= 1
        self.heapifyDown(0)
        return top
    
    def printQueue(self):
        if self.isEmpty():
            print('Queue is Empty')
            return
        print('\nPriority Queue : ',end='')
        for i in range(self.size):
            print(self.arr[i], end=' ')
        print()
        
    def printOrdered(self):
        if self.isEmpty():
            print('Priority Queue is Empty')
            return
        sortedArr = sorted(self.arr[:self.size])
        print('Priority Queue in Priority Order ')
        for num in sortedArr:
            print(num, end = ' ')
            
if __name__ == '__main__':
    x = PriorityQueue()
    ch , data = 0 , 0
    while ch != 5:
        print('\n1.Push \n2.Pop \n3.Print \n4.Print Ordered \n5.Exit')
        ch = int(input("> > > "))
        if ch == 1:
            data = int(input("Enter Data >> "))
            x.push(data)
        elif ch == 2:
            data = x.pop()
            print(f"\nPopped Element is >> {data}")
        elif ch == 3:
            x.printQueue()
        elif ch == 4:
            x.printOrdered()
        elif ch != 5:
            print("Enter Valid Choice")