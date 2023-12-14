class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class CLL:
    def __init__(self):
        self.head = None

    def insert(self):
        print("\n1.Insert at Start \n2.Middle \n3.End >> ")
        ch = int(input())
        print("Enter the value >> ")
        data = int(input())
        new_node = Node(data)

        if not self.head:
            self.head = new_node
            new_node.next = self.head
            return

        if ch == 1:
            new_node.next = self.head
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            temp.next = new_node
            self.head = new_node
        elif ch == 2:
            temp = self.head
            print("After which Node you want to insert data >> ")
            next_node = int(input())

            node_found = False
            while temp.next != self.head:
                if temp.data == next_node:
                    node_found = True
                    break
                temp = temp.next

            if node_found:
                new_node.next = temp.next
                temp.next = new_node
                print("Node inserted in the middle successfully!")
            else:
                print("Node with the specified value not found. Insertion failed.")
        elif ch == 3:
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            temp.next = new_node
            new_node.next = self.head

    def search(self):
        node_data = int(input("Enter Node to search >> "))
        found = False
        temp = self.head
        index = 0
        while temp.next != self.head:
            if temp.data == node_data:
                found = True
                break
            temp = temp.next
            index += 1

        if found:
            print("Node is present at index", index)
        else:
            print("Node not present in CLL")

    def delete_node(self):
        if not self.head:
            print("CLL is Empty")
            return

        value = int(input("Enter Node value to delete >> "))
        temp = self.head
        prev = None

        while temp.data != value:
            prev = temp
            temp = temp.next
            if temp == self.head:
                print("Node not present in CLL")
                return

        if temp.next == self.head:
            self.head = None
        else:
            prev.next = temp.next
            if temp == self.head:
                self.head = temp.next

        del temp
        print("Node deleted successfully")

    def display(self):
        if not self.head:
            print("List is empty")
            return
        temp = self.head
        print("HEAD -> ", end="")
        while True:
            print(temp.data, "-> ", end="")
            temp = temp.next
            if temp == self.head:
                break
        print("HEAD")

    def count(self):
        if not self.head:
            print("Total 0 nodes are present")
            return
        temp = self.head
        count = 0
        while temp.next != self.head:
            temp = temp.next
            count += 1
        print("Total", count, "nodes are present")

    def reverse(self):
        if not self.head or not self.head.next:
            print("List is empty or has only one node. No reversal needed.")
            return

        print("List Before reversed successfully")
        self.display()
        print()

        prev = None
        current = self.head
        next_node = None

        while current != self.head:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node

        self.head = prev

        print("List reversed successfully")
        self.display()

    def rotate(self):
        if not self.head or not self.head.next:
            print("\nRotation not possible")
            return

        k = int(input("Enter the number of positions to rotate >> "))
        if k == 0:
            print("No rotation performed ")
            return

        temp = self.head
        count = 1

        while temp.next != self.head:
            temp = temp.next
            count += 1

        temp.next = self.head

        for i in range(k % count):
            temp = temp.next

        self.head = temp.next
        temp.next = self.head

        print("List rotated successfully")

  
if __name__ == "__main__":
    x = CLL()
    ch = 0
    while ch != 8:
        print("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Rotate\n8.Exit\n>>> ", end="")
        ch = int(input())
        if ch == 1:
            x.insert()
        elif ch == 2:
            x.search()
        elif ch == 3:
            x.delete_node()
        elif ch == 4:
            x.display()
        elif ch == 5:
            x.count()
        elif ch == 6:
            x.reverse()
        elif ch == 7:
            x.rotate()