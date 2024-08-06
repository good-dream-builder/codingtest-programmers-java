package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

/**
 * 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * <p>
 * 16:15 ~ 17:59. 이어서 진행
 * 시간 분, 회차 통과
 */
public class Solution_12946 implements TestInterface {

    class Pilla {
        private int n;
        private int[] myDisc = new int[16]; // 인덱스 : 1 ~ 15 사용.

        public Pilla(int n) {
            this.n = n;
        }

        public void setAll() {
            for (int i = 1; i <= n; i++) {
                add(i);
            }
        }

        public int getDisc(int disc) {
            return myDisc[disc];
        }

        public boolean hasDisc(int disc) {
            if (myDisc[disc] > 0) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isAccept(int disc) {
            // 나보다 작은 애가 있으면 실패
            boolean check = true;
            for (int i = 1; i < disc; i++) {
                if (myDisc[i] > 0) {
                    check = false;
                }
            }
            return check;
        }

        public void remove(int disc) {
            myDisc[disc] = 0;
        }

        public void add(int disc) {
            myDisc[disc] = disc;
        }

        public int nextDisc() {
            for (int i = 1; i <= n; i++) {
                if (myDisc[i] > 0) {
                    return myDisc[i];
                }
            }
            return 0;
        }

        public boolean isDone() {
            // 1 ~ n 까지 모두가 다 존재하면 완료
            boolean check = true;
            for (int i = 1; i <= n; i++) {
                if (myDisc[i] < 1) {
                    check = false;
                    break;
                }
            }

            return check;
        }

        public boolean hasNext() {
            if (nextDisc() > 0) return true;
            return false;
        }
    }

    public void move(Pilla[] p, int from, int to, int disc) {
        if(disc == 0) {
            disc = p[from].nextDisc();
        }

        if(from == to) {
            return;
        }

        if (p[3].isDone()) {
            return;
        }

        // 이동 가능
        if (p[from].hasDisc(disc)) {
            if(p[to].isAccept(disc)) {
                // 이동
                p[from].remove(disc);
                p[to].add(disc);
                Log.print("".concat(String.valueOf(from))
                        .concat("->").concat(String.valueOf(to))
                        .concat(" : ").concat(String.valueOf(disc)));
            }
            
            move(p, from, ((to + 1) % 3 + 1), p[from].nextDisc());
        } else {

        }

        move(p, ((from + 1) % 3 + 1), to, 0);
        move(p, from, ((to + 1) % 3 + 1), p[from].nextDisc());
        move(p, ((from + 1) % 3 + 1), ((to + 1) % 3 + 1), 0);
    }

    public int[][] solution(int n) {
        Pilla[] p = new Pilla[4];
        for (int i = 0; i < 4; i++) {
            p[i] = new Pilla(n);
        }
        p[1].setAll();

        move(p, 1, 3, 0);

        int[][] answer = {};
        return answer;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        // 2 : [ [1,2], [1,3], [2,3] ]
        int tc1 = 2;

        int[][] solv1 = solution(tc1);
        Log.print(solv1);


    }
}