package thewayhj;
import java.util.Scanner;

public class Problem_1002 {
    /**
     * <pre>
     *      조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
     *      이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
     *      조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
     *      류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
     *
     *      input : 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
     *              한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고,
     *              r1, r2는 10,000보다 작거나 같은 자연수이다.
     *      output : 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
     * </pre>
     * @URL https://www.acmicpc.net/problem/1002
     * @SEE http://rainmaker0303.blogspot.com/2018/01/1002.html
     * @RETURN 위치의 수 (memory : 18296KB, time: 160ms)
     * @AUTHOR thewayhj
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int arrLocation[] = new int[size];
        int x1, x2, y1, y2, r1, r2, i;
        double radis;

        for (i = 0; i < size; i++) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            r1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            r2 = scanner.nextInt();

            radis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 두 원의 크기가 똑같을 때
            if (x1 == x2 && y1 == y2 && r1 == r2)
                arrLocation[i] = -1;
                // 두 원이 멀 때, 하나의 원이 다른 하늬 원 안에 있고 중점이 같지만 두 원이 만나지 않을 때
            else if (radis > r1 + r2 || x1 == x2 && y1 == y2 && r1 != r2 || radis < Math.abs(r1 - r2))
                arrLocation[i] = 0;
                // 두 원이 한점에서 만남 (외접), 두 원이 한점에서 만남(내접)
            else if (radis == r1 + r2 || Math.abs(r1 - r2) == radis)
                arrLocation[i] = 1;
                // 그 외
            else
                arrLocation[i] = 2;
        }
        for (i = 0; i < size; i++)
            System.out.println(arrLocation[i]);
    }
}
