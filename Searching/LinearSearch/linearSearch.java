package DSA.Searching.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

class linearSearch
{
    public static void linearS(int[] arr,int element)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==element)
            {
                System.out.println("Elemnt is found at index "+i+" with value "+arr[i]);
                break;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        int[] data = {3,64,323,4,576,879,456,345,235367,678};
        String array = Arrays.toString(data);
        System.out.println(array);
        System.out.println("enter the element to find ");
        int n = sc.nextInt();
        linearS(data, n);
    }
}