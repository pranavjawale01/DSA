

class countingSort
{
    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println("\n");
    }
    static void sort(int[] arr,int len)
    {
        int k = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            k=Math.max(k,arr[i]);
        }
        int output[] = new int[len];
        int count[] = new int[k+1];
        for(int i=0;i<k;i++)
        {
            count[i]=0;
        }
        for(int i=0;i<len;i++)
        {
            count[arr[i]]++;
        }
        for(int i=1;i<=k;i++)
        {
            count[i] += count[i-1];
        }
        for(int i=len-1;i>=0;i--)
        {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for(int i=0;i<len;i++)
        {
            arr[i]=output[i];
        }
    }
    public static void main(String[] args)
    {
        int[] data = {1,4,2,4,5,2,5,2,6,7,4,7,4,8,9,3,1,5,0,4,2};
        int len = data.length;
        printArr(data);
        sort(data,len);
        printArr(data);
    }
}