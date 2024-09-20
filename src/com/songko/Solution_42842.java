package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * <p>
 */
public class Solution_42842 implements TestInterface {
    // brown은 8 이상 5,000 이하
    // yellow는 1 이상 2,000,000 이하
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        List<Integer> tempList = new ArrayList<>();
        int sum = brown + yellow;
        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) tempList.add(i);
        }

        // 0 1 2 3 4 5 6 7 : 8
        // 0 1 2 3 4 5 6 : 7
        int size = tempList.size();
        int halfSize = size / 2;
        for (int i = 0; i < halfSize; i++) {
            int x = tempList.get(size - 1 - i);
            int y = tempList.get(i);

            if ((brown == (2 * x + 2 * y - 4)) && (yellow == ((x - 2) * (y - 2)))) {
                answer = new int[]{x, y};
            }
        }

        if (answer.length == 0) {
            int x = tempList.get(halfSize);
            int y = tempList.get(halfSize);

            if ((brown == (2 * x + 2 * y - 4)) && (yellow == ((x - 2) * (y - 2)))) {
                answer = new int[]{x, y};
            }
        }

        return answer;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        int tx1 = 10, ty1 = 2;
        int[] solv1 = solution(tx1, ty1); // result :  {4, 3}
        Log.print(solv1);

        int tx2 = 8, ty2 = 1;
        int[] solv2 = solution(tx2, ty2); // result :  {3, 3}
        Log.print(solv2);

        int tx3 = 24, ty3 = 24;
        int[] solv3 = solution(tx3, ty3); // result :  {8, 6}
        Log.print(solv3);

        int tx4 = 26, ty4 = 10;
        int[] solv4 = solution(tx4, ty4); // result : {12, 3}
        Log.print(solv4);
    }
}