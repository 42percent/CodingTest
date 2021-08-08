package solution1;/*
    Problem Name    : 로또의 최고 순위와 최저 순위
    Problem Status  : Solved
    Problem From    : 연습문제
    Problem Link    : https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
*/

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {

  public static void main(String[] args) {
    Solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
  }

  public static int[] solution(int[] lottos, int[] win_nums) {
    var answer =  new int[]{6, 6};
    var a = Arrays.stream(lottos).sequential().filter(s -> s == 0).count();
    var c = Arrays.stream(lottos).sequential().filter(s -> Arrays.stream(win_nums).boxed().collect(Collectors.toList()).contains(s)).count();
    var e = c + a;

    if (e > 1)
      answer[0] = 7 - (int) e;
    if (c > 1)
      answer[1] = 7 - (int) c;

    return answer;
  }
}
