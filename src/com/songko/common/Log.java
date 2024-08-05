package com.songko.common;

import java.lang.reflect.Array;
import java.util.Collection;

public class Log {
    public static <T> void print(T item) {
        if (item == null) {
            System.out.println("null");
        } else if (item.getClass().isArray()) {
            printArray(item);
        } else if (item instanceof Collection) {
            printCollection((Collection<?>) item);
        } else {
            System.out.println(item.toString());
        }
    }

    private static <T> void printArray(T array) {
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            System.out.print(Array.get(array, i));
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void printCollection(Collection<?> collection) {
        for (Object element : collection) {
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.println();
    }
}
