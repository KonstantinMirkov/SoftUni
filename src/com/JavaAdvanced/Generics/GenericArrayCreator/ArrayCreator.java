package com.JavaAdvanced.Generics.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T item) {
        return create(item.getClass(), length, item);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        IntStream.range(0, 10).forEach(i -> array[i] = item);
        return array;
    }
}
