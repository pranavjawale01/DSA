package DSA.Queue.PriorityQueue;

import java.util.Arrays;

class PriorityQueue {
    private int capacity = 100;
    private int[] arr;
    private int size;

    private void resize() {
        capacity *= 2;
        int[] newArr = Arrays.copyOf(arr, capacity);
        arr = newArr;
    }

    private void swap(int[] array, int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (arr[index] < arr[parent]) {
                swap(arr, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;
        if (leftChild < size && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < size && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(arr, index, smallest);
            heapifyDown(smallest);
        }
    }

    public PriorityQueue() {
        size = 0;
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int value) {
        if (size >= capacity) {
            resize();
        }
        arr[size] = value;
        heapifyUp(size);
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Priority Queue is Empty");
            return -1;
        }
        int top = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);
        return top;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("\nPriority Queue is Empty");
            return;
        }
        System.out.print("\nPriority Queue : ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printOrdered() {
        if (isEmpty()) {
            System.out.println("Priority Queue is Empty");
            return;
        }
        int[] sortedArr = Arrays.copyOf(arr, size);
        Arrays.sort(sortedArr);
        System.out.print("Priority Queue in Priority Order : ");
        for (int i = 0; i < size; i++) {
            System.out.print(sortedArr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue x = new PriorityQueue();
        int ch = 0, data = 0;
        do {
            System.out.print("\n1. Push\n2. Pop\n3. Print \n4. Print Ordered\n5. Exit\n > > ");
            ch = Integer.parseInt(System.console().readLine());
            switch (ch) {
                case 1:
                    System.out.print("Enter Data >> ");
                    data = Integer.parseInt(System.console().readLine());
                    x.push(data);
                    break;

                case 2:
                    data = x.pop();
                    System.out.println("\nPopped Element is >> " + data);
                    break;

                case 3:
                    x.print();
                    break;

                case 4:
                    x.printOrdered();
                    break;

                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
        } while (ch != 5);
    }
}