package DSA.Sorting.SelectionSort;

class SelectionSort
{
    static void swap(int arr[],int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static void Sorting(int arr[], int len)
    {
        int minIndex;
        for(int i=0;i<len-1;i++)
        {
            minIndex = i;
            for(int j=i+1;j<len;j++)
            {
                if(arr[j]<arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }
    static void printing(int arr[], int len)
    {
        for(int i=0;i<len;i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {432,34,1,3322,-34,0,43};
        int len  = arr.length;
        Sorting(arr,len);
        printing(arr, len);
    }
}