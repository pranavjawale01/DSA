package DSA.Stack.ArrayStack;

import java.util.Scanner;

class ArrayStackX {
    private static final int MAX_SIZE = 100;
    private int top;
    private int[] arr = new int[MAX_SIZE];

    public ArrayStackX() {
        top = -1;
    }

    public void push() {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack is Full !!!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value to push >> ");
        int value = scanner.nextInt();
        arr[++top] = value;
    }

    public void pop() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Top Element Popped: " + arr[top]);
        top--;
    }

    public void peek() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Stack Top is >> " + arr[top]);
    }

    public void isEmpty() {
        if (top == -1) {
            System.out.println("Stack is Empty !!!");
        } else {
            System.out.println("Stack is not Empty !!!");
        }
    }

    public void isFull() {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack is Full ");
        } else {
            System.out.println("Stack is not Full !!!");
        }
    }

    public void count() {
        System.out.println("\nNumber of Element's in Stack is >> " + (top + 1));
    }

    public void destroy() {
        top = -1;
        System.out.println("Stack Destroyed");
    }

    public void display() {
        if (top < 0) {
            System.out.println("\nStack is Empty !!");
            return;
        }
        System.out.print("\nStack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(" [" + arr[i]);
        }
        System.out.println();
    }
}

public class ArrayStack {
    public static void main(String[] args) {
        int ch = 0;
        ArrayStackX x = new ArrayStackX();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    x.push();
                    break;
                case 2:
                    x.pop();
                    break;
                case 3:
                    x.peek();
                    break;
                case 4:
                    x.isEmpty();
                    break;
                case 5:
                    x.isFull();
                    break;
                case 6:
                    x.count();
                    break;
                case 7:
                    x.destroy();
                    break;
                case 8:
                    x.display();
                    break;
            }
        } while (ch != 9);
    }
}
