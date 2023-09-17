def BubbleSort(data):
    for i in range(len(data)):
        flag=0
        for j in range(0,len(data)-i-1):
            if data[j] > data[j+1]:
                #temp = data[j]
                #data[j] = data[j+1]
                #data[j+1] = temp
                data[j] , data[j+1] = data[j+1] , data[j]
                flag=1
        if(flag==0):
            break;
                
data = [-4,4,23,0,-34,534,-43333]
BubbleSort(data)
print(data)