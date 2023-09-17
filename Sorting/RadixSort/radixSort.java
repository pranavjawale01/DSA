package DSA.Sorting.RadixSort;

import java.util.Arrays;

class radixSort
{
    static void countingSort(int arr[], int size, int place)
    {
        int[] output = new int[size+1];
        int max = arr[0];

        for(int i=1;i<size;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }

        int[] count = new int[max+1];

        for(int i=0;i<max;i++)
        {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++)
        {
            count[(arr[i] / place) % 10]++;
        }

        for(int i=1;i<max;i++)
        {
            count[i] += count[i-1];
        }

        for(int i=size-1;i>=0;i--)
        {
            output[count[(arr[i]/place)%10]-1] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        for(int i=0;i<size;i++)
        {
            arr[i]=output[i];
        }
    }

    static int getMax(int arr[],int n)
    {
        int max = arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }

    static void radixsort(int arr[],int size)
    {
        int max = getMax(arr,size);
        for(int place=1;max/place>0;place *= 10)
        {
            countingSort(arr, size, place);
        }
    }

    public static void main(String[] args)
    {
        int[] data = {121,534,321,4222223,55,42,1,0};
        int size = data.length;
        radixsort(data, size);
        System.out.println(Arrays.toString(data));
    }
}