# PYTHON
import os
clear = lambda: os.system('clear')
clear()

a = 0
def increment1():
    global a
    a += 1

# print a
increment1()
# print a

b = 0

def increment2(a):
    return a + 1

# print b
# print increment2(b)
# print b

names = ["Mary", "Isla", "Sam"]
name_lengths = map(len, names)
# print name_lengths

squares = map(lambda x: x * x, [0,1,2,3,4])
# print squares

import random

code_names = ['Mr. Pink', 'Mr. Orange', 'Mr. Blonde']

# for i in range(len(names)):
#     names[i]=random.choice(code_names)

# print names

secret_names = map(lambda x: random.choice(code_names),names)

for i in range(len(names)):
    # names[i] = hash(names[i])
    pass

# print names
secret_names = map(hash, names)
# print secret_names


sum = reduce(lambda a, x: a + x, [0,1,2,3,4])

people = [{'name': 'Mary', 'height': 160},
          {'name': 'Isla', 'height': 80},
          {'name': 'Sam'}]

def nofuncheight(people):
    height_total = 0
    height_count = 0

    for person in people:
        if 'height' in person:
            height_total += person['height']
            height_count += 1
    if height_count > 0:
        average_height = height_total / height_count
        # print average_height

nofuncheight(people)

heights = map(lambda x: x['height'],
        filter(lambda x: 'height' in x, people))
# print heights

if len(heights) > 0:
        from operator import add
        average_height = reduce(add, heights) / len(heights)
# print average_height


# CARS!

from random import random


def race(time = 5):
    car_positions = [1,1,1]

    while time:
        #decrease time
        time -= 1
        print ''
        for i in range(len(car_positions)):
            # move car
            if random() > 0.3:
                car_positions[i] += 1
            print '-' * car_positions[i]

race()
