package programmers.level1.P81301;

class Solution {
    int answer = 0;
    String tmp = "";

    public void add(String num) {
        int n = Integer.parseInt(num);
        answer *= 10;
        answer += n;
        tmp = "";
    }

    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                add(String.valueOf(c));
                continue;
            }

            tmp += c;

            switch (tmp) {
                case "zero": add("0"); break;
                case "one": add("1"); break;
                case "two": add("2"); break;
                case "three": add("3"); break;
                case "four": add("4"); break;
                case "five": add("5"); break;
                case "six": add("6"); break;
                case "seven": add("7"); break;
                case "eight": add("8"); break;
                case "nine": add("9"); break;
            }
        }

        return answer;
    }
}