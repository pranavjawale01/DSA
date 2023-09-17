package DSA.Sorting.MergeSort;

class mergeSort
{
    static void merge(int arr[], int p, int q, int r)
    {
        int n1 = q-p +1;
        int n2 = r-q;
        int L[] = new int[n1];
        int M[] = new int[n2];

        for(int i=0;i<n1;i++)
        {
            L[i] = arr[p + i];
        }
        for(int j=0;j<n2;j++)
        {
            M[j] = arr[q+1 + j];
        }

        int i,j,k;
        i=0;
        j=0;
        k=p;

        while(i<n1 && j<n2)
        {
            if(L[i] <= M[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = M[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k] = L[i];
            k++;
            i++;
        }
        while(j<n2)
        {
            arr[k] = M[j];
            k++;
            j++;
        }
    }

    static void MergeSort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int m = l + (r - l)/2;

            MergeSort(arr, l, m);
            MergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    static void print(int arr[])
    {
        int len = arr.length;
        for(int i=0;i<len;i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }
    public static void main(String[] args)
    {
        int[] data = {3,53,3,5,42,3,-53,-3,0,-53,5,-43,-42};
        print(data);
        int len = data.length-1; 
        MergeSort(data, 0, len);
        System.out.println("Sorted Array \n");
        print(data);
    }
}