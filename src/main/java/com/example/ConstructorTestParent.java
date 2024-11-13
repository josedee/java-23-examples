package com.example;

public class ConstructorTestParent {
    private final int a;

    public ConstructorTestParent(int a) {
        this.a = a;
        printMe();
    }

    void printMe() {
        System.out.println("a = " + a);
    }
}
