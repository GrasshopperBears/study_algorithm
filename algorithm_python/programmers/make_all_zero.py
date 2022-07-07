def solution(a, edges):
    if sum(a) != 0: return -1

    graph = {}
    cnt = 0
    
    for i in range(len(a)):
        graph[i] = []
    
    for [u, v] in edges:
        graph[u].append(v)
        graph[v].append(u)
    
    def dfs(x, prev):
        nonlocal cnt, graph
        
        for adj in graph[x]:
            if adj != prev:
                curr = dfs(adj, x)
                a[x] += curr
                cnt += abs(curr)
                
        return a[x]
    
    dfs(0, None)
    return cnt


print(solution([-5,0,2,1,2], [[0,1],[3,4],[2,3],[0,3]]))
