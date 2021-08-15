package solution2;/*
    Problem Name    : 행렬 테두리 회전하기
    Problem Status  : Solving
    Problem From    : 연습문제
    Problem Link    : https://programmers.co.kr/learn/courses/30/lessons/77485
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
  public static void main(String[] args) {
    System.out.println(solution(5, 3, new int[][]{}));
  }
  public static int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = {};
    var a = IntStream.range(0, rows).map(i -> i * columns + 1)
            .mapToObj(i ->  IntStream.range(i, i + columns).boxed().collect(Collectors.toList()))
            .map(Arrays::asList)
            .toArray();
    Arrays.asList(queries).forEach(q -> {
      IntStream.range(q[0], q[2] - 1).forEach(i -> {
        var e = a[q[0]];

//        a[q[0]][i - 1] = a[q[0]][i];
      });
    });

    return answer;
  }
}
