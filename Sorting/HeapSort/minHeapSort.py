def printArr(arr):
    for i in range(len(arr)):
        print(arr[i],end = "\t")
        
    print("\n")
    
def heapify(arr,n,i):
    lowest = i
    left = 2*i + 1 
    right = 2*i + 2
    if(left<n and arr[left]<arr[lowest]):
        lowest=left
    if(right<n and arr[right]<arr[lowest]):
        lowest=right
    if(lowest != i):
        arr[lowest],arr[i] = arr[i],arr[lowest]
        heapify(arr,n,lowest)
        
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