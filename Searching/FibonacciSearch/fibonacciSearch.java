import java.util.Scanner;

public class fibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        int fibMMinus2 = 0, fibMMinus1 = 1;
        int fibM = fibMMinus1 + fibMMinus2;

        while (fibM < n) {
            fibMMinus2 = fibMMinus1;
            fibMMinus1 = fibM;
            fibM = fibMMinus1 + fibMMinus2;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMMinus2, n - 1);

            if (arr[i] < target) {
                fibM = fibMMinus1;
                fibMMinus1 = fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibMMinus2;
                fibMMinus1 = fibMMinus1 - fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
            } else {
                return i;
            }
        }
        if (fibMMinus1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target variable to search >> ");
        int target = sc.nextInt();
        int result = fibonacciSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
        sc.close();
    }
}