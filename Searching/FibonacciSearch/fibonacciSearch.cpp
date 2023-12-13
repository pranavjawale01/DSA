#include <iostream>
#include <vector>
#include <algorithm>

int fibonacciSearch(const std::vector<int>& arr, int target) {
    int n = arr.size();

    int fibMMinus2 = 0;
    int fibMMinus1 = 1;
    int fibM = fibMMinus1 + fibMMinus2;

    while (fibM < n) {
        fibMMinus2 = fibMMinus1;
        fibMMinus1 = fibM;
        fibM = fibMMinus1 + fibMMinus2;
    }

    int offset = -1;

    while (fibM > 1) {
        int i = std::min(offset + fibMMinus2, n - 1);

        if (arr[i] < target) {
            fibM = fibMMinus1;
            fibMMinus1 = fibMMinus2;
            fibMMinus2 = fibM - fibMMinus1;
            offset = i;
        } else if (arr[i] > target) {
            fibM = fibMMinus2;
            fibMMinus1 = fibMMinus1 - fibMMinus2;
            fibMMinus2 = fibM - fibMMinus1;
        } else {
            return i; // Found the target
        }
    }

    // Check the last element
    if (fibMMinus1 == 1 && arr[offset + 1] == target) {
        return offset + 1;
    }

    return -1; // Target not found
}

int main() {
    std::vector<int> arr = {1, 3, 5, 7, 9, 10 , 11, 13, 15, 17, 19, 21};
    int target;

    std::cout << "Enter the target element to search: ";
    std::cin >> target;

    int result = fibonacciSearch(arr, target);

    if (result != -1) {
        std::cout << "Element found at index " << result << std::endl;
    } else {
        std::cout << "Element not found in the array." << std::endl;
    }

    return 0;
}
