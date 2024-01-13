class BST:
    def __init__(self, size):
        self.tree : int = [None] * size
        self.size = size
    
    def resize(self):
        new_size = self.size * 2
        new_tree = [None] * new_size
        for i in range(self.size):
            new_tree[i] = self.tree
        self.size = new_size
        self.tree = new_tree
        
    def insert(self, value, index = 0):
        if len(self.tree) <= index:
            self.resize()
        if self.tree[index] == None:
            self.tree[index] = value
            return
        if value < self.tree[index]:
            left_child = 2 * index + 1
            self.insert(value, left_child)
        elif value > self.tree[index]:
            right_child = 2 * index + 2
            self.insert(value, right_child)
    
    def delete(self, value, index = 0):
        if index >= len(self.tree) or self.tree[index] is None:
            print(f"{value} not found in the tree.")
            return
        
        if value < self.tree[index]:
            left_child = 2 * index + 1
            self.delete(value, left_child)
        elif value > self.tree[index]:
            right_child = 2 * index + 2
            self.delete(value, right_child)
        else:
            if self.tree[2 * index + 1] is None and self.tree[2 * index + 2] is None:
                self.tree[index] = None
            elif self.tree[2 * index + 1] is None:
                self.tree[index] = self.tree[2 * index + 2]
                self.delete(value, 2 * index + 2)
            elif self.tree[2 * index + 2] is None:
                self.tree[index] = self.tree[2 * index + 1]
                self.delete(value, 2 * index + 1)
            else:
                min_val = self.find_min(2 * index + 2)
                self.tree[index] = min_val
                self.delete(min_val, 2 * index + 2)
    
    def find_min(self, index):
        while self.tree[2 * index + 1] is not None:
            index = 2 * index + 1
        return self.tree[index]
    
    def display(self):
        print(self.tree)
        
bst = BST(10)
bst.insert(5)
bst.insert(3)
bst.insert(7)
bst.insert(8)
bst.insert(6)
bst.insert(10)
bst.insert(12)

bst.display()

bst.delete(7)
bst.display()