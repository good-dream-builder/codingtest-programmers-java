package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * <p>
 * 2시간 4분, 1회차 통과
 */
public class Solution_84512 implements TestInterface {

    Integer step = 0;
    final String[] given = new String[]{"A", "E", "I", "O", "U"};

    public boolean find(String search, String word) {
        if (search.equals(word)) {
            return true;
        }

        if (step > 0 && word.length() % 5 == 0) {
            return false;
        }

        boolean isFind = false;
        for (int i = 0; i < 5; i++) {
            step++;
            isFind = find(search, word.concat(given[i]));

            if (isFind) {
                break;
            }

            word = word.substring(0, word.length());
        }

        return isFind;
    }

    public int solution(String word) {
        find(word, "");
        int answer = step;
        return answer;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
//        // 6
//        String tc1 = "AAAAE";
//        int solv1 = solution(tc1);
//        Log.print(solv1);
//
//        // 10
//        String tc2 = "AAAE";
//        int solv2 = solution(tc2);
//        Log.print(solv2);

        // 1563
//        String tc3 = "I";
//        int solv3 = solution(tc3);
//        Log.print(solv3);

        // 1189
        String tc4 = "EIO";
        int solv4 = solution(tc4);
        Log.print(solv4);
    }
}