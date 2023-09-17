def partion(arr,low,high):
    pivot = arr[high]
    i = low-1
    for j in range(low,high):
        if(arr[j]<=pivot):
            i+=1
            arr[i],arr[j] = arr[j],arr[i]
    arr[i+1],arr[high] = arr[high],arr[i+1]
    return i+1
    
    
def quickSort(arr,low,high):
    if(low<high):
        pi = partion(arr,low,high)
        quickSort(arr,low,pi-1)
        quickSort(arr,pi+1,high)
    
def printArr(arr):
    for i in range(len(arr)):
        print(arr[i],end="....")
    print("\n")
    
if __name__ == '__main__':
    data = [53,43,-53,0,3,9,-2,43,3444,-3234]
    printArr(data)
    quickSort(data,0,len(data)-1)
    printArr(data)