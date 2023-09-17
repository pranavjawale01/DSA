#include<iostream>
using namespace std;

void shellsort(int arr[],int n)
{
    for(int interval = n/2; interval>0 ; interval /= 2)
    {
        for(int i=interval ; i < n ; i++)
        {
            int temp = arr[i];
            int j;
            for(j=i; j>= interval && arr[j-interval] > temp; j -= interval)
            {
                arr[j] = arr[j-interval];
            }
            arr[j] = temp;
        }
    }
}

void printArr(int arr[],int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<"\t";
    }
    cout<<endl;
}

int main()
{
    int data[] = {4,7,2,6,2,7,72,8,1};
    int size = sizeof(data)/sizeof(data[0]);
    shellsort(data,size);
    cout<<"\nSorted Array\n";
    printArr(data,size);

    return 0;
}