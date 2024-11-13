package com.example;

/// This `Primitive` class demonstrates the usage of primtive types in switch and instanceof.
/// This is a preview feature in Java 23.

public class Primitive {
    public static void main(String[] args) {
        switchExamples();
        instanceofExamples();
    }

    private static void switchExamples() {
        var exp = 500;

        // Could use all primitives with Java 23
        var s = 1L;
        switch (s) {
            case 1L:
                System.out.println("Long 1");
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }

        // From
        var result = switch (exp) {
            case 0 -> "okay";
            case 1 -> "warning";
            case 2 -> "error";
            default -> "unknown status: " + exp;
        };
        System.out.println(result);

        // To
        result = switch (exp) {
            case 0 -> "okay";
            case 1 -> "warning";
            case 2 -> "error";
            case int i -> "unknown status: " + i;
        };
        System.out.println(result);

        // Or even
        result = switch (exp) {
            case 0 -> "okay";
            case 1 -> "warning";
            case 2 -> "error";
            case int i when i >= 100 -> "unknown status: " + i;
            case int i -> "Blah";
        };
        System.out.println(result);

        // Another one
        double value = 3.14;
        switch (value) {
            case int i -> System.out.println("value is an integer");
            case double d -> System.out.println("value is a double"); // Not possible before Java 23
            // default -> System.out.println("value is something else");
        }
    }

    static void instanceofExamples() {
        int value = 20;

        if (value instanceof byte) { // -128 to 127
            byte b = (byte) value;
            System.out.println("b = " + b);
        }

        if (value instanceof byte b) { // If true stores the value to b
            System.out.println("byte b = " + b);
        }

        if (value instanceof byte b && b > 0) { // Could use multiple conditions as well
            System.out.println("byte b > 0 and b = " + b);
        }

        value = 65;
        if (value instanceof byte b)
            System.out.println(value + " instanceof byte:   " + b);
        if (value instanceof short s)
            System.out.println(value + " instanceof short:  " + s);
        if (value instanceof int i)
            System.out.println(value + " instanceof int:    " + i);
        if (value instanceof long l)
            System.out.println(value + " instanceof long:   " + l);
        if (value instanceof float f)
            System.out.println(value + " instanceof float:  " + f);
        if (value instanceof double d)
            System.out.println(value + " instanceof double: " + d);
        if (value instanceof char c)
            System.out.println(value + " instanceof char:   " + c);
    }
}
