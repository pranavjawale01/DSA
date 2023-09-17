def binarySearch(arr,x,low,high):
    while low <= high:
        mid = low + high //2
        if arr[mid] == x:
            print("\nElement found at index ",mid," with value ",arr[mid])
            break
        if arr[mid] > x:
            high = mid - 1
        if arr[mid] < x:
            low = mid + 1
            
if __name__ == "__main__":
    data = [1,2,3,4,5,6,7,8,9,10,32,53,433,3543]
    print(data)
    binarySearch(data,3543,0,len(data)-1)