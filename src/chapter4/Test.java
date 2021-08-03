package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 400, Dish.Type.FISH)
        );

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering : " + dish.getName());
                            return dish.getCalories() > 300;
                        }) // filter calories
                        .map(dish -> {
                            System.out.println("mapping : " + dish.getName());
                            return dish.getName();
                        }) // get name
                        .limit(3)
                        .collect(Collectors.toList()); // result save to new list

        System.out.println(threeHighCaloricDishNames);

        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianDishes);
    }
}
