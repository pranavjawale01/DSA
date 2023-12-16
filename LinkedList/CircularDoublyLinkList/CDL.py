class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class CDL:
    def __init__(self):
        self.head = None

    def insert(self):
        data = int(input("Enter the value: "))
        new_node = Node(data)
        
        if not self.head:
            self.head = new_node
            self.head.next = self.head
            self.head.prev = self.head
        else:
            choice = int(input("1. Insert at Start\n2. Middle\n3. End\nEnter your choice: "))
            
            if choice == 1:
                new_node.next = self.head
                new_node.prev = self.head.prev
                self.head.prev.next = new_node
                self.head.prev = new_node
                self.head = new_node
            elif choice == 2:
                next_node_data = int(input("After which Node you want to insert data: "))
                temp = self.head
                node_found = False
                
                while temp.next != self.head:
                    if temp.data == next_node_data:
                        node_found = True
                        break
                    temp = temp.next
                
                if node_found:
                    new_node.next = temp.next
                    new_node.prev = temp
                    temp.next.prev = new_node
                    temp.next = new_node
                    print("Node inserted in the middle successfully!")
                else:
                    print("Node with the specified value not found. Insertion failed.")
            elif choice == 3:
                new_node.next = self.head
                new_node.prev = self.head.prev
                self.head.prev.next = new_node
                self.head.prev = new_node

    def search(self):
        value = int(input("Enter the value to search: "))
        if not self.head:
            print("List is empty.")
            return
        current = self.head
        while True:
            if current.data == value:
                print("Node with value", value, "found.")
                return
            current = current.next
            if current == self.head:
                print("Node with value", value, "not found.")
                return

    def delete(self):
        value = int(input("Enter the value to delete: "))
        if not self.head:
            print("List is empty.")
            return
        current = self.head
        while True:
            if current.data == value:
                if current == self.head:
                    if self.head.next == self.head:
                        self.head = None
                    else:
                        self.head.prev.next = self.head.next
                        self.head.next.prev = self.head.prev
                        self.head = self.head.next
                else:
                    current.prev.next = current.next
                    current.next.prev = current.prev
                print("Node with value", value, "deleted successfully.")
                return
            current = current.next
            if current == self.head:
                print("Node with value", value, "not found.")
                return

    def display(self):
        if not self.head:
            print("List is empty.")
            return
        current = self.head
        print("- - - <->", end=" ")
        while True:
            print(current.data, "<->", end=" ")
            current = current.next
            if current == self.head:
                break
        print("- - - ")

    def count(self):
        if not self.head:
            print("List is empty.")
            return
        count = 0
        current = self.head
        while True:
            count += 1
            current = current.next
            if current == self.head:
                break
        print("Number of nodes in the list:", count)

    def reverse(self):
        if not self.head:
            print("List is empty. Cannot reverse.")
            return
        current = self.head
        temp = None
        while True:
            temp = current.prev
            current.prev = current.next
            current.next = temp
            current = current.prev
            if current == self.head:
                break
        self.head = temp.prev
        print("List is reversed successfully.")

    def rotate(self):
        if not self.head:
            print("List is empty. Cannot rotate.")
            return
        position = int(input("Enter the number of positions to rotate: "))
        for _ in range(position):
            self.head = self.head.next
        print("List rotated by", position, "positions.")


if __name__ == "__main__":
    x = CDL()
    ch = 0
    while ch != 8:
        print("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Rotate\n8.Exit\n>>> ", end="")
        ch = int(input())
        if ch == 1:
            x.insert()
        elif ch == 2:
            x.search()
        elif ch == 3:
            x.delete()
        elif ch == 4:
            x.display()
        elif ch == 5:
            x.count()
        elif ch == 6:
            x.reverse()
        elif ch == 7:
            x.rotate() 