def SelectionSort(arr,len):
    for i in range(len-1):
        minIndex = i
        for j in range(i+1,len):
            if arr[j] < arr[minIndex]:
                minIndex = j
        arr[minIndex],arr[i] = arr[i],arr[minIndex]
        
data = [43,354,-43,0,-4332,32]
SelectionSort(data,len(data))
print(data)