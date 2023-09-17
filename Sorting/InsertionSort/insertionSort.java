package DSA.Sorting.InsertionSort;

import java.util.*;

class insertionSort
{
    public static void sort(int arr[], int n)
    {
        for(int i=1;i<n;i++)
        {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && key < arr[j])
            {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
    }
    public static void print(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }
    public static void main(String[] args)
    {
        int[] data = {3,2,43,21,54,-342,0,53,-43,-2};
        sort(data,data.length);
        print(data,data.length);
    }
}