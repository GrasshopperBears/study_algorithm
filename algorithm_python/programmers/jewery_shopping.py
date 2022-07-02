def solution(gems):
    ans = [1, len(gems)]
    types = len(set(gems))
    
    stats = {}
    stats[gems[0]] = 1
    left, right = 0, 0
    
    def check():
        nonlocal left, right, stats, ans
        if len(stats) == types:
            if ans[1] - ans[0] > right - left:
                ans = [left+1, right+1]
            return True
        return False
    
    while right < len(gems):
        result = check()
        if not result:
            if right == len(gems)-1: break
            right += 1
            prev = gems[right]
            stats[prev] = 1 if prev not in stats else stats[prev]+1
        else:
            stats[gems[left]] -= 1
            if stats[gems[left]] == 0:
                del stats[gems[left]]
            left += 1

    return ans


print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))
