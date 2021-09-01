package com.JavaAdvanced.Generics.CustomListSorter;

import java.util.*;

public class ModifiedList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public ModifiedList() {
        this.elements = new ArrayList<>();
    }

    public void Sort() {
      Collections.sort(this.elements);
    }

    public void add(T element) {
        elements.add(element);
    }

    public void remove(int index) {
        elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElements = this.elements.get(firstIndex);
        T secondElements = this.elements.get(secondIndex);

        this.elements.set(firstIndex, secondElements);
        this.elements.set(secondIndex, firstElements);
    }

    public int countGreaterThan(T element) {
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.elements.stream().max(Comparable::compareTo).orElseThrow();
    }

    public T getMin() {
        return this.elements.stream().min(Comparable::compareTo).orElseThrow();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
