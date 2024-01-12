package DSA.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
    Node(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    private Node root;

    Scanner sc = new Scanner(System.in);

    public BinaryTree() {
        root = null;
    }

    Node InsertNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = InsertNode(node.left, value);
        } else if (value > node.data) {
            node.right = InsertNode(node.right, value);
        }
        return node;
    }

    void InsertNode() {
        int value;
        System.out.println("Enter Value to Insert >> ");
        value = sc.nextInt();
        root = InsertNode(root, value);
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    Node DeleteNode(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.data) {
            node.left = DeleteNode(node.left, value);
        } else if (value > node.data) {
            node.right = DeleteNode(node.right, value);
        } else {
            // Case 1: Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2: Node with two children, get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right);

            // Delete the inorder successor
            node.right = DeleteNode(node.right, node.data);
        }
        return node;
    }

    void DeleteNode() {
        int value;
        System.out.println("Enter Value to delete >> ");
        value = sc.nextInt();
        root = DeleteNode(root, value);
    }

    boolean SearchNode(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.data) {
            return true;
        } else if (value < node.data) {
            return SearchNode(node.left, value);
        } else {
            return SearchNode(node.right, value);
        }
    }

    void SearchNode() {
        int value;
        System.out.println("Enter Value to Search >> ");
        value = sc.nextInt();
        if (SearchNode(root, value)) {
            System.out.println("Value found in the tree");
        } else {
            System.out.println("Value not found in the tree");
        }
    }

    void InorderTraversal(Node node) {
        if (node != null)  {
            InorderTraversal(node.left);
            System.out.print(node.data + "  ");
            InorderTraversal(node.right);
        }
    }

    void InorderTraversal() {
        System.out.println("Inorder Traversal");
        InorderTraversal(root);
        System.out.println();
    }

    void PostorderTraversal(Node node) {
        if (node != null) {
            PostorderTraversal(node.left);
            PostorderTraversal(node.right);
            System.out.println(node.data + "  ");
        }
    }

    void PostorderTraversal() {
        System.out.println("Postorder Traversal");
        PostorderTraversal(root);
        System.out.println();
    }

    void PreorderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.data + "  ");
            PreorderTraversal(node.left);
            PreorderTraversal(node.right);
        } 
    }

    void PreorderTraversal() {
        System.out.println("Preorder Traversal");
        PreorderTraversal(root);
        System.out.println();
    }

    void DFS(Node node) {
        if (node != null) {
            System.out.println(node.data + "  ");
            DFS(node.left);
            DFS(node.right);
        }
    }

    void DFS() {
        System.out.println("Depth first Search >> ");
        DFS(root);
        System.out.println();
    }

    void BFS() {
        if (root == null) {
            return;
        }
        System.out.println("BFS >> ");
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node current = q.peek();
            System.out.println(current.data + "  ");
            q.poll();
            if (current.left != null) {
                q.offer(current.left);
            } 
            if (current.right != null) {
                q.offer(current.right);
            }
        }
        System.out.println();
    }

    int FindHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = FindHeight(node.left);
        int rightHeight = FindHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    void FindHeight() {
        System.out.println("Height of the tree: " + FindHeight(root));
    }

    int FindLevel(Node node, int value, int level) {
        if (node == null) {
            return -1;
        }
        if (value == node.data) {
            return level;
        } else if (value < node.data) {
            return FindLevel(node.left, value, level + 1);
        } else {
            return FindLevel(node.right, value, level + 1);
        }
    }

    void FindLevel() {
        int value;
        System.out.println("Enter value to find on level >> ");
        value = sc.nextInt();
        int level = FindLevel(root, value, 0);
        if (level == -1) {
            System.out.println("Value not found in the tree");
        } else {
            System.out.println("Level of Node with value is >> Value :" + value +" Level : "+ level);
        }
    }

    int FindNumberOfNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + FindNumberOfNodes(node.left) + FindNumberOfNodes(node.right);
    }

    void FindNumberOfNodes() {
        System.out.println("Number of nodes in the tree: " + FindNumberOfNodes(root));
    }

    void FindLeafNodes(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.println(node.data + "  ");
            }
            FindLeafNodes(node.left);
            FindLeafNodes(node.right);
        }
    }

    void FindLeafNodes() {
        System.out.println("Leaf nodes in the tree: ");
        FindLeafNodes(root);
        System.out.println();
    }

    int CountNodesAtLevel(Node node, int targetLevel, int currentLevel) {
        if (node == null) {
            return 0;
        }
        if (currentLevel == targetLevel) {
            return 1;
        }
        return CountNodesAtLevel(node.left, targetLevel, currentLevel + 1) +
            CountNodesAtLevel(node.right, targetLevel, currentLevel + 1);
    }

    void CountNodesAtLevel() {
        int targetLevel;
        System.out.println("Enter the target level to count nodes >> ");
        targetLevel = sc.nextInt();
        int count = CountNodesAtLevel(root, targetLevel, 0);
        System.out.println("Number of nodes at level " + targetLevel + ": " + count);
    }

    boolean IsFullBinaryTree(Node node) {
        if (node == null) {
            return true;
        }
        if ((node.left == null && node.right != null) || 
            (node.left != null && node.right == null)) {
            return false;
        }
        return IsFullBinaryTree(node.left) && IsFullBinaryTree(node.right);
    }

    void CheckFullBinaryTree() {
        if (IsFullBinaryTree(root)) {
            System.out.println("The tree is a full binary tree.");
        } else {
            System.out.println("The tree is not a full binary tree.");
        }
    }

    boolean IsBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = FindHeight(node.left);
        int rightHeight = FindHeight(node.right);
        int balanceFactor = Math.abs(leftHeight - rightHeight);
        return (balanceFactor <= 1) && IsBalanced(node.left) && IsBalanced(node.right);
    }

    void CheckBalance() {
        if (IsBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }

    Node MirrorTree(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.left;
        node.left = MirrorTree(node.right);
        node.right = MirrorTree(temp);
        return node;
    }

    void MirrorTree() {
        PrintTree();
        System.out.println("Print Mirror Binary Tree:");
        root = MirrorTree(root);
        PrintTree(root, 0, "", true);
    }

    private void PrintTree(Node node, int level, String indent, boolean isLeft) {
        if (node != null) {
            if (node.right != null) {
                PrintTree(node.right, level + 1, indent, false);
            }

            System.out.println(" ".repeat(level * 3) + (isLeft ? "└── " : "┌── ") + node.data);

            if (node.left != null) {
                PrintTree(node.left, level + 1, indent, true);
            }
        }
    }

    public void PrintTree() {
        System.out.println("Print Binary Tree:");
        PrintTree(root, 0, "", true);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree x = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        int ch = 0;
        do {
            System.out.print("Menu:\n"
                    + "1. Insert Node\n"
                    + "2. Delete Node\n"
                    + "3. Search Node\n"
                    + "4. Traversal\n"
                    + "5. Find Height\n"
                    + "6. Find Level\n"
                    + "7. Find Number of Nodes\n"
                    + "8. Find Leaf Nodes\n"
                    + "9. Check Full Binary Tree\n"
                    + "10. Check Balance\n"
                    + "11. Mirror Tree\n"
                    + "12. Print Tree\n"
                    + "13. Exit\n"
                    + "Enter your choice: ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    x.InsertNode();
                    break;
                case 2:
                    x.DeleteNode();
                    break;
                case 3:
                    x.SearchNode();
                    break;
                case 4:
                    int subCh;
                    do {
                        System.out.print("Enter your sub-choice for traversal: \n"
                                + "1. Inorder\n"
                                + "2. PostOrder\n"
                                + "3. Preorder\n"
                                + "4. DFS\n"
                                + "5. BFS\n"
                                + "6. Exit\n >> ");
                        subCh = scanner.nextInt();
                        switch (subCh) {
                            case 1:
                                x.InorderTraversal();
                                break;
                            case 2:
                                x.PostorderTraversal();
                                break;
                            case 3:
                                x.PreorderTraversal();
                                break;
                            case 4:
                                x.DFS();
                                break;
                            case 5:
                                x.BFS();
                                break;
                            case 6:
                                System.out.println("Exited Successfully.....");
                                break;
                            default:
                                System.out.println("Enter Valid Choice");
                                break;
                        }
                    } while (subCh != 6);
                    break;
                case 5:
                    x.FindHeight();
                    break;
                case 6:
                    x.FindLevel();
                    break;
                case 7:
                    x.FindNumberOfNodes();
                    break;
                case 8:
                    x.FindLeafNodes();
                    break;
                case 9:
                    x.CheckFullBinaryTree();
                    break;
                case 10:
                    x.CheckBalance();
                    break;
                case 11:
                    x.MirrorTree();
                    System.out.println("Binary Tree Mirrored.");
                    break;
                case 12:
                    x.PrintTree();
                    break;
                case 13:
                    System.out.println("Exited Successfully.....");
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }

        } while (ch != 13);

        scanner.close();
    }
}