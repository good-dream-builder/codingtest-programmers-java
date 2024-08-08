package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * <p>
 * 16:55 ~
 */
public class Solution_84512 implements TestInterface {

    public int solution(String word) {
        int answer = 0;
        return answer;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        String tc1 = "AAAAE";
        int solv1 = solution(tc1);
        Log.print(solv1);

        String tc2 = "AAAE";
        int solv2 = solution(tc2);
        Log.print(solv2);

        String tc3 = "I";
        int solv3 = solution(tc3);
        Log.print(solv3);

        String tc4 = "EIO";
        int solv4 = solution(tc4);
        Log.print(solv4);
    }
}