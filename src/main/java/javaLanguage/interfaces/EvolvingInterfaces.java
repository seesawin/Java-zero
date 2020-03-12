package javaLanguage.interfaces;

public class EvolvingInterfaces {
    public interface DoIt {
        void doSomething(int i, double x);

        int doSomethingElse(String s);

        // 2) Alternatively, you can define your new methods as default methods. The following example defines a
        // default method named didItWork:
        default boolean didItWork(int i, double x, String s) {
            // Method body
            return true;
        }
    }

    // 1) You could create a DoItPlus interface that extends DoIt:
    public interface DoItPlus extends DoIt {

        boolean didItWork(int i, double x, String s);

    }
}
