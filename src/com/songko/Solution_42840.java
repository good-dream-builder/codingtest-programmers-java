package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * <p>
 */
public class Solution_42840 implements TestInterface {
    int[] student1 = {1, 2, 3, 4, 5};
    int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (student1[i % student1.length] == answers[i]) {
                score1 += 1;
            }

            if (student2[i % student2.length] == answers[i]) {
                score2 += 1;
            }

            if (student3[i % student3.length] == answers[i]) {
                score3 += 1;
            }
        }

        int max = 0;
        if (score1 > max) {
            max = score1;
        }

        if (score2 > max) {
            max = score2;
        }

        if (score3 > max) {
            max = score3;
        }

        List<Integer> temp = new ArrayList<>();
        if (score1 == max) {
            temp.add(1);
        }

        if (score2 == max) {
            temp.add(2);
        }

        if (score3 == max) {
            temp.add(3);
        }

        int[] result = temp.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        int[] test1 = {1, 2, 3, 4, 5};
        int[] solv1 = solution(test1); // result :  {1}
        Log.print(solv1);

        int[] test2 = {1, 3, 2, 4, 2};
        int[] solv2 = solution(test2); // result : {1,2,3}
        Log.print(solv2);
    }
}