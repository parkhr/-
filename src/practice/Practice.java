package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice {

    public static void main(String[] args) throws Exception {
        Predicate<Integer> predicate = (num) -> num > 10;

        System.out.println(predicate.test(15));

        Consumer<String> consumer = System.out::println;
        consumer.accept("hello");

        Supplier<String> supplier = () -> "hello";

        System.out.println(supplier.get());

        Function<String, Integer> function = Integer::parseInt;
        System.out.println(function.apply("1455"));

        Comparator<Integer> comparator = (num1, num2) -> {
            if(num1 > num2) return 1;
            else if(num1 < num2) return -1;
            else return 0;
        };
        System.out.println(comparator.compare(1,2));

        Runnable runnable = () -> System.out.println("실핼만");
        runnable.run();

        Callable<String> callable = () -> "hello";
        System.out.println(callable.call());
    }
}
