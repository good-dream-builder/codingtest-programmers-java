package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

/**
 * 쿼드압축 후 개수 세기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 *
 * 2시간 36분, 2회차 통과
 */
public class Solution_68936 implements TestInterface {
    static int one = 0;
    static int zero = 0;

    public int[] solution(int[][] arr) {
        if (checkCompress(arr)) {
            if (arr[0][0] == 1) one++;
            else zero++;
        } else {
            final int halfSize = arr.length / 2;
            if (halfSize > 0) {
                int[][] a = getSector(arr, 'a');
                int[][] b = getSector(arr, 'b');
                int[][] c = getSector(arr, 'c');
                int[][] d = getSector(arr, 'd');

                solution(a);
                solution(b);
                solution(c);
                solution(d);
            }
        }


        int[] answer = {zero, one};

        return answer;
    }

    public boolean checkCompress(int[][] arr) {
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[0][0] != arr[i][j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public int[][] getSector(int[][] arr, char type) {
        final int fullSize = arr.length;
        final int halfSize = fullSize / 2;
        int[][] result = new int[halfSize][halfSize];

        int colStart = 0;
        int colEnd = 0;
        int rowStart = 0;
        int rowEnd = 0;
        if (halfSize > 0) {

            switch (type) {
                case 'a':
                    colStart = 0;
                    colEnd = halfSize;
                    rowStart = 0;
                    rowEnd = halfSize;
                    break;
                case 'b':
                    colStart = halfSize;
                    colEnd = fullSize;
                    rowStart = 0;
                    rowEnd = halfSize;
                    break;
                case 'c':
                    colStart = 0;
                    colEnd = halfSize;
                    rowStart = halfSize;
                    rowEnd = fullSize;
                    break;
                case 'd':
                    colStart = halfSize;
                    colEnd = fullSize;
                    rowStart = halfSize;
                    rowEnd = fullSize;
                    break;
            }
        }

        int colIdx = 0;
        int rowIdx = 0;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                result[rowIdx][colIdx] = arr[i][j];
                colIdx++;
            }
            colIdx = 0;
            rowIdx++;
        }

        return result;
    }

    @Override
    public void init() {
        one = 0;
        zero = 0;
    }

    @Override
    public void test() {
        init();
        int[][] tc1 = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] tc1Ans = solution(tc1);
        Log.print(tc1Ans);

        init();
        int[][] tc2 =
                {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        int[] tc2Ans = solution(tc2);
        Log.print(tc2Ans);

        init();
        int[][] tc3 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[] tc3Ans = solution(tc3);
        Log.print(tc3Ans);
    }
}