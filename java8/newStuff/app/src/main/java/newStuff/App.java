/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package newStuff;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        /*
        * public interface Iterable<T> {

            default void forEach(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                for (T t : this) {
                    action.accept(t);
                }
            }

         * */
        List<String> list = Arrays.asList("node", "java", "ruby");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //user lambda expressions
        System.out.println("lambda expressions");
        list.forEach(str -> System.out.println(str));

        //method references
        System.out.println("method references");
        list.forEach(System.out::println);

        //streams example
        //filter
        System.out.println("Filter");
        List<String> listToFilter = Arrays.asList("spring", "node", "apolonio");

        List filtered = listToFilter.stream()
                .filter(str -> "apolonio".equals(str))
                .collect(Collectors.toList());

        filtered.forEach(System.out::println);

        //map
        System.out.println("Map");
        List<String> listToMap = Arrays.asList("a", "b", "c", "d");
        listToMap.stream().map(String::toUpperCase).forEach(System.out::println);

        //map objects to string
        System.out.println("Map objects to string");
        List<Staff> listToMapObjects = Arrays.asList(
                new Staff("ze", 0),
                new Staff("jao",0)

        );
        listToMapObjects.stream().map(stf -> {
             if ("ze".equals(stf.getName())){
                 stf.setAge(50);
             }
             return stf;
        }).forEach(System.out::println);
    }
}

class Staff {
    private String name;
    private int age;

    public Staff(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
