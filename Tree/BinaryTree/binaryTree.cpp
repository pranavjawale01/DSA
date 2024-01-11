#include <iostream>
#include <queue>
using namespace std;

class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int value) : data(value), left(nullptr), right(nullptr) {}
};

class BinaryTree {
private:
    Node* root;

public:
    BinaryTree() : root(nullptr) {}

    Node* InsertNode(Node* node, int value) {
        if (node == nullptr) {
            return new Node(value);
        }
        if (value < node->data) {
            node->left = InsertNode(node->left, value);
        } else if (value > node->data) {
            node->right = InsertNode(node->right, value);
        }
        return node;
    }

    Node* FindMinNode(Node* node) {
        while (node->left != nullptr) {
            node = node->left;
        }
        return node;
    }

    Node* DeleteNode(Node* node, int value) {
        if (node == nullptr) {
            return node;
        }
        if (value < node->data) {
            node->left = DeleteNode(node->left, value);
        } else if (value > node->data) {
            node->right = DeleteNode(node->right, value);
        } else {
            if (node->left == nullptr) {
                Node* temp = node->right;
                delete node;
                return temp;
            } else if (node->right == nullptr) {
                Node* temp = node->left;
                delete node;
                return temp;
            }
            Node* temp = FindMinNode(node->right);
            node->data = temp->data;
            node->right = DeleteNode(node->right, temp->data);
        }
        return node;
    }

    void InsertNode() {
        int value ;
        cout<<"Enter Value to Insert >> ";
        cin>>value;
        root = InsertNode(root, value);
    }

    void DeleteNode() {
        int value;
        cout<<"Enter value to delete >> ";
        cin>>value;
        root = DeleteNode(root, value);
    }

    bool SearchNode(Node* node, int value) {
        if (node == nullptr) {
            return false;
        }
        if (value == node->data) {
            return true;
        } else if (value < node->data) {
            return SearchNode(node->left, value);
        } else {
            return SearchNode(node->right, value);
        }
    }

    void SearchNode() {
        int value;
        cout<<"Enter value to search >> ";
        cin>>value;
        if (SearchNode(root, value)) {
            cout<<"Value found in the tree"<<endl;
        } else {
            cout<<"Value NOT found in the tree"<<endl;
        }
    }

    void InOrderTraversal(Node* node) {
        if (node != nullptr) {
            InOrderTraversal(node->left);
            cout<<node->data<<"  ";
            InOrderTraversal(node->right);
        }
    }

    void InOrderTraversal() {
        cout << "InOrder Traversal: ";
        InOrderTraversal(root);
        cout << endl;
    }

    void PostOrderTraversal(Node* node) {
        if (node != nullptr) {
            PostOrderTraversal(node->left);
            PostOrderTraversal(node->right);
            cout<<node->data<<"  ";
        }
    }

    void PostOrderTraversal() {
        cout << "PostOrder Traversal: ";
        PostOrderTraversal(root);
        cout << endl;
    }

    void PreOrderTraversal(Node* node) {
        if (node != nullptr) {
            cout << node->data << " ";
            PreOrderTraversal(node->left);
            PreOrderTraversal(node->right);
        }
    }

    void PreOrderTraversal() {
        cout << "PreOrder Traversal: ";
        PreOrderTraversal(root);
        cout << endl;
    }

    void DFS(Node* node) {
        if (node != nullptr) {
            cout << node->data << " ";
            DFS(node->left);
            DFS(node->right);
        }
    }

    void DFS() {
        cout << "Depth-First Search (DFS): ";
        DFS(root);
        cout << endl;
    }

    //LevelOrderTraversal
    void BFS() {
        if (root == nullptr) {
            return;
        }
        cout<<"BFS >> "<<endl;
        queue<Node*> q;
        q.push(root);
        while (!q.empty()) {
            Node* current = q.front();
            cout<<current->data<<" ";
            q.pop();
            if (current->left != nullptr) {
                q.push(current->left);
            }
            if (current->right != nullptr) {
                q.push(current->right);
            }
        }
        cout<<endl;
    }

    int FindHeight(Node* node) {
        if (node == nullptr) {
            return -1;
        }
        int leftHeight = FindHeight(node->left);
        int rightHeight = FindHeight(node->right);

        return max(leftHeight, rightHeight) + 1;
    }

    void FindHeight() {
        cout << "Height of the tree: " << FindHeight(root) << endl;
    }

    int FindLevel(Node* node, int value, int level) {
        if (node == nullptr) {
            return -1;
        }
        if (value == node->data) {
            return level;
        } else if (value < node->data) {
            return FindLevel(node->left, value, level+1);
        } else {
            return FindLevel(node->right, value, level+1);
        }
    }

    void FindLevel() {
        int value;
        cout << "Enter Value to Find Level >> ";
        cin >> value;
        int level = FindLevel(root, value, 0);
        if (level == -1) {
            cout << "Value not found in the tree." << endl;
        } else {
            cout << "Level of the node with value " << value << ": " << level << endl;
        }
    }

    int FindNumberOfNodes(Node* node) {
        if (node == nullptr) {
            return 0;
        }
        return 1 + FindNumberOfNodes(node->left) + FindNumberOfNodes(node->right);

    }

    void FindNumberOfNodes() {
        cout << "Number of nodes in the tree: " << FindNumberOfNodes(root) << endl;
    }

    void FindLeafNodes(Node* node) {
        if (node != nullptr) {
            if (node->left == nullptr && node->right == nullptr) {
                cout<<node->data<<" ";
            }
            FindLeafNodes(node->left);
            FindLeafNodes(node->right);
        }
    }

    void FindLeafNodes() {
        cout << "Leaf nodes in the tree: ";
        FindLeafNodes(root);
        cout << endl;
    }

    int CountNodesAtLevel(Node* node, int targetLevel, int currentLevel) {
        if (node == nullptr) {
            return 0;
        }
        if (currentLevel == targetLevel) {
            return 1;
        }
        return CountNodesAtLevel(node->left, targetLevel, currentLevel + 1) +
            CountNodesAtLevel(node->right, targetLevel, currentLevel + 1);
    }

    void CountNodesAtLevel() {
        int targetLevel;
        cout << "Enter the target level to count nodes >> ";
        cin >> targetLevel;
        int count = CountNodesAtLevel(root, targetLevel, 0);
        cout << "Number of nodes at level " << targetLevel << ": " << count << endl;
    }

    bool IsFullBinaryTree(Node* node) {
        if (node == nullptr) {
            return true;
        }
        if ((node->left == nullptr && node->right != nullptr) || 
            (node->left != nullptr && node->right == nullptr)) {
            return false;
        }
        return IsFullBinaryTree(node->left) && IsFullBinaryTree(node->right);
    }

    void CheckFullBinaryTree() {
        if (IsFullBinaryTree(root)) {
            cout << "The tree is a full binary tree." << endl;
        } else {
            cout << "The tree is not a full binary tree." << endl;
        }
    }

    bool IsBalanced(Node* node) {
        if (node == nullptr) {
            return true;
        }
        int leftHeight = FindHeight(node->left);
        int rightHeight = FindHeight(node->right);
        int balanceFactor = abs(leftHeight - rightHeight);
        return (balanceFactor <= 1) && IsBalanced(node->left) && IsBalanced(node->right);
    }

    void CheckBalance() {
        if (IsBalanced(root)) {
            cout << "The tree is balanced." << endl;
        } else {
            cout << "The tree is not balanced." << endl;
        }
    }

    Node* MirrorTree(Node* node) {
        if (node == nullptr) {
            return nullptr;
        }
        Node* temp = node->left;
        node->left = MirrorTree(node->right);
        node->right = MirrorTree(temp);
        return node;
    }

    void MirrorTree() {
        PrintTree();
        cout << "Print Mirror Binary Tree:" << endl;
        root = MirrorTree(root);
        PrintTree(root,0);
    }

    void PrintTree(Node* node, int level) {
        if (node != nullptr) {
            PrintTree(node->right, level + 1);

            for (int i = 0; i < level; ++i) {
                cout << "   ";
            }

            cout << "|--" << node->data << endl;

            PrintTree(node->left, level + 1);
        }
    }

    void PrintTree() {
        cout << "Print Binary Tree:" << endl;
        PrintTree(root, 0);
        cout << endl;
    }
};

int main() {
    BinaryTree x;

    int ch = 0;
    do {
         cout << "Menu:\n"
             << "1. Insert Node\n"
             << "2. Delete Node\n"
             << "3. Search Node\n"
             << "4. Traversal\n"
             << "5. Find Height\n"
             << "6. Find Level\n"
             << "7. Find Number of Nodes\n"
             << "8. Find Leaf Nodes\n"
             << "9. Check Full Binary Tree\n"
             << "10. Check Balance\n"
             << "11. Mirror Tree\n"
             << "12. Print Tree\n"
             << "13. Exit\n"
             << "Enter your choice: ";
        cin >> ch;

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
                    cout << "Enter your sub-choice for traversal: ";
                    cout<<"\n1.Inorder\n2.PostOrder\n3.Preorder\n4.DFS\n5.BFS\n6.Exit\n >> ";
                    cin >> subCh;
                    switch (subCh) {
                        case 1:
                            x.InOrderTraversal();
                            break;
                        case 2:
                            x.PostOrderTraversal();
                            break;
                        case 3:
                            x.PreOrderTraversal();
                            break;
                        case 4:
                            x.DFS();
                            break;
                        case 5:
                            x.BFS();
                            break;
                        case 6:
                            cout<<"Exited Successfully.....";
                            break;
                        default:
                            cout << "Enter Valid Choice" << endl;
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
                cout << "Binary Tree Mirrored." << endl;
                break;
            case 12:
                x.PrintTree();
                break;
            case 13:
                cout<<"Exited Successfully.....";
                break;
            default:
                cout << "Enter Valid Choice" << endl;
                break;
        }

    } while (ch != 13);

    return 0;
}