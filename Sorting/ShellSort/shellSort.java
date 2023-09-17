package DSA.Sorting.ShellSort;

import java.util.Arrays;

class shellSort
{
    static void printArr(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }
    static void shellsort(int arr[])
    {
        int n= arr.length;
        for(int interval = n/2; interval > 0 ; interval /= 2)
        {
            for(int i= interval;i<n;i++)
            {
                int temp = arr[i];
                int j;
                for(j=i ; j >= interval && arr[j-interval]>temp ; j -= interval)
                {
                    arr[j] = arr[j-interval];
                }
                arr[j] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
    public static void main(String[] args)
    {
        int data[] = {34,53,244,5455324,534454,4523,323,45,32,42};
        shellsort(data);
        System.out.println("Sorted Array");
        printArr(data);
        System.out.println("Print USing Inbuilt Func");
        System.out.println(Arrays.toString(data));
    }
}