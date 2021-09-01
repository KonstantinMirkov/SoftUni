package com.JavaAdvanced.Generics.ListUtilities;

import java.util.*;

public class ListUtils<T> {
    public static <T extends Comparable<T>> T getMin(List<T> list) throws IllegalArgumentException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else {
            return Collections.min(list);
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) throws IllegalArgumentException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else {
            return Collections.max(list);
        }
    }
}
