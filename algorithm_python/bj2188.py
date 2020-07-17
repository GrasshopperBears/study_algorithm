import sys


(cow_num, house_num) = map(int, sys.stdin.readline().split())
bucket_list = []
dest = [0 for i in range(cow_num + 1)]
assigned = [0 for i in range(house_num + 1)]
visited = [False for i in range(cow_num + 1)]
total_num = 0


def reallocate(dept):
    if visited[dept]:
        return False

    visited[dept] = True

    for i in range(1, len(bucket_list[dept - 1])):
        tmp = bucket_list[dept - 1][i]
        if tmp != dest[dept] and ((not assigned[tmp]) or reallocate(assigned[tmp])):
            assigned[tmp] = dept
            dest[dept] = tmp
            return True
    return False


for i in range(cow_num):
    bucket_list.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, cow_num + 1):
    if bucket_list[i - 1][0] == 0:
        continue
    visited = [False for j in range(cow_num + 1)]
    if reallocate(i):
        total_num += 1

print(total_num)
