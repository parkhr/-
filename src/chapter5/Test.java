package chapter5;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        // distinct -> 스트림에서 만든 객체의 hashcode, equlas로 결정된다.
        List<Integer> list = numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
        System.out.println(list);

        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        // 정렬된 리스트에서 takewhile, dropwhile
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        List<Dish> memu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList());
        System.out.println(memu1);
        List<Dish> memu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(Collectors.toList());
        System.out.println(memu2);

        // 특정 열만 선택 ( sql 의 select 와 비슷 )
        List<String> dishNames = specialMenu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(dishNames);

        List<Integer> dishLengths = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(dishLengths);

        List<String> words = Arrays.asList("hello", "bye");

        List<String> unique = words.stream().map(word -> word.split(""))
                .flatMap(word -> Arrays.stream(word))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(unique);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().map(number -> number * number).collect(Collectors.toList()));

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> result = numbers1.stream()
                .flatMap(number1 -> numbers2.stream()
                        .map(number2 -> new int[]{number1, number2}))
                        .collect(Collectors.toList());
    }

}
