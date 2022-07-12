def solution(n, costs):
    costs.sort(key=lambda x: x[2])
    cost = costs[0][2]
    connected = set()
    connected.add(costs[0][0])
    connected.add(costs[0][1])
    costs.pop(0)
    
    while len(connected) < n:
        i = 0
        while i < len(costs):
            [a, b, c] = costs[i]
            if a in connected and b in connected:
                costs.pop(i)
                continue
            if a in connected or b in connected:
                cost += c
                connected.add(b if a in connected else a)
                costs.pop(i)
                break
            i+= 1
        
    return cost


print(solution(4, [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]))   # 4
