package javaLanguage.oop.nestedClasses;

public class NestedClassesTest {
    /**
     * Local class:
     *  Use it if you need to create more than one instance of a class, access its constructor,
     *  or introduce a new, named type (because, for example, you need to invoke additional methods later).
     *
     * Anonymous class:
     *  Use it if you need to declare fields or additional methods.
     *
     * Lambda expression:
     *  Use it if you are encapsulating a single unit of behavior that you want to pass to other code.
     *  For example, you would use a lambda expression if you want a certain action performed on each element
     *  of a collection, when a process is completed, or when a process encounters an error.
     *
     *  Use it if you need a simple instance of a functional interface and none of the preceding criteria
     *  apply (for example, you do not need a constructor, a named type, fields, or additional methods).
     *
     * Nested class:
     *  Use it if your requirements are similar to those of a local class, you want to make the type more
     *  widely available, and you don't require access to local variables or method parameters.
     *
     * Inner class:
     *  Use a non-static nested class (or inner class) if you require access to an enclosing instance's
     *  non-public fields and methods. Use a static nested class if you don't require this access.
     * */

    // static nested classes.
    static class StaticNestedClass {
    }

    // Non-static nested classes are called inner classes.
    class InnerClass {
        private void usePrivateByOutterClass() {

        }
    }

    public void usePrivateByInnerClass() {

    }

    public static void main(String[] args) {
        NestedClassesTest.StaticNestedClass nestedObject = new NestedClassesTest.StaticNestedClass();

        NestedClassesTest outterClass = new NestedClassesTest();
        NestedClassesTest.InnerClass innerObject = outterClass.new InnerClass();
    }
}


