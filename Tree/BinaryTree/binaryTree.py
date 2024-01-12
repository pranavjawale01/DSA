from queue import Queue

class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def insertNode(self, node, value):
        if node is None:
            return Node(value)
        if value < node.data:
            node.left = self.insertNode(node.left, value)
        elif value > node.data:
            node.right = self.insertNode(node.right, value)
        return node

    def insertNodeInteractive(self):
        value = int(input("Enter Value to Insert >> "))
        self.root = self.insertNode(self.root, value)

    def minValue(self, root):
        minValue = root.data
        while root.left is not None:
            minValue = root.left.data
            root = root.left
        return minValue

    def deleteNode(self, node, value):
        if node is None:
            return node
        if value < node.data:
            node.left = self.deleteNode(node.left, value)
        elif value > node.data:
            node.right = self.deleteNode(node.right, value)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            node.data = self.minValue(node.right)
            node.right = self.deleteNode(node.right, node.data)
        return node

    def deleteNodeInteractive(self):
        value = int(input("Enter Value to delete >> "))
        self.root = self.deleteNode(self.root, value)

    def searchNode(self, node, value):
        if node is None:
            return False
        if value == node.data:
            return True
        elif value < node.data:
            return self.searchNode(node.left, value)
        else:
            return self.searchNode(node.right, value)

    def searchNodeInteractive(self):
        value = int(input("Enter Value to Search >> "))
        if self.searchNode(self.root, value):
            print("Value found in the tree")
        else:
            print("Value not found in the tree")

    def inorderTraversal(self, node):
        if node is not None:
            self.inorderTraversal(node.left)
            print(node.data, end="  ")
            self.inorderTraversal(node.right)

    def inorderTraversalInteractive(self):
        print("Inorder Traversal")
        self.inorderTraversal(self.root)
        print()

    def postorderTraversal(self, node):
        if node is not None:
            self.postorderTraversal(node.left)
            self.postorderTraversal(node.right)
            print(node.data, end="  ")

    def postorderTraversalInteractive(self):
        print("Postorder Traversal")
        self.postorderTraversal(self.root)
        print()

    def preorderTraversal(self, node):
        if node is not None:
            print(node.data, end="  ")
            self.preorderTraversal(node.left)
            self.preorderTraversal(node.right)

    def preorderTraversalInteractive(self):
        print("Preorder Traversal")
        self.preorderTraversal(self.root)
        print()

    def DFS(self, node):
        if node is not None:
            print(node.data, end="  ")
            self.DFS(node.left)
            self.DFS(node.right)

    def DFSInteractive(self):
        print("Depth First Search >> ")
        self.DFS(self.root)
        print()

    def BFS(self):
        if self.root is None:
            return
        print("BFS >> ")
        q = Queue()
        q.put(self.root)
        while not q.empty():
            current = q.get()
            print(current.data, end="  ")
            if current.left is not None:
                q.put(current.left)
            if current.right is not None:
                q.put(current.right)
        print()

    def findHeight(self, node):
        if node is None:
            return -1
        leftHeight = self.findHeight(node.left)
        rightHeight = self.findHeight(node.right)
        return max(leftHeight, rightHeight) + 1

    def findHeightInteractive(self):
        print("Height of the tree:", self.findHeight(self.root))

    def findLevel(self, node, value, level):
        if node is None:
            return -1
        if value == node.data:
            return level
        elif value < node.data:
            return self.findLevel(node.left, value, level + 1)
        else:
            return self.findLevel(node.right, value, level + 1)

    def findLevelInteractive(self):
        value = int(input("Enter value to find on level >> "))
        level = self.findLevel(self.root, value, 0)
        if level == -1:
            print("Value not found in the tree")
        else:
            print("Level of Node with value is >> Value :", value, " Level :", level)

    def findNumberOfNodes(self, node):
        if node is None:
            return 0
        return 1 + self.findNumberOfNodes(node.left) + self.findNumberOfNodes(node.right)

    def findNumberOfNodesInteractive(self):
        print("Number of nodes in the tree:", self.findNumberOfNodes(self.root))

    def findLeafNodes(self, node):
        if node is not None:
            if node.left is None and node.right is None:
                print(node.data, end="  ")
            self.findLeafNodes(node.left)
            self.findLeafNodes(node.right)

    def findLeafNodesInteractive(self):
        print("Leaf nodes in the tree:")
        self.findLeafNodes(self.root)
        print()

    def countNodesAtLevel(self, node, targetLevel, currentLevel):
        if node is None:
            return 0
        if currentLevel == targetLevel:
            return 1
        return (self.countNodesAtLevel(node.left, targetLevel, currentLevel + 1) +
                self.countNodesAtLevel(node.right, targetLevel, currentLevel + 1))

    def countNodesAtLevelInteractive(self):
        targetLevel = int(input("Enter the target level to count nodes >> "))
        count = self.countNodesAtLevel(self.root, targetLevel, 0)
        print("Number of nodes at level", targetLevel, ":", count)

    def isFullBinaryTree(self, node):
        if node is None:
            return True
        if (node.left is None and node.right is not None) or \
           (node.left is not None and node.right is None):
            return False
        return self.isFullBinaryTree(node.left) and self.isFullBinaryTree(node.right)

    def checkFullBinaryTree(self):
        if self.isFullBinaryTree(self.root):
            print("The tree is a full binary tree.")
        else:
            print("The tree is not a full binary tree.")

    def isBalanced(self, node):
        if node is None:
            return True
        leftHeight = self.findHeight(node.left)
        rightHeight = self.findHeight(node.right)
        balanceFactor = abs(leftHeight - rightHeight)
        return (balanceFactor <= 1) and self.isBalanced(node.left) and self.isBalanced(node.right)

    def checkBalance(self):
        if self.isBalanced(self.root):
            print("The tree is balanced.")
        else:
            print("The tree is not balanced.")

    def mirrorTree(self, node):
        if node is None:
            return None
        temp = node.left
        node.left = self.mirrorTree(node.right)
        node.right = self.mirrorTree(temp)
        return node

    def mirrorTreeInteractive(self):
        self.printTree()
        print("Print Mirror Binary Tree:")
        self.root = self.mirrorTree(self.root)
        self.printTree(self.root, 0, "", True)

    def printTree(self, node, level, indent, isLeft):
        if node is not None:
            if node.right is not None:
                self.printTree(node.right, level + 1, indent, False)

            print(" " * (level * 3) + ("└── " if isLeft else "┌── ") + str(node.data))

            if node.left is not None:
                self.printTree(node.left, level + 1, indent, True)

    def printTreeInteractive(self):
        print("Print Binary Tree:")
        self.printTree(self.root, 0, "", True)

if __name__ == "__main__":
    x = BinaryTree()

    ch = 0
    while ch != 13:
        print("Menu:\n"
              "1. Insert Node\n"
              "2. Delete Node\n"
              "3. Search Node\n"
              "4. Traversal\n"
              "5. Find Height\n"
              "6. Find Level\n"
              "7. Find Number of Nodes\n"
              "8. Find Leaf Nodes\n"
              "9. Check Full Binary Tree\n"
              "10. Check Balance\n"
              "11. Mirror Tree\n"
              "12. Print Tree\n"
              "13. Exit")
        ch = int(input("Enter your choice: "))

        if ch == 1:
            x.insertNodeInteractive()
        elif ch == 2:
            x.deleteNodeInteractive()
        elif ch == 3:
            x.searchNodeInteractive()
        elif ch == 4:
            subCh = 0
            while subCh != 6:
                print("Enter your sub-choice for traversal: \n"
                      "1. Inorder\n"
                      "2. PostOrder\n"
                      "3. Preorder\n"
                      "4. DFS\n"
                      "5. BFS\n"
                      "6. Exit")
                subCh = int(input(">> "))
                if subCh == 1:
                    x.inorderTraversalInteractive()
                elif subCh == 2:
                    x.postorderTraversalInteractive()
                elif subCh == 3:
                    x.preorderTraversalInteractive()
                elif subCh == 4:
                    x.DFSInteractive()
                elif subCh == 5:
                    x.BFS()
                elif subCh == 6:
                    print("Exited Successfully.....")
                else:
                    print("Enter Valid Choice")
        elif ch == 5:
            x.findHeightInteractive()
        elif ch == 6:
            x.findLevelInteractive()
        elif ch == 7:
            x.findNumberOfNodesInteractive()
        elif ch == 8:
            x.findLeafNodesInteractive()
        elif ch == 9:
            x.checkFullBinaryTree()
        elif ch == 10:
            x.checkBalance()
        elif ch == 11:
            x.mirrorTreeInteractive()
            print("Binary Tree Mirrored.")
        elif ch == 12:
            x.printTreeInteractive()
        elif ch == 13:
            print("Exited Successfully.....")
        else:
            print("Enter Valid Choice")