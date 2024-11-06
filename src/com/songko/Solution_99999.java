package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

public class Solution_99999 implements TestInterface {
    String[] oprs = new String[]{"1", "2", "3"};

    public long solution() {

        for(int i =0; i < oprs.length; i++ {
            solve( 0);
        }


        long answer = 0;
        return answer;
    }

    public long solve(int opsIdx) {

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

    @Override
    public void init() {

    }

    @Override
    public void test() {
        // 60420
        long solv1 = solution();
        Log.print(solv1);

        // 300
//        String tc2 = "50*6-3*2";
//        long solv2 = solution(tc2);
//        Log.print(solv2);
    }
}