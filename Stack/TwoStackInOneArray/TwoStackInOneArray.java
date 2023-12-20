package DSA.Stack.TwoStackInOneArray;

import java.util.Scanner;

class TwoStackInOneArrayx {
    private int[] array;
    private int size;
    private int top1;
    private int top2;

    public TwoStackInOneArrayx(int capacity) {
        size = capacity;
        array = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int data) {
        if (top1 < top2 - 1) {
            array[++top1] = data;
            System.out.println("Element added >> " + data);
        } else {
            System.out.println("Stack 1 Overflow");
        }
    }

    public void push2(int data) {
        if (top1 < top2 - 1) {
            array[--top2] = data;
            System.out.println("Element added >> " + data);
        } else {
            System.out.println("Stack 2 Overflow");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            System.out.println("Stack 1 Popped element is >> " + array[top1]);
            return array[top1--];
        } else {
            System.out.println("Stack 1 Underflow");
            return -1;
        }
    }

    public int pop2() {
        if (top2 < size) {
            System.out.println("Stack 2 Popped element is >> " + array[top2]);
            return array[top2++];
        } else {
            System.out.println("Stack 2 Underflow");
            return -1;
        }
    }

    public void display() {
        System.out.print("Stack 1 elements: ");
        for (int i = 0; i <= top1; ++i) {
            System.out.print(" [" + array[i] + "");
        }
        System.out.println();

        System.out.print("Stack 2 elements: ");
        for (int i = size - 1; i >= top2; --i) {
            System.out.print(" [" + array[i] + "");
        }
        System.out.println();
    }

    public int peek1() {
        if (top1 >= 0) {
            return array[top1];
        } else {
            System.out.println("Stack 1 is empty");
            return -1;
        }
    }

    public int peek2() {
        if (top2 < size) {
            return array[top2];
        } else {
            System.out.println("Stack 2 is empty");
            return -1;
        }
    }

    public int count1() {
        return top1 + 1;
    }

    public int count2() {
        return size - top2;
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == size;
    }

    public boolean isFull() {
        return top1 == top2 - 1;
    }

    public void destroy() {
        array = new int[size];
        top1 = -1;
        top2 = size;
        System.out.println("Array destroyed");
    }
}

public class TwoStackInOneArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch = 0, data = 0;
        TwoStackInOneArrayx x = new TwoStackInOneArrayx(100);

        do {
            System.out.println("\n1.Push 1\n2.Push 2\n3.Pop 1\n4.Pop 2\n5.Display\n6.Peek 1\n7.Peek 2\n8.Count 1\n9.Count 2\n10.IsEmpty 1\n11.IsEmpty 2\n12.IsFull\n13.Destroy\n14.Exit");
            System.out.print("Enter choice >> ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter data to push >> ");
                    data = scanner.nextInt();
                    x.push1(data);
                    break;
                case 2:
                    System.out.print("Enter data to push >> ");
                    data = scanner.nextInt();
                    x.push2(data);
                    break;
                case 3:
                    x.pop1();
                    break;
                case 4:
                    x.pop2();
                    break;
                case 5:
                    x.display();
                    break;
                case 6:
                    System.out.println("Peek 1 result: " + x.peek1());
                    break;
                case 7:
                    System.out.println("Peek 2 result: " + x.peek2());
                    break;
                case 8:
                    System.out.println("Count 1 result: " + x.count1());
                    break;
                case 9:
                    System.out.println("Count 2 result: " + x.count2());
                    break;
                case 10:
                    System.out.println("IsEmpty 1 result: " + x.isEmpty1());
                    break;
                case 11:
                    System.out.println("IsEmpty 2 result: " + x.isEmpty2());
                    break;
                case 12:
                    System.out.println("IsFull result: " + x.isFull());
                    break;
                case 13:
                    x.destroy();
                    break;
                case 14:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (ch != 14);

        scanner.close();
    }
}
