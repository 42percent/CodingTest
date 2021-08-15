"""
    Problem Name    : 신규 아이디 추천
    Problem Status  : Solved
    Problem Link    : https://programmers.co.kr/learn/courses/30/lessons/72410
"""

import re


def solution(new_id):

    answer = str(new_id)
    answer = answer.lower()
    answer = re.findall('[a-z0-9\.\-\_]', answer)
    answer = ''.join(answer)
    answer = re.sub('[.]+', '.', answer)
    answer = answer[1:] if answer[0] == '.' else answer
    answer = answer[:-1] if len(answer) and answer[-1] == '.' else answer
    answer = 'a' if len(answer) == 0 else answer
    answer = answer[:15] if len(answer) > 15 else answer
    answer = answer[:-1] if answer[-1] == '.' else answer
    answer = answer + answer[-1] * (3 - len(answer)) if len(answer) < 3 else answer

    return answer


print(solution("...!@BaT#*..y.abcdefghijklm"))
# print(solution("z-+.^."))
print(solution("=.="))
# print(solution("123_.def"))
# print(solution("abcdefghijklmn.p"))