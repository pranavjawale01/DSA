#include <iostream>
#include <queue>

using namespace std;

class Tree {
public:
    int data;
    Tree *left, *right;
    int height;
    Tree(int data) : data(data), left(nullptr), right(nullptr), height(1) {}
};

class TreeFunc {
public:
    Tree *root;
    int height(Tree *node) {
        if (node == nullptr) {
            return 0;
        }
        return node->height;
    }

    int getBalance(Tree *node) {
        if (node == nullptr) {
            return 0;
        }
        return height(node->left) - height(node->right);
    }

    Tree *rightRotate(Tree *y) {
        Tree *x = y->left;
        Tree *T2 = x->right;
        x->right = y;
        y->left = T2;
        y->height = max(height(y->left), height(y->right)) + 1;
        x->height = max(height(x->left), height(x->right)) + 1;
        return x;
    }

    Tree *leftRotate(Tree *x) {
        Tree *y = x->right;
        Tree *T2 = y->left;
        y->left = x;
        x->right = T2;
        x->height = max(height(x->left), height(x->right)) + 1;
        y->height = max(height(y->left), height(y->right)) + 1;
        return y;
    }

    Tree *insert(Tree *node, int data) {
        if (node == nullptr) {
            return new Tree(data);
        }
        if (data < node->data) {
            node->left = insert(node->left, data);
        } else if (data > node->data) {
            node->right = insert(node->right, data);
        } else {
            return node;
        }
        node->height = 1 + max(height(node->left), height(node->right));
        int balance = getBalance(node);
        if (balance > 1 && data < node->left->data) {
            return rightRotate(node);
        }
        if (balance < -1 && data > node->right->data) {
            return leftRotate(node);
        }
        if (balance > 1 && data > node->left->data) {
            node->left = leftRotate(node->left);
            return rightRotate(node);
        }
        if (balance < -1 && data < node->right->data) {
            node->right = rightRotate(node->right);
            return leftRotate(node);
        }
        return node;
    }

    void insert(int data) {
        root = insert(root, data);
    }

    Tree *minValueNode(Tree *node) {
        Tree *current = node;
        while (current->left != nullptr) {
            current = current->left;
        }
        return current;
    }

    Tree *deleteNode(Tree *root, int key) {
        if (root == nullptr) {
            return root;
        }
        if (key < root->data) {
            root->left = deleteNode(root->left, key);
        } else if (key > root->data) {
            root->right = deleteNode(root->right, key);
        } else {
            if ((root->left == nullptr) || (root->right == nullptr)) {
                Tree *temp = nullptr;
                if (temp == root->left) {
                    temp = root->right;
                } else {
                    temp = root->left;
                }
                if (temp == nullptr) {
                    temp = root;
                    root = nullptr;
                } else {
                    root = temp;
                }
            } else {
                Tree *temp = minValueNode(root->right);
                root->data = temp->data;
                root->right = deleteNode(root->right, temp->data);
            }
        }
        if (root == nullptr) {
            return root;
        }
        root->height = max(height(root->left), height(root->right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root->left) < 0) {
            root->left = leftRotate(root->left);
            return rightRotate(root);
        } 
        if (balance > 1 && getBalance(root->left) >= 0) {
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root->right) <= 0) {
            return leftRotate(root);
        }
        if (balance < -1 && getBalance(root->right) > 0) {
            root->right = rightRotate(root->right);
            return leftRotate(root);
        }
        return root;
    }

    void displayStructure(Tree *node, string prefix, bool isLeft) {
        if (node != nullptr) {
            cout << prefix + (isLeft ? "|-- " : "\\-- ") + to_string(node->data) << endl;
            if (node->left != nullptr || node->right != nullptr) {
                displayStructure(node->left, prefix + (isLeft ? "|   " : "    "), true);
                displayStructure(node->right, prefix + (isLeft ? "|   " : "    "), false);
            }
        }
    }

    bool search(Tree *node, int key) {
        if (node == nullptr) {
            return false;
        }
        if (key == node->data) {
            return true;
        } else if (key < node->data) {
            return search(node->left, key);
        } else {
            return search(node->right, key);
        }
    }

    void dfsPreOrder(Tree *node) {
        if (node != nullptr) {
            cout << node->data << " ";
            dfsPreOrder(node->left);
            dfsPreOrder(node->right);
        }
    }

    void bfs(Tree *root) {
        if (root == nullptr) {
            return;
        }
        queue<Tree *> que;
        que.push(root);
        while (!que.empty()) {
            Tree *node = que.front();
            que.pop();
            cout << node->data << " ";
            if (node->left != nullptr) {
                que.push(node->left);
            }
            if (node->right != nullptr) {
                que.push(node->right);
            }
        }
    }
};

int main() {
    TreeFunc x;
    int ch = 0, val = 0;
    do {
        cout << "\n1.Insert \n2.Delete \n3.Display \n4.Search \n5.BFS \n6.DFS \n7.Exit" << endl;
        cin >> ch;
        switch (ch) {
            case 1:
                cout << "Enter value to insert" << endl;
                cin >> val;
                x.insert(val);
                break;

            case 2:
                cout << "Enter value to delete >> " << endl;
                cin >> val;
                x.root = x.deleteNode(x.root, val);
                break;

            case 3:
                cout << "Tree Structure:" << endl;
                x.displayStructure(x.root, "", true);
                break;

            case 4:
                cout << "Enter value to search:" << endl;
                int searchVal;
                cin >> searchVal;
                if (x.search(x.root, searchVal)) {
                    cout << "Value found in the tree." << endl;
                } else {
                    cout << "Value not found in the tree." << endl;
                }
                break;

            case 5:
                cout << "BFS Traversal:" << endl;
                x.bfs(x.root);
                break;

            case 6:
                cout << "DFS Pre-order Traversal:" << endl;
                x.dfsPreOrder(x.root);
                break;

            case 7:
                cout << "Exiting.........." << endl;
                break;

            default:
                break;
        }
    } while (ch != 7);
    return 0;
}