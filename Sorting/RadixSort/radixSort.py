def countingSort(arr,place):
    size = len(arr)
    output = [0]*size
    count = [0]*10
    
    for i in range(0,size):
        index = arr[i]
        count[index % 10] += 1
        
    for i in range(1,10):
        count[i] += count[i-1]
        
    i = size -1
    while i>=0:
        index = arr[i]
        output[count[index % 10]-1] = arr[i]
        count[index % 10] -= 1
        i -= 1
        
    for i in range(0,size):
        arr[i] = output[i]

def radixSort(arr):
    maxElement = max(arr)
    place = 1
    while maxElement // place > 0:
        countingSort(arr,place)
        place *= 10
    
if __name__ == "__main__":
    data = [3,53,42,23,43333,542,1,324,23]
    radixSort(data)
    print(data)