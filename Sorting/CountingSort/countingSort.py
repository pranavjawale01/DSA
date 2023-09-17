def printArr(data):
    for i in range(len(data)):
        print(data[i],end="....")
    print("\n")

def countingSort(data):
    k = max(data)
    output = [0]*len(data)        
    count = [0]*(k+1)
    
    for i in range(0,len(data)):
        count[data[i]] += 1
        
    for i in range(1,k+1):
        count[i] += count[i-1]
        
    i = len(data) - 1
    
    while i>=0:
        output[count[data[i]]-1] = data[i]
        count[data[i]] -= 1
        i -= 1
        
    for i in range(0,len(data)):
        data[i] = output[i]
    

if __name__ == '__main__':
    data = [4,2,5,2,4,2,0,9,8,7,6,5,4,3,2,1,3,5,7,3]
    printArr(data)
    countingSort(data)
    printArr(data)    