package main.java8; /**
 * Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
 * **/
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
class Java8_1 {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int max =  myList.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);
    }
}

/**
 * Q7 Given a String, find the first non-repeated character in it using Stream functions?
 * **/

class Java8_2 {
    public static void main(String args[]) {
        String input = "Java Hungry Blog Alive is Awesome";

        Character result = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);

        //Q8 Given a String, find the first repeated character in it using Stream functions?
        Character result2 = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);
    }
}