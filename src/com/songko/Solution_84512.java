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

    class Given {
        int lastIdx;
        String[] words = new String[]{"A", "E", "I", "O", "U"};

        public String getCurrentWord() {
            return words[lastIdx];
        }

        public String getNextWord(int index) {
            int pivot = index / 5;
            if (pivot > 0 && index % 5 == pivot) {
                lastIdx++;
            }
            return words[lastIdx % 5];
        }
    }


    public void find(String search, StringBuffer word, int index, Given given) {
        if (word.toString().equals(search)) {
            Log.print(index + " : " + word.toString());
            return;
        }

        int len = word.length();
        if (len > 2) {
            if (word.substring(len - 2, len - 1).equals("U")) {
                return;
            }
        }

        if (len == 5) {
            word = new StringBuffer(word.substring(0, 4));
            word.append(given.getNextWord(index));
            find(search, word, index + 1, given);
            return;
        }



        word.append(given.getNextWord(index));
        Log.print(index + " : " + word.toString());

        find(search, word, index + 1, given);
    }

    public int solution(String word) {
        int answer = 0;
        find(word, new StringBuffer(), 0, new Given());

        return answer;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
//        String tc1 = "AAAAE";
//        int solv1 = solution(tc1);
//        Log.print(solv1);
//
        String tc2 = "AAAE";
        int solv2 = solution(tc2);
        Log.print(solv2);
//
//        String tc3 = "I";
//        int solv3 = solution(tc3);
//        Log.print(solv3);
//
//        String tc4 = "EIO";
//        int solv4 = solution(tc4);
//        Log.print(solv4);
    }
}