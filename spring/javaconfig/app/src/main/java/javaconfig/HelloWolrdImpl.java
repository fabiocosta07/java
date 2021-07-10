package javaconfig;

public class HelloWolrdImpl implements HelloWorld{
    @Override
    public void printHelloWorld(String msg) {
        System.out.println("Hello : " + msg);
    }
}
