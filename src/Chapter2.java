import java.util.ArrayList;
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
}

class Apple{
    private Color color;
    private int weight;

    public Color getColor() {
        return color;
    }

    public int getWeight(){
        return weight;
    }
}