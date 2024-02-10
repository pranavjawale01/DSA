package DSA.Tree.AVLTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tree {
    int data;
    Tree left;
    Tree right;
    int height;
    Tree (int data) {
        this.data = data;
        left = null;
        right = null;
        height = 1;
    }
}

class TreeFunc {
    Tree root;
    int height (Tree node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    int getBalance(Tree node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    Tree rightRotate(Tree y) {
        Tree x = y.left;
        Tree T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    Tree leftRotate(Tree x) {
        Tree y = x.right;
        Tree T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    Tree insert(Tree node, int data) {
        if (node == null) {
            return new Tree(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        // left left case
        int balance = getBalance(node);
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // right right casew
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // left right case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right left case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    void insert(int data) {
        root = insert(root, data);
    }

    Tree minValueNode(Tree node) {
        Tree current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    Tree deleteNode(Tree root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Tree temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Tree temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        if (root == null) {
            return root;
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        //left left case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        } 
        //left right case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //right right case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        //right left case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    void displayStructure(Tree node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.data);
            if (node.left != null || node.right != null) {
                displayStructure(node.left, prefix + (isLeft ? "|   " : "    "), true);
                displayStructure(node.right, prefix + (isLeft ? "|   " : "    "), false);
            }
        }
    }
    boolean search(Tree node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.data) {
            return true;
        } else if (key < node.data) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
    void dfsPreOrder(Tree node) {
        if (node != null) {
            System.out.println(node.data + " ");
            dfsPreOrder(node.left);
            dfsPreOrder(node.right);
        }
    }
    void bfs (Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            Tree node = que.poll();
            System.out.println(node.data + " ");
            if (node.left != null) {
                que.add(node.left);
            }
            if (node.right != null) {
                que.add(node.right);
            }
        }
    }
}

public class AVLTree {
    public static void main(String[] args) {
        TreeFunc x = new TreeFunc();
        int ch = 0, val = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n1.Insert \n2.Delete \n3.Display \n4.Search \n5.BFS \n6.DFS \n7.Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:      
                    System.out.println("Enter value to insert");
                    val = sc.nextInt();
                    x.insert(val);              
                    break;

                case 2:
                    System.out.println("Enter value to delete >> ");
                    val = sc.nextInt();
                    x.root = x.deleteNode(x.root, val);
                    break;

                case 3:
                    System.out.println("Tree Structure:");
                    x.displayStructure(x.root, "", true);
                    break;

                case 4:
                    System.out.println("Enter value to search:");
                    int searchVal = sc.nextInt();
                    if (x.search(x.root, searchVal)) {
                        System.out.println("Value found in the tree.");
                    } else {
                        System.out.println("Value not found in the tree.");
                    }
                    break;

                case 5:
                    System.out.println("BFS Traversal:");
                    x.bfs(x.root);
                    break;

                case 6:
                    System.out.println("DFS Pre-order Traversal:");
                    x.dfsPreOrder(x.root);
                    break;

                case 7:
                    System.out.println("Exiting..........");
                    break;

                default:
                    break;
            }
        } while (ch != 7);
        sc.close();
    } 
}