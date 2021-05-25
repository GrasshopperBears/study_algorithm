#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int* shortestToChar(char * S, char C, int* returnSize){
    int len = strlen(S);
    int* ans = (int *)malloc(sizeof(int) * len);
    int* posArr = (int *)malloc(sizeof(int) * len);
    int cNumber = 0;
    int currPos = 0;

    for (int i = 0; i < len; i++) {
        if (S[i] == C) {
            posArr[cNumber] = i;
            cNumber++;
        }
    }
    cNumber--;

    for (int i = 0; i < len; i++) {
        if (currPos < cNumber && currPos < i) {
            if (i - posArr[currPos] > posArr[currPos + 1] - i)
                currPos++;
        }

        ans[i] = abs(posArr[currPos] - i);
    }

    free(posArr);
    *returnSize = len;
    return ans;
}

void main(void){
    char* S = "loveleetcode";
    char C = 'e';
    int returnSize;
    int* ans = shortestToChar(S, C, &returnSize);
    for (int i = 0; i < returnSize; i++) {
        printf("%d ", ans[i]);
    }
    return;
}