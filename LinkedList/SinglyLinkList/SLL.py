class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class SLL:
    def __init__(self):
        self.head = None
    
    ch=0
    def Insert(self,new_data):
        print("\n1.Insert at Front \n2.Insert at End \n3.Insert at Middle\n>>> ")
        ch1 = int(input())
        if ch1 == 1:
            new_node = Node(new_data)
            new_node.next = self.head
            self.head = new_node
            
        elif ch1 == 2:         
            new_node = Node(new_data)
            if self.head is None:
                self.head = new_node
                return
            last = self.head
            while(last.next):
                last = last.next
            last.next = new_node
            
        elif ch1 == 3:
            prev_node = self.head
            if prev_node is None:
                print("The given previous node must inLinkedList.")
                return
            print("Enter the data of the node after which you want to insert: ")
            targetData = int(input())
            while prev_node!=None and prev_node.data != targetData:
                prev_node = prev_node.next
            if prev_node is None:
                print("The given previous node must inLinkedList.")
                return
            else:
                new_node = Node(new_data)
                new_node.next = prev_node.next
                prev_node.next = new_node   
        
    def Search(self,element):
        current = self.head
        count=0
        while current!= None:
            if current.data == element:
                print("Element ",current.data," is found at index ",count)
                return
            current = current.next
            count += 1
        print("Element Not present in LinkList")
        return
        
    def Delete(self):
        pass
        
    def Display(self):
        temp = self.head
        while(temp):
            print(temp.data, end=" -> ")
            temp = temp.next
        print("NULL")
        
    def Count(self):
        count = 0
        temp = self.head
        while(temp):
            temp = temp.next
            count += 1
        print("The Number of Node's in List is >> ",count)
        
    def Reverse(self):
        pass
        
if __name__ == "__main__":
    x = SLL()
    ch = 0
    while(ch != 7):
        print("\n1.Insert\n2.Search\n3.Delete\n4.Display\n5.Count\n6.Reverse\n7.Exit\n>>> ")
        ch = int(input())
        if ch == 1:
            print("\nEnter Data to insert")
            data = int(input())
            x.Insert(data)
        elif ch == 2:
            print("\nEnter Element to search")
            data = int(input())
            x.Search(data)
        elif ch == 3:
            x.Delete()
        elif ch == 4:
            x.Display()
        elif ch == 5:
            x.Count()
        elif ch == 6:
            x.Reverse()
        elif ch == 7:
            print("Exiting")
        else:
            print("Invalid choice")