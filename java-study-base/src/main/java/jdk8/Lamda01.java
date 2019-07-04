package jdk8;

import jdk8.model.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/***
 * lambda 表达式语法
 * 基本语法 (parameters) -> expression  或 (parameters) -> {statements;}
 */
public class Lamda01 {
    public static void main(String... args) {
        /**简单的lambda 实例 1*/
        System.out.println("dfsdf");
        List<Apple> inventory = Arrays.asList(
                new Apple("1", "black", 50),
                new Apple("2", "red", 45),
                new Apple("3", "yellow", 100),
                new Apple("4", "pink", 47)
        );

        List result = filter(inventory,(Apple a) -> "red".equals(a.getColor()));
        System.out.println(result.listIterator().next());

        /**简单的lambda 实例 2*/

    }

    /***
     * 普通Apple筛选
     * @param inventory
     * @param predicate
     * @return
     */
    public static List filter(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;

    }

    /**
     * 超级筛选
     * @param inventory
     * @param predicate
     * @param <T>
     * @return
     */
    public static<T> List filterSuper(List<T> inventory, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T o : inventory) {
            if (predicate.test(o)) {
                result.add(o);
            }
        }
        return result;

    }


    /**
     * lambda 运用场景01
     * @return
     * @throws IOException
     */
    public static Stream<String> processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.lines();
        }
    }
}
