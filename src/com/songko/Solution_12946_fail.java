package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * - 자력 해결 실패. 알고리즘 원리 확인 후 작성으로 처리.
 */
public class Solution_12946_fail implements TestInterface {

    int discNum;
    Stack<Integer>[] pillar = new Stack[3];

    public void move(int from, int to) {
        if (pillar[from].size() < 1) return;

        if (pillar[0].size() == 0 && pillar[2].size() == discNum) {
            return;
        }

        int disc = pillar[from].peek();

        int nextFrom = ((from + 1) % 3);
        int nextTo = ((to + 1) % 3);
        if (pillar[to].size() == 0 || pillar[to].peek() > disc) {
            pillar[from].pop();
            pillar[to].push(disc);

            Log.print(pillar[0].stream().collect(Collectors.toList()));
            Log.print(pillar[1].stream().collect(Collectors.toList()));
            Log.print(pillar[2].stream().collect(Collectors.toList()));
            Log.print("[" + (from + 1) + "," + (to + 1) + "] : " + disc);

            if(pillar[from].size() > 0) {
                move(from, nextTo);
            }
        }
    }

    public int[][] solution(int n) {
        discNum = n;
        pillar[0] = new Stack<>();
        pillar[1] = new Stack<>();
        pillar[2] = new Stack<>();

        // 초기화
        for (int i = n; i > 0; i--) {
            pillar[0].push(i);
        }

        int from = 0;
        int to = 1;

        while (true) {
            if (pillar[0].size() == 0 && pillar[2].size() == discNum) {
                break;
            }

            move(from, to);
            from = ((from + 1) % 3);
            to = ((to + 1) % 3);
        }


        int[][] answer = {};
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