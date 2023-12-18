package DSA.Stack.DynamicArrayStack;

import java.util.Scanner;

class DynamicArrayStack<T> {
    private Object[] array;
    private int capacity;
    private int size;

    public DynamicArrayStack(int initialCapacity) {
        capacity = initialCapacity;
        array = new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("\nStack is Empty");
        } else {
            System.out.println("\nStack is not Empty");
        }
        return size == 0;
    }

    public boolean isFull() {
        if (size == capacity) {
            System.out.println("Stack is Full. But you can increment size");
        } else {
            System.out.println("Stack is not full");
        }
        return size == capacity;
    }

    public int getSize() {
        System.out.println("The size of stack is >> " + size);
        return size;
    }

    public void push(T value) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        array[size++] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        T poppedElement = (T) array[--size];
        if (size > 0 && size < capacity / 2) {
            resize(capacity / 2);
        }
        System.out.println("Element " + poppedElement + " is popped");
        return poppedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        System.out.println("Peek element of stack is " + array[size - 1]);
        return (T) array[size - 1];
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(" [" + array[i]);
        }
        System.out.println();
    }

    public void count() {
        System.out.println("Number of elements in stack is " + size);
    }

    public void destroy() {
        array = new Object[capacity];
        size = 0;
        System.out.println("Stack is Destroyed");
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        DynamicArrayStack<Integer> x = new DynamicArrayStack<>(10);
        Scanner scanner = new Scanner(System.in);
        int ch;
        int value;

        do {
            System.out.println("\n\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Count\n7.Destroy\n8.Display\n9.Exit \n>> ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Value to push >> ");
                    value = scanner.nextInt();
                    x.push(value);
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

        scanner.close();
    }
}
