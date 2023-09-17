def printArr(arr):
    for i in range(len(arr)):
        print(arr[i],end = "\t")
        
    print("\n")
    
def heapify(arr,n,i):
    largest = i
    left = 2*i + 1 
    right = 2*i + 2
    if(left<n and arr[left]>arr[largest]):
        largest=left
    if(right<n and arr[right]>arr[largest]):
        largest=right
    if(largest != i):
        arr[largest],arr[i] = arr[i],arr[largest]
        heapify(arr,n,largest)
        
def heapSort(arr):
    n = len(arr)
    for i in range(n//2,-1,-1):
        heapify(arr,n,i)
        printArr(arr)
        
    print("\nSorted and Swapping")
    
    for i in range(n-1,0,-1):
        arr[i],arr[0] = arr[0],arr[i]
        printArr(arr)
        heapify(arr,i,0)

if __name__ == "__main__":
    data = [42,45,325,643,435,3,576,76,54,34]
    print("\nInitial Arr")
    printArr(data)
    print("\nSorting Started")
    heapSort(data)
    print("\nFinial Data")
    printArr(data)