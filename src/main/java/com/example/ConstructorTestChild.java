package com.example;

/// Flexible constructor bodies let you initialize fields in the same class before invoking a constructor.
/// Before this change (specifically, once it was introduced for preview in JDK 22), super(...) couldn’t 
/// be preceded by any other statements in a constructor. Since JDK 22, statements can come before 
/// super(...), making it easier to prepare, validate, and share arguments in constructors.
/// 
/// This is a second preview of this feature in Java 23

public class ConstructorTestChild extends ConstructorTestParent {
    private final int b;

    // Prior to this feature we had to do something like this to validate inputs before calling super class
    // constructor
    // public ConstructorTestChild(int a, int b) {
    //     super(verifyParamsAndReturnA(a, b));
    //     this.b = b;
    // }

    // private static int verifyParamsAndReturnA(int a, int b) {
    //     if (a < 0 || b < 0)
    //         throw new IllegalArgumentException();
    //     return a;
    // }
    // 
    // But even then the output would be 
    //      a = 1
    //      b = 0
    // since b is not initialized as we could do anything prior to super(...)

    public ConstructorTestChild(int a, int b) {
        if (a < 0 || b < 0)
            throw new IllegalArgumentException();
        this.b = b;
        super(a);
    }

    @Override
    void printMe() {
        super.printMe();
        System.out.println("b = " + b);
    }

    public static void main(String[] args) {
        new ConstructorTestChild(1, 2);
        new ConstructorTestChild(-9, 2); // Throws IllegalArgumentException since a < 0
    }
}
