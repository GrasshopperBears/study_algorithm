#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int fib(int n){
    int* fibArr = (int *)malloc(sizeof(int) * (n + 1));

    if (n == 0)
        return 0;
    if (n == 1)
        return 1;

    fibArr[0] = 0;
    fibArr[1] = 1;

    for (int i = 2; i <= n; i++) {
        fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
    }

    return fibArr[n];
}

void main(void) {
    printf("%d", fib(2));
}