package com.example;

import module java.base;
import module java.sql;
// import java.util.Date;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

/// The `ModuleImports` class depicts the usage of module imports declarations preview feature
/// part of Java 23. We could use module imports like 
///     - import module java.base;
///     - import module java.sql;
/// which imports a collection of packages instead of providing individual imports for each item.
/// 
/// This comment section is also an example of the new style documentation comments introduced
/// with Java 23 which uses markdown format similar to what we see in the common README.md files
/// in most repositories.

public class ModuleImports {
    public static void main(String[] args) {
        var result = groupByFirstLetter("Apple", "Orange", "Carrot", "Apricot", "Cherry");
        System.out.println(result);

        // If we import different modules which contains a class with same name, it
        // introduces ambiguity. We could avoid that by providing the direct class
        // import. In this case `import java.util.Date;`

        // Date date = new Date();
    }

    public static Map<Character, List<String>> groupByFirstLetter(String... values) {
        return Stream.of(values)
                .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
    }
}
