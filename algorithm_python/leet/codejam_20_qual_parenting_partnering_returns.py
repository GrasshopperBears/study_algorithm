import sys

caseNumber = int(sys.stdin.readline())


class Child:
    def __init__(self):
        self.timetable = []

    def assign(self, time):
        for task in self.timetable:
            if (task[0] < time[0] < task[1]) or (task[0] < time[1] < task[1]):
                return False
        self.timetable.append(time)
        return True


def main(itr):
    taskNumber = int(sys.stdin.readline())
    tasks = []
    cameron = Child()
    jamie = Child()
    result = ''
    for j in range(taskNumber):
        [start, end] = list(map(int, sys.stdin.readline().split(' ')))
        tasks.append((start, end))

    for task in tasks:
        if not cameron.assign(task):
            if not jamie.assign(task):
                result = 'IMPOSSIBLE'
                break
            else:
                result += 'J'
        else:
            result += 'C'
    print('Case #{}: {}'.format(itr + 1, result))


for i in range(caseNumber):
    main(i)
