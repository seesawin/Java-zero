package javaLanguage.oop.objects;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StaticInitializationBlocks {
    /**
     * This works well when the initialization value is available and the initialization can be put on one line.
     * However, this form of initialization has limitations because of its simplicity. If initialization requires some
     * logic (for example, error handling or a for loop to fill a complex array), simple assignment is inadequate.
     * Instance variables can be initialized in constructors, where error handling or other logic can be used.
     * <p>
     * To provide the same capability for class variables, the Java programming language includes static
     * initialization blocks.
     */
    private static String[] names;
    private static String namesStr;

    static {
        // whatever code is needed for initialization goes here
        names = new String[]{"a", "b", "c"};
        namesStr = Arrays.stream(names).collect(Collectors.joining());
    }

    private static void printNames() {
        Arrays.stream(names).forEach(System.out::println);
        System.out.println(namesStr);
    }

    private static String name;

    /**
     * There is an alternative to static blocks — you can write a private static method:
     */
    // The advantage of private static methods is that they can be reused later if you need to reinitialize
    // the class variable.
    private static String initializeClassVariable() {
        // initialization code goes here
        name = "test";
        return name;
    }

    public static String myVar = initializeClassVariable();

    private static String getClassVariable() {
        return name;
    }

    private static void updatedClassVariable(String name) {
        // update code goes here
        StaticInitializationBlocks.name = name;
    }

    public static void main(String[] args) {
        String s = StaticInitializationBlocks.initializeClassVariable();
        System.out.println(s);

        StaticInitializationBlocks.updatedClassVariable("go");

        s = StaticInitializationBlocks.getClassVariable();
        System.out.println(s);

        StaticInitializationBlocks.printNames();
    }
}
