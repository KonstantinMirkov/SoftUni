package com.JavaAdvanced.Generics.Jar;

import java.util.*;

public class Jar<Type> {
    private ArrayDeque<Type> stack;

    public Jar(){
        this.stack = new ArrayDeque<>();

    }

    public void add(Type element){
        this.stack.push(element);
    }

    public Type remove(){
        return this.stack.pop();
    }
}
