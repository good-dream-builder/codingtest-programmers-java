package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * <p>
 */
public class Solution_12946 implements TestInterface {

    class Roaming {
        int from;
        int to;

        public Roaming(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public void move(int n, int from, int bridge, int to, List<Roaming> result) {
        if (n == 1) {
            result.add(new Roaming(from, to));
            return;
        }

        move(n - 1, from, to, bridge, result);
        result.add(new Roaming(from, to));
        move(n - 1, bridge, from, to, result);
    }

    public int[][] solution(int n) {
        List<Roaming> result = new ArrayList<>();
        move(n, 1, 2, 3, result);

        final int row = result.size();
        int[][] answer = new int[row][2];

        for (int i = 0; i < row; i++) {
            answer[i] = new int[]{result.get(i).from, result.get(i).to};
        }

        return answer;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        // 2 : [ [1,2], [1,3], [2,3] ]
        int tc1 = 3;

        int[][] solv1 = solution(tc1);
        Log.print(solv1);


    }
}