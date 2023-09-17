#include<iostream>
using namespace std;

void printArr(int arr[],int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<"\t";
    }
    cout<<endl;
}

void heapify(int arr[], int n, int i)
{
    int largest = i;
    int left = 2*i+1;
    int right = 2*i+2;
    if(left<n && arr[left]>arr[largest])
    {
        largest=left;
    }
    if(right<n && arr[right]>arr[largest])
    {
        largest=right;
    }
    if(largest!=i)
    {
        swap(arr[largest],arr[i]);
        heapify(arr,n,largest);
    }
}

void maxHeapSort(int arr[],int n)
{
    for(int i=n/2-1;i>=0;i--)
    {
        heapify(arr,n,i);
        printArr(arr,n);
    }
    cout<<"\nSorted and Swapping\n";
    for(int i=n-1;i>=0;i--)
    {
        swap(arr[0],arr[i]);
        printArr(arr,n);
        heapify(arr,i,0);
    }
}

int main()
{
    int arr[] = {1,12,43,53,1,435,432,4};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout<<"\nInitial Array\n";
    printArr(arr,n);
    cout<<"\nSorting Started\n";
    maxHeapSort(arr,n);
    cout<<"\n\n\nfinally sorted array\n\n";
    printArr(arr,n);
}