class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:
    def __init__(self):
        self.root = None

    def height(self, node):
        if node is None:
            return 0
        return node.height

    def get_balance(self, node):
        if node is None:
            return 0
        return self.height(node.left) - self.height(node.right)

    def right_rotate(self, y):
        x = y.left
        T2 = x.right
        x.right = y
        y.left = T2
        y.height = max(self.height(y.left), self.height(y.right)) + 1
        x.height = max(self.height(x.left), self.height(x.right)) + 1
        return x

    def left_rotate(self, x):
        y = x.right
        T2 = y.left
        y.left = x
        x.right = T2
        x.height = max(self.height(x.left), self.height(x.right)) + 1
        y.height = max(self.height(y.left), self.height(y.right)) + 1
        return y

    def insert(self, node, data):
        if node is None:
            return TreeNode(data)
        if data < node.data:
            node.left = self.insert(node.left, data)
        elif data > node.data:
            node.right = self.insert(node.right, data)
        else:
            return node
        node.height = 1 + max(self.height(node.left), self.height(node.right))
        balance = self.get_balance(node)
        if balance > 1 and data < node.left.data:
            return self.right_rotate(node)
        if balance < -1 and data > node.right.data:
            return self.left_rotate(node)
        if balance > 1 and data > node.left.data:
            node.left = self.left_rotate(node.left)
            return self.right_rotate(node)
        if balance < -1 and data < node.right.data:
            node.right = self.right_rotate(node.right)
            return self.left_rotate(node)
        return node

    def insert_value(self, data):
        self.root = self.insert(self.root, data)

    def min_value_node(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

    def delete_node(self, root, key):
        if root is None:
            return root
        if key < root.data:
            root.left = self.delete_node(root.left, key)
        elif key > root.data:
            root.right = self.delete_node(root.right, key)
        else:
            if root.left is None or root.right is None:
                temp = None
                if temp == root.left:
                    temp = root.right
                else:
                    temp = root.left
                if temp is None:
                    temp = root
                    root = None
                else:
                    root = temp
            else:
                temp = self.min_value_node(root.right)
                root.data = temp.data
                root.right = self.delete_node(root.right, temp.data)
        if root is None:
            return root
        root.height = max(self.height(root.left), self.height(root.right)) + 1
        balance = self.get_balance(root)
        if balance > 1 and self.get_balance(root.left) < 0:
            root.left = self.left_rotate(root.left)
            return self.right_rotate(root)
        if balance > 1 and self.get_balance(root.left) >= 0:
            return self.right_rotate(root)
        if balance < -1 and self.get_balance(root.right) <= 0:
            return self.left_rotate(root)
        if balance < -1 and self.get_balance(root.right) > 0:
            root.right = self.right_rotate(root.right)
            return self.left_rotate(root)
        return root

    def display_structure(self, node, prefix="", is_left=True):
        if node is not None:
            print(prefix + ("|-- " if is_left else "\\-- ") + str(node.data))
            if node.left is not None or node.right is not None:
                self.display_structure(node.left, prefix + ("|   " if is_left else "    "), True)
                self.display_structure(node.right, prefix + ("|   " if is_left else "    "), False)

    def search(self, node, key):
        if node is None:
            return False
        if key == node.data:
            return True
        elif key < node.data:
            return self.search(node.left, key)
        else:
            return self.search(node.right, key)

    def dfs_pre_order(self, node):
        if node is not None:
            print(node.data, end=" ")
            self.dfs_pre_order(node.left)
            self.dfs_pre_order(node.right)

    def bfs(self, root):
        if root is None:
            return
        que = []
        que.append(root)
        while len(que) > 0:
            node = que.pop(0)
            print(node.data, end=" ")
            if node.left is not None:
                que.append(node.left)
            if node.right is not None:
                que.append(node.right)


if __name__ == "__main__":
    x = AVLTree()
    ch = 0
    while ch != 7:
        print("\n1.Insert \n2.Delete \n3.Display \n4.Search \n5.BFS \n6.DFS \n7.Exit")
        ch = int(input())
        if ch == 1:
            print("Enter value to insert")
            val = int(input())
            x.insert_value(val)
        elif ch == 2:
            print("Enter value to delete >> ")
            val = int(input())
            x.root = x.delete_node(x.root, val)
        elif ch == 3:
            print("Tree Structure:")
            x.display_structure(x.root)
        elif ch == 4:
            print("Enter value to search:")
            search_val = int(input())
            if x.search(x.root, search_val):
                print("Value found in the tree.")
            else:
                print("Value not found in the tree.")
        elif ch == 5:
            print("BFS Traversal:")
            x.bfs(x.root)
        elif ch == 6:
            print("DFS Pre-order Traversal:")
            x.dfs_pre_order(x.root)
        elif ch == 7:
            print("Exiting..........")