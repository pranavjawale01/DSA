#include <iostream>
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
    }

    void SearchNode() {
    }

    void InOrderTraversal() {
    }

    void PostOrderTraversal() {
    }

    void PreOrderTraversal() {
    }

    void DFS() {
    }

    void BFS() {
    }

    void LevelOrderTraversal() {
    }

    void FindHeight() {
    }

    void FindLevel() {
    }

    void FindNumberOfNodes() {
    }

    void FindLeafNodes() {
    }
};

int main() {
    BinaryTree x;

    int ch = 0;
    do {
        cout << "Enter your choice: ";
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
                            x.LevelOrderTraversal();
                            break;
                        case 7:
                            cout<<"Exited Successfully.....";
                            break;
                        default:
                            cout << "Enter Valid Choice" << endl;
                            break;
                    }
                } while (subCh != 7);
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
                cout<<"Exited Successfully.....";
                break;
            default:
                cout << "Enter Valid Choice" << endl;
                break;
        }

    } while (ch != 9);

    return 0;
}