package DSA.Sorting.QuickSort;

class quickSort
{
    public static void printArr(int arr[])
    {
        int len = arr.length;
        for(int i=0;i<len;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    public static void swap(int data[], int a, int b)
    {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    public static int partition(int arr[],int low,int high)
    {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    public static void sort(int arr[],int low, int high)
    {
        if(low<high)
        {
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    public static void main(String[] args)
    {
        int data[] = {43,23,-34,32,-53,2,034,-2};
        printArr(data);
        sort(data, 0, data.length-1);
        printArr(data);

    }
}