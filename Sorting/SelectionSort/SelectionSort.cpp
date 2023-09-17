#include<iostream>

using namespace std;

void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void print(int array[], int len)
{
    for(int i=0;i<len;i++)
    {
        printf("%d\t",array[i]);
    }
}

void SelectionSort(int arr[], int len)
{
    for(int i=0;i<len-1;i++)
    {
        int minIndex = i;
        for(int j=i+1;j<len;j++)
        {
            if(arr[j]<arr[minIndex])
            {
                minIndex = j;
            }
        }
        swap(&arr[minIndex],&arr[i]);
    }
}

int main()
{
    int data[] = {34,32,2,-4,42,31,0,-53};
    int len = sizeof(data)/sizeof(data[0]);
    SelectionSort(data,len);
    print(data,len);

    return 0;
}