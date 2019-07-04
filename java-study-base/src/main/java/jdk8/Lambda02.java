package jdk8;

import jdk8.model.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class Lambda02 {
    public static void main(String... args) {
//        Supplier<Apple>  c1 = Apple::new;
//        Supplier<Apple>  c2 = () -> new Apple();
        /**方法引用*/
        List<Apple> inventory = Arrays.asList(
                new Apple("1", "black", 50),
                new Apple("2", "red", 45),
                new Apple("3", "yellow", 100),
                new Apple("4", "pink", 47)
        );
        //内部类实现自定义排序
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });


        //使用lambda
        inventory.sort((Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));
        inventory.sort(comparing((Apple a) -> a.getWeight()));
        inventory.sort(comparing((a) -> a.getWeight()));


        //使用方法引用
        inventory.sort(comparing(Apple::getWeight));

        /**比较器的复用*/
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        //逆序排序
        inventory.sort(comparing(Apple::getWeight).reversed());
        //比较器链
        inventory.sort(comparing(Apple::getWeight)//根据重量
                .reversed() //逆序
                .thenComparing(Apple::getColor));//根据颜色排序

        /**谓词复合*/
        Predicate<Apple> redApple = new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return false;
            }
        };
        //不是红苹果
        Predicate<Apple> notRedApple = redApple.negate();//产生现有对象redApple的非
        //是红苹果并且重量大于150
        Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);
        //是红苹果或者绿苹果并且重量大于150
        Predicate<Apple> redAndHeavyOrGreenApple =
                redApple.and(a -> a.getWeight() > 150)
                        .or(a -> "green".equals(a.getColor()));

        /**函数复用*/
        // (x+2)*1
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        Function<Integer,Integer> h = f.andThen(g); //andThen() 函数f的结果用户g 的计算 类似Linux 管道符 |
        Integer count = h.apply(5);
        System.out.println(count);

        Function<Integer,Integer> a = x -> x+1;
        Function<Integer,Integer> b = x -> x*2;
        Function<Integer,Integer> e = a.compose(b); //compose() 把函数b的结果用于a的计算
        Integer result  = e.apply(5);
        System.out.println(result);

        //用例1 发送信件流程处理
        Function<String,String> addHeader = Letter::addHeader;
        Function<String,String> letterProcess  = addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling);
        String letter = letterProcess.apply("this is my first labda letter!");
        System.out.println(letter);

    }

    public static class Letter{
        public static  String addHeader(String text){
            return "From CoderTeng:" + "\n" + text;
        }
        public static  String addFooter(String text){
            return text +  "\n" + "Your's Tom";
        }
        public static  String checkSpelling(String text){
            return text.replace("labda","lambda");
        }
    }
}
