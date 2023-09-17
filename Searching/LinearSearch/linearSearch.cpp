#include<iostream>
using namespace std;

void printArr(int arr[],int n)
{
    cout<<endl;
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<"\t";    
    }
    cout<<endl;
}

void linearSearch(int arr[],int n,int element)
{
    for(int i=0;i<n;i++)
    {
        if(arr[i]==element)
        {
            cout<<"Element is Present at index "<<i<<" with value "<<arr[i];
            break;
        }
    }
}

int main()
{   
    int data[] = {34,234,43,5,24,35,43,54,25,3645,65,867,8,435,2,3};
    int n = sizeof(data)/sizeof(data[0]);
    printArr(data,n);
    int element;
    cout<<"\nEnter The element to search ";
    cin>>element;
    linearSearch(data,n,element);

    return 0;
}