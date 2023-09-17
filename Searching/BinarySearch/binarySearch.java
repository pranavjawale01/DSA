package DSA.Searching.BinarySearch;

class binarySearch
{
    public static void binSearch(int arr[],int x,int low, int high)
    {
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]==x)
            {
                System.out.println("Elemnt found at index "+mid+" with value "+arr[mid]);
                break;
            }
            if(arr[mid]>x)
            {
                high = mid - 1;
            }
            if(arr[mid] < x)
            {
                low = mid + 1;
            }
        }
    }
    public static void main(String[] args)
    {
        int[] data = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90};
        System.out.println(data.toString());
        binSearch(data,80,0,data.length-1);
    }
}