package com.songko;

import com.songko.common.Log;
import com.songko.common.TestInterface;

public class Solution_99999 implements TestInterface {


    public void solution(String result, String[] oprs, Boolean[] visited) {

        for (int i = 0; i < oprs.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result = result.concat(oprs[i]);

            solution(result, oprs, visited);

            if (result.length() > oprs.length - 1) {
                Log.print(result);
                visited[i] = false;
                result = result.substring(0, result.length());
                return;
            }

            visited[i] = false;
            result = result.substring(0, result.length());

        }

    }


    @Override
    public void init() {

    }

    @Override
    public void test() {
        // 60420
        String[] oprs = new String[]{"1", "2"};
        Boolean[] visited = new Boolean[oprs.length];
        for (int i = 0; i < oprs.length; i++) {
            visited[i] = false;
        }

        solution("", oprs, visited);


        // 300
//        String tc2 = "50*6-3*2";
//        long solv2 = solution(tc2);
//        Log.print(solv2);
    }
}