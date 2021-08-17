"""
    Problem Name    : 순위 검색
    Problem Status  : Solved
    Problem Link    : https://programmers.co.kr/learn/courses/30/lessons/72412?language=python3
"""
from enum import Enum
from itertools import product
from bisect import bisect_left


def solution(info, query):
    answer = []
    d = {}
    for i in info:
        s = i.split(' ')
        k = (s[0], s[1], s[2], s[3])
        if d.get(k):
            d.get(k).append(int(s[4]))
        else:
            d[k] = [int(s[4])]

    for _ in d.keys():
        d[_] = sorted(d[_])

    for q in query:
        s = q.split()
        t = [[i.value for i in Language] if s[0] == '-' else [s[0]],
             [i.value for i in Position] if s[2] == '-' else [s[2]],
             [i.value for i in CAREER] if s[4] == '-' else [s[4]],
             [i.value for i in SOULFOOD] if s[6] == '-' else [s[6]]]

        t = set(product(*t)).intersection(d.keys())
        t2 = 0
        for _ in t:
            t2 += len(d[_]) - bisect_left(d[_], int(s[7]))
        answer.append(t2)

    return answer


class Language(Enum):
    JAVA = 'java'
    CPP = 'cpp'
    PYTHON = 'python'


class Position(Enum):
    BE = 'backend'
    FE = 'frontend'


class CAREER(Enum):
    JUNIOR = 'junior'
    SENEIOR = 'senior'


class SOULFOOD(Enum):
    CHICKEN = 'chicken'
    PIZZA = 'pizza'



solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],
         ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"])