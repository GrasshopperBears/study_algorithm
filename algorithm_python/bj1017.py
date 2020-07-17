import sys
import math


num = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.insert(0, 0)
dest = [-1 for i in range(num + 1)]
origin = [-1 for i in range(num + 1)]
primes = [2, 3, 5, 7]
visited = [False for i in range(num + 1)]
ans = []



def is_prime(n):
    if n in primes:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    for i in range(4, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    primes.append(n)
    return True



