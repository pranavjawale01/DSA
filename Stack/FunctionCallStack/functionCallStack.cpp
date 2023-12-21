#include <iostream>
using namespace std;

void functionB(int depth);

void functionA(int depth) {
    int localVarA = depth;
    cout << "Entering functionA(" << localVarA << ")" << endl;

    functionB(depth + 1);
    
    cout << "Exiting functionA(" << localVarA << ")" << endl;
}

void functionB(int depth) {
    int localVarB = depth;
    cout << "Entering functionB(" << localVarB << ")" << endl;
    
    cout << "Exiting functionB(" << localVarB << ")" << endl;
}

int main() {
    cout << "Entering main" << endl;

    functionA(1);
    
    cout << "Exiting main" << endl;
    return 0;
}