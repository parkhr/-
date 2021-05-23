import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chapter2 {
    // 2.1.1 첫번째 시도: 녹색 사과 필터링
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();

        for(Apple apple: inventory){
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    // 2.1.2 두번째 시도: 색을 파라미터화
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }

        return result;
    }

    // 2.1.3 세번째 시도: 가능한 모든 속성으로 필터링
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(flag && apple.getColor().equals(color) ||
             !flag && apple.getWeight() > weight){
                result.add(apple);
            }
        }

        return result;
    }

    // 2.2.1 네번째 시도: 추상적 조건으로 필터링
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 2.3.2 다섯번째 시도: 익명 클래스 사용
        List<Apple> inventory = new ArrayList<>();

        List<Apple> result = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        // 2.3.3 여섯번째 시도: 람다 표현식 사용
        List<Apple> result2 = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        // 2.3.4 일곱번째 시도 (유연성과 간결함을 둘다 잡음 .!)
        List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        // 2.4.1 Comparator로 정렬하기
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        inventory.sort((Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor()));

        // 2.4.2 Runnable로 코드 블록 실행하기
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Hello world"));

    }

    // 2.3.4 일곱번째 시도
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }

        return result;
    }

    // 제네릭 메소드에 대해 생소하여 연습
    public static <K, T> List<K> test(T a){
        List<K> temp = new ArrayList<>();

        System.out.println(a.toString());

        return temp;
    }
}

class Apple {
    private Color color;
    private int weight;

    public Color getColor() {
        return color;
    }

    public int getWeight(){
        return weight;
    }
}