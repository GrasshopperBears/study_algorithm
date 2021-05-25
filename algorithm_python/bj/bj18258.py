import sys
import queue


orderNum = int(sys.stdin.readline())
queue = queue.Queue()

for i in range(orderNum):
    order = sys.stdin.readline().split()
    name = order[0]
    size = queue.qsize()
    if name == 'push':
        queue.put(order[1])
    elif name == 'pop':
        if size == 0:
            sys.stdout(-1)
            sys.stdout('\n')
        else:
            sys.stdout(queue.get())
            sys.stdout('\n')
    elif name == 'size':
        if size == 0:
            sys.stdout(-1)
            sys.stdout('\n')
        else:
            sys.stdout(size)
            sys.stdout('\n')
    elif name == 'empty':
        if size == 0:
            sys.stdout(1)
            sys.stdout('\n')
        else:
            sys.stdout(0)
            sys.stdout('\n')
    elif name == 'front':
        if size == 0:
            sys.stdout(-1)
            sys.stdout('\n')
        else:
            sys.stdout(queue[0])
            sys.stdout('\n')
    elif name == 'back':
        if size == 0:
            sys.stdout(-1)
            sys.stdout('\n')
        else:
            sys.stdout(queue[-1])
            sys.stdout('\n')

