import java.util.Scanner;

public class Problem_72410 {
    /**
     * <pre>
     *      신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때,
     *      "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
     *
     *          1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     *          2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     *          3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     *          4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     *          5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     *          6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *               만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     *          7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     *
     *      input : 유저가 입력한 아이디.
     *      output : 규칙에 맞는 아이디 value.
     * </pre>
     * @URL https://programmers.co.kr/learn/courses/30/lessons/72410
     * @RETURN 아이디 value return.
     * @AUTHOR thewayhj
     * */
    public static void main(String[] args) {
        Scanner inputId = new Scanner(System.in);
        Solution solution = new Solution();
        String id = inputId.next();
        System.out.println(solution.solution(id));
    }

    static class Solution {
        public String solution(String new_id) {
            String answer = "";

            // 1단계 : new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
            answer = new_id.toLowerCase();

            // 2단계 : new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            answer = answer.replaceAll("[^a-z0-9\\-_.]", "");

            // 3단계 : new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            answer = answer.replaceAll("[.]{2,}", ".");

            // 4단계 new_id에서 마침표(.)가 처음에 위치한다면 제거합니다/
            if(".".equals(String.valueOf(answer.charAt(0))))
                answer = answer.substring(1);

            // 5단계 : new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            if(answer.isEmpty())
                answer = "a";

            // 6단계 : new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            if(answer.length() > 15)
                answer = answer.substring(0, 15);

            // 4단계 : new_id에서 마침표(.)가 끝에 위치한다면 제거합니다.
            // (해당 로직은 4단계이나 6단계 마침표 관련하여 중복 로직으로 판단하여 추후 처리.)
            if(".".equals(String.valueOf(answer.charAt(answer.length() - 1))))
                answer = answer.substring(0, answer.length() - 1);

            // 7단계 : new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
            while (answer.length() < 3)
                answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));

            return answer;
        }
    }
}