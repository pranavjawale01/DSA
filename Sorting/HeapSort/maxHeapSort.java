package DSA.Sorting.HeapSort;

class maxHeapSort
{
    static void print(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    static void heapify(int arr[],int n,int i)
    {
        int largest = i;
        int left = 2*i +1;
        int right = 2*i +2;
        if(left < n && arr[left]>arr[largest])
        {
            largest=left;
        }
        if(right < n && arr[right]>arr[largest])
        {
            largest=right;
        }
        if(largest!=i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
    static void heapSort(int arr[])
    {
        int n =arr.length;
        for(int i=n/2-1;i>=0;i--)
        {
            heapify(arr, n, i);
            print(arr);
        }
        System.out.println("Sorted and swapping");
        for(int i= n-1;i>=0;i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            print(arr);
            heapify(arr, i, 0);
        }
    }
    public static void main(String[] args)
    {
        int arr[] = {3,42,42,111,3565,434,64,2,3};
        System.out.println("Initial Array");
        print(arr);
        System.out.println("Sorting Started");
        heapSort(arr);
        System.out.println("Finial Array");
        print(arr);
    }
}