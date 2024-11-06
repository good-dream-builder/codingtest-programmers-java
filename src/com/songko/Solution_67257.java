package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

/**
 * [카카오 인턴] 수식 최대화
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 * <p>
 */
public class Solution_67257 implements TestInterface {
    String[] ops = new String[]{"+", "-", "*"};
    String[] regex = new String[]{"\\+", "-", "\\*"};

    public long solution(String expression) {

        solve(expression, 0, 0);

        long answer = 0;
        return answer;
    }

    public long solve(String expression, int opsIdx, long result) {

        if (expression.contains(ops[opsIdx])) {
            String[] splited = expression.split(regex[opsIdx]);
            Log.print(splited);

            if(splited.length == 2) {
                calc(splited[0], splited[1])
            }

            for (String ex : splited) {
                result += solve(ex, ((opsIdx + 1) % 3), result);

            }
        }

        return Long.valueOf(expression);
    }

    public long calc(long left, long right, String op) {
        long result = 0;
        switch (op) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
        }

        return result;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        // 60420
        String tc1 = "100-200*300-500+20";
        long solv1 = solution(tc1);
        Log.print(solv1);

        // 300
//        String tc2 = "50*6-3*2";
//        long solv2 = solution(tc2);
//        Log.print(solv2);
    }
}