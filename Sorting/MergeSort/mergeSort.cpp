#include<iostream>

using namespace std;

void merge(int arr[], int p, int q, int r)
{
    int n1 = q-p +1;
    int n2 = r-q;
    int L[n1],M[n2];

    for(int i=0;i<n1;i++)
    {
        L[i] = arr[p+ i];
    }
    for(int j=0;j<n2;j++)
    {
        M[j] = arr[q+1 +j];
    }
    int i,j,k;
    i=0,j=0,k=p;
    while(i<n1 && j <n2)
    {
        if(L[i] <= M[j])
        {
            arr[k] = L[i];
            i++;
        }
        else
        {
            arr[k] = M[j];
            j++;
        }
        k++;
    }
    while(i<n1)
    {
        arr[k] = L[i];
        k++,i++;
    }
    while(j<n2)
    {
        arr[k] = M[j];
        k++,j++;
    }
}

void mergeSort(int arr[], int l,int r)
{
    if(l<r)
    {
        int m = l + (r-l)/2;

        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);

        merge(arr,l,m,r);
    }
}

void print(int arr[], int len)
{
    for(int i=0;i<len;i++)
    {
        cout<<arr[i]<<"\t";
    }
}

int main()
{
    int arr[] = {4,23,3,23,4,23,53,876-54,-54,3,-42,-66,0,-34};
    int len = sizeof(arr)/sizeof(arr[0]);

    mergeSort(arr,0,len-1);

    print(arr,len);

    return 0;
}