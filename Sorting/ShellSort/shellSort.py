def shellSort(arr,n):
    interval = n//2
    while interval > 0:
        for i in range(interval,n):
            temp = arr[i]
            j = i
            while j>= interval and arr[j-interval] > temp :
                arr[j] = arr[j-interval]
                j -= interval
                print(arr)
            
            arr[j] = temp
        interval //=2


if __name__ == "__main__":
    data = [3,535,6,35,546,47,567,63,452,3,5,64,75,686,78,646,345,24]
    size = len(data)
    shellSort(data,size)
    print(data)