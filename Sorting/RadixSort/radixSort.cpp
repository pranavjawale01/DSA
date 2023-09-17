#include<iostream>
using namespace std;

int getMax(int arr[], int n) {
    int max = arr[0];
    for(int i = 1; i < n; i++) {
        if(arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

void printArr(int arr[], int size) {
    for(int i = 0; i < size; i++) {
        cout << arr[i] << "\t";
    }
    cout << endl;
}

void countingSort(int arr[], int size, int place) {
    const int max = 10;
    int output[size];
    int count[max] = {0};

    for(int i = 0; i < size; i++) {
        count[(arr[i] / place) % 10]++;
    }

    for(int i = 1; i < max; i++) {
        count[i] += count[i - 1];
    }

    for(int i = size - 1; i >= 0; i--) {
        output[count[(arr[i] / place) % 10] - 1] = arr[i];
        count[(arr[i] / place) % 10]--;
    }

    for(int i = 0; i < size; i++) {
        arr[i] = output[i];
    }
}

void radixSort(int arr[], int size) {
    int max = getMax(arr, size);
    for(int place = 1; max / place > 0; place *= 10) {
        countingSort(arr, size, place);
        printArr(arr, size);
    }
}

int main() {
    int arr[] = {1211, 4, 233, 333, 0, 11, 451};
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << "Initial" << endl;
    printArr(arr, n);
    radixSort(arr, n);
    cout << "Final" << endl;
    printArr(arr, n);

    return 0;
}