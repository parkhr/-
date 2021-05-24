package chapter2;

// 2.2 동적 파라미터화
public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}
