def insertionSort(arr,n):
    for i in range(1,n):
        key = arr[i]
        j = i-1
        while(key < arr[j] and j>=0):
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = key
        
def printArray(arr,n):
    for i in range(n):
        print(arr[i])
        
data = [3,34,1,-34,222,0,43,-2]
insertionSort(data,len(data))
print(data,len(data))