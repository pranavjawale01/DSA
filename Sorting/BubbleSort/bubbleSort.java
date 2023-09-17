package DSA.Sorting.BubbleSort;

import java.util.*;

class bubbleSort 
{
    static void sort(int arr[]) 
    {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) 
        {
            int flag=0;
            for (int j = 0; j < size - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag =1;
                }
            }
            if(flag == 0)
            {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] data = {-43, 43, 42, 23, 4, 2, -43, 0};
        sort(data);
        System.out.println(Arrays.toString(data));  // Use Arrays.toString() to print the array
    }
}
