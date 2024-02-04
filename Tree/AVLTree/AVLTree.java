package DSA.Tree.AVLTree;

import java.util.Scanner;

class Tree {
    int data;
    Tree left;
    Tree right;
    int height;
    Tree () {
        left = null;
        right = null;
    }
}

class TreeFunc {
    Tree root;
    void insert(int data) {

    }
}

public class AVLTree {
    public static void main(String[] args) {
        TreeFunc x = new TreeFunc();
        int ch = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n1.Insert \n2.Delete \n3.Balance \n4.Display \n5.Search \n6.BFS \n7.DFS \n8.Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:                    
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                default:
                    break;
            }
        } while (ch != 8);
    } 
}