#include<iostream>

using namespace std;

void printArr(int arr[], int len)
{
    for(int i=0;i<len;i++)
    {
        cout<<arr[i]<<"\t";
    }
}

void countSort(int arr[],int len)
{
    int output[10];
    int count[10];
    int max = arr[0];

    for(int i=1;i<len;i++)
    {
        if(arr[i]>max)
        {
            max = arr[i];
        }
    }

    for(int i=0; i<=max ; i++)
    {
        count[i]=0;
    }

    for(int i=0;i<len;i++)
    {
        count[arr[i]]++;
    }

    for(int i=1;i<=max;i++)
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

int main()
{
    int data[] = {4, 2, 2, 8, 3, 3, 1,9,9};
    int len = sizeof(data)/sizeof(data[0]);
    countSort(data,len);
    printArr(data,len);

    return 0;
}