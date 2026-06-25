package org.example;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

    @Test
    public void regularMethod() {
        List<String> names = getNamesArrayList();

        int count = 0;

        for (String name: names ) {
            if (name.startsWith("A")) {
                count++;
            }
        }

        printCountResult(count);
    }

    @Test
    public void streamFilter() {

        List<String> names = getNamesArrayList();

        long count = names.stream()
                    .filter(name -> name.startsWith("A"))
                    .count();

        printCountResult( (int) count);

        // Get letter P count
        long letterPCount = Stream.of("Paul", "Peter", "Papa", "Alex", "Luke")
                .filter(name -> {
                    return name.startsWith("P");
                })
                .count();

        System.out.println("Letter P occurs: " + letterPCount + " times");


        // Print names, length > 4
        System.out.println("\nNames which length is greater than 4");
        names.stream().filter(s -> s.length() > 4).forEach(System.out::println);

        // Print only one name, length > 4
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
    }

    @Test
    public void streamMap() {

        Stream.of("Paul", "Peter", "Alex", "George", "Luke", "Solomon", "Simon")
                .filter(s -> s.endsWith("e"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private List<String> getNamesArrayList() {
        List<String> names = new ArrayList<>();

        names.add("Adam");
        names.add("George");
        names.add("Paul");
        names.add("Peter");
        names.add("Alex");
        names.add("Papa");

        return names;
    }

    private void printCountResult(int count) {
        System.out.println("Count of names that starts with A: " + count);
    }


}