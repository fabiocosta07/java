package newStuff.functional;

import java.util.function.Function;

public class App {
    public static void main(String [] args) {
        exampleSimple();
        exampleChain();
    }
    public static void exampleSimple(){
        Function<String, Integer> func = x -> x.length();
        Integer apply = func.apply("test");
        System.out.println(apply);
    }
    public static void exampleChain(){
        Function<String, Integer> func = x -> x.length();
        Function<Integer, Integer> func2 = x -> x* 2;
        Integer apply = func.andThen(func2).apply("test");
        System.out.println(apply);

    }
}
