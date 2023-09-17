#include<iostream>
using namespace std;

void bubbleSort(int arr[], int n) 
{
    for(int i = 0; i < n - 1; i++) 
    {
        int flag = 0;
        for(int j = 0; j < n - i - 1; j++) 
        {
            if(arr[j] > arr[j + 1]) 
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag=1;
            }
        }
        if(flag==0)
        {
            break;
        }
    }
}

void print(int arr[], int n) 
{
    for(int i = 0; i < n; i++) 
    {
        cout << arr[i] << '\t';
    }
}

int main() 
{
    int arr[5] = {4, -34, 42, 53, 2}; // Removed leading 0 from 053
    int size = sizeof(arr) / sizeof(arr[0]);
    bubbleSort(arr, size);
    print(arr, size);

    int a = sizeof(arr);
    int b = sizeof(arr[0]);
    cout << "\nSize of arr: " << a << " bytes" << endl;
    cout << "Size of arr[0]: " << b << " bytes" << endl;
    cout << "Size: " << size << endl;

    return 0;
}