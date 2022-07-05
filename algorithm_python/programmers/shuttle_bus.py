def solution(n, t, m, timetable):
    base = 60*9
    answer = 0
    table = []
    lastBus = base + t * (n-1)

    for crew in timetable:
        [hh, mm] = list(map(int, crew.split(':')))
        converted = 60*hh + mm
        if converted <= lastBus:
            table.append(converted)

    table.sort()
    crewNum = len(table)
    waitingFrom = 0

    for i in range(n-1):
        bus, leftSeat = base + t * i, m
        while leftSeat > 0 and waitingFrom < crewNum and table[waitingFrom] <= bus:
            waitingFrom += 1
            leftSeat -=1

    if waitingFrom + m > crewNum:
        answer = lastBus
    elif table[waitingFrom] == table[waitingFrom + m - 1]:
        answer = table[waitingFrom] - 1
    else:
        i = waitingFrom + m - 1
        while i >= waitingFrom and table[i] == table[i-1]:
            i -= 1
        answer = table[i] - 1

    return "{0:02d}".format(answer // 60) + ":" + "{0:02d}".format(answer % 60)

print(solution(10, 1, 5, ["09:00", "09:00", "09:00", "09:00", "09:00"]))
