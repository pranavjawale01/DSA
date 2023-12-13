class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class DLL:
    def __init__(self):
        self.head = None

    def Insert(self):
        new_data = int(input("\nEnter Data >> "))
        print("\n1. Insert at start\n2. Middle\n3. End")
        ch1 = int(input(">> "))
        new_node = Node(new_data)

        if ch1 == 1:
            new_node.next = self.head
            if self.head is not None:
                self.head.prev = new_node
            self.head = new_node
        elif ch1 == 2:
            print("\nAfter which Node you want to insert data >> ")
            ch1 = int(input())
            temp = self.head
            while temp is not None and temp.data != ch1:
                temp = temp.next
            if temp is None:
                print("\nNode not present")
                return
            new_node.next = temp.next
            new_node.prev = temp
            if temp.next is not None:
                temp.next.prev = new_node
            temp.next = new_node
        elif ch1 == 3:
            new_node.next = None
            if self.head is None:
                new_node.prev = None
                self.head = new_node
            else:
                temp = self.head
                while temp.next is not None:
                    temp = temp.next
                temp.next = new_node
                new_node.prev = temp

    def Search(self):
        if self.head is None:
            print("\nThe DLL is empty. Cannot perform search.")
            return

        target_data = int(input("\nEnter the data to search: "))
        temp = self.head
        while temp is not None:
            if temp.data == target_data:
                print("\nData found in the DLL.")
                return
            temp = temp.next

        print("\nData not found in the DLL.")

    def Delete(self):
        if self.head is None:
            print("\nThe DLL is empty. Cannot perform delete.")
            return

        target_data = int(input("\nEnter the data to delete: "))
        temp = self.head
        while temp is not None and temp.data != target_data:
            temp = temp.next

        if temp is None:
            print("\nData not found in the DLL. Cannot delete.")
            return

        if temp.prev is not None:
            temp.prev.next = temp.next
        else:
            self.head = temp.next

        if temp.next is not None:
            temp.next.prev = temp.prev

        print("\nData deleted from the DLL.")

    def Update(self):
        if self.head is None:
            print("\nThe DLL is empty. Cannot perform update.")
            return

        target_data = int(input("\nEnter the data to update: "))
        temp = self.head
        while temp is not None and temp.data != target_data:
            temp = temp.next

        if temp is None:
            print("\nData not found in the DLL. Cannot update.")
            return

        new_data = int(input("\nEnter the new data value: "))
        temp.data = new_data
        print("\nData updated in the DLL.")

    def Display(self):
        if self.head is None:
            print("\nThe DLL is empty")
            return

        temp = self.head
        print("NULL <-> ", end="")
        while temp is not None:
            print(f"{temp.data} <-> ", end="")
            temp = temp.next
        print("NULL")

    def Count(self):
        count = 0
        temp = self.head
        while temp is not None:
            count += 1
            temp = temp.next

        print(f"\nNumber of nodes in the DLL: {count}")

    def Reverse(self):
        current = self.head
        temp = None

        while current is not None:
            temp = current.prev
            current.prev = current.next
            current.next = temp

            current = current.prev

        if temp is not None:
            self.head = temp.prev

        print("\nDLL reversed.")


if __name__ == "__main__":
    x = DLL()
    ch = 0
    while ch != 8:
        print("\n1. Insert\n2. Search\n3. Delete\n4. Update\n5. Display\n6. Count\n7. Reverse\n8. Exit")
        ch = int(input(">> "))
        if ch == 1:
            x.Insert()
        elif ch == 2:
            x.Search()
        elif ch == 3:
            x.Delete()
        elif ch == 4:
            x.Update()
        elif ch == 5:
            x.Display()
        elif ch == 6:
            x.Count()
        elif ch == 7:
            x.Reverse()