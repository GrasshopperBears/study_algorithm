def solution(skill, skill_trees):
    cnt = 0
    
    for skill_tree in skill_trees:
        prev = -1
        broken = False
        for _, char in enumerate(skill_tree):
            idx = skill.find(char)
            if idx < 0:
                continue
            if idx > prev+1:
                broken = True
                break
            if idx == prev+1:
                prev = idx
        if not broken:
            cnt += 1

    return cnt

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))
