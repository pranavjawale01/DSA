def linearsearch(arr,element):
    for i in range(len(arr)):
        if arr[i]==element:
            print("Element is found at index ",i," with value ",arr[i])
            
if __name__ == "__main__":
    data = [4,4,52,34353,464,673334,54,6545,77]
    print(data)
    element = int(input("Enter Element to search "))
    linearsearch(data,element)