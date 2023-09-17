#include<iostream>

using namespace std;

void printArr(int arr[], int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<"\t";
    }
    cout<<"\n";
}

void swap(int* a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int low, int high)
{
    int pivot = arr[high];
    int i = (low-1);

    for(int j=low;j<high;j++)
    {
        if(arr[j]<=pivot)
        {
            i++;
            swap(&arr[i],&arr[j]);
        }
    }
    swap(&arr[i+1],&arr[high]);

    return (i+1);
}

void quickSort(int arr[], int low, int high)
{
    if(low<high)
    {
        int pi = partition(arr,low,high);
        quickSort(arr,low,pi-1);
        quickSort(arr,pi+1,high);
    }
}

int main()
{
    int data[] = {3,53,12,-54,-2,-534,434,0533333,2,0,10};
    int len = sizeof(data)/sizeof(data[0]);
    printArr(data,len);
    quickSort(data,0,len-1);
    printArr(data,len);

    return 0;
}