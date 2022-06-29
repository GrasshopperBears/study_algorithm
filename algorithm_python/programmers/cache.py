def solution(cacheSize, cities):
    total = 0
    cache = []
    
    for city in cities:
        city = city.lower()
        try:
            idx = cache.index(city)
            total += 1
            cache = cache[:idx] + cache[idx+1:] + [city]
        except:
            if len(cache)+1 <= cacheSize:
                cache = cache + [city]
            elif cacheSize > 0:
                cache = cache[1:] + [city]
            total += 5
        print(cache)
    
    return total


# print(solution(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]))
print(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]))
