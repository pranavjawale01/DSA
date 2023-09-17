#include<iostream>
using namespace std;

void binSearch(int arr[],int x,int low, int high)
{
    while(low<=high)
    {
        int mid = (low+high)/2;
        if(arr[mid]==x)
        {
            cout<<"\nElement found at index "<<mid<<" with value "<<arr[mid];
            break;
        }
        if(arr[mid] < x)
        {
            low = mid+1;
        }
        if(arr[mid] > x)
        {
            high = mid-1;
        }
    }
}

int main()
{
    int data[] = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,99};
    cout<<data;
    int n = sizeof(data)/sizeof(data[0]) - 1;
    binSearch(data,99,0,n);

    return 0;
}