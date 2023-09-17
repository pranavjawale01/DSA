def mergeSort(arr):
    if len(arr)>1:
        r = len(arr)//2
        L = arr[:r]
        M = arr[r:]
        
        mergeSort(L)
        mergeSort(M)
        
        i=j=k = 0
    
        while i < len(L) and j < len(M):
            if L[i] < M[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = M[j]
                j += 1
            k += 1
    
        while i < len(L):
            arr[k] = L[i]
            k +=1 
            i +=1
    
        while j < len(M):
            arr[k] = M[j]
            k +=1
            j +=1
        
        
def printing(arr):
    for i in range(len(arr)):
        print(arr[i],end="....")
    print()
        
        
if __name__ == '__main__':
    data = [23,43,32,34,23,5,-45,-3,-4532,-5,-3,0]
    printing(data)
    mergeSort(data)
    printing(data)