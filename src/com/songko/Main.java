package com.songko;

import java.lang.reflect.Method;

public class Main {
    public static final String PROB_NUM = "42842";

    public static void main(String[] args) {
        // 동적으로 클래스 이름을 생성
        final String className = "com.songko.Solution_".concat(String.valueOf(PROB_NUM));

        try {
            // 클래스 로드
            final Class<?> clazz = Class.forName(className);

            // 클래스 인스턴스 생성
            final Object instance = clazz.getDeclaredConstructor().newInstance();

            // test 메서드 찾기
            final Method method = clazz.getMethod("test");

            // test 메서드 실행
            method.invoke(instance);
        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없습니다: " + className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
