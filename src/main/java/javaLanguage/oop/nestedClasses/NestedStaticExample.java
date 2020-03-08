package javaLanguage.oop.nestedClasses;

public class NestedStaticExample {
    /**
     * Difference between Inner class and nested static class in Java.
     *
     * Both static and non static nested class or Inner needs to declare inside enclosing class in Java
     * and that’s why they are collectively known as nested classes  but they have couple of differences
     * as shown below:
     *
     * 1) First and most important difference between Inner class and nested static class is
     * that Inner class require instance of outer class for initialization and they are always associated
     * with instance of enclosing class. On the other hand nested static class is not associated w
     * ith any instance of enclosing class.
     *
     * 2) Another difference between Inner class and nested static class is that later uses static keyword
     * in there class declaration, which means they are static member of class and can be accessed like any other
     * static member of class.
     *
     * 3) Nested static class can be imported using static import in Java.
     *
     * 4) One last difference between Inner class and nested static class is that later is more convenient
     * and should be preferred over Inner class while declaring member classes.
     *
     *
     * Nested static, Inner and Anonymous class in Java
     *
     * That's all on What is Inner class and nested static class in Java. We have seen local, anonymous and
     * member inner classes and difference between Inner class and nested static class in Java.
     * Worth noting is where to use nested static class or Inner class ? Joshua Bloch has suggested to prefer
     * nested static class over Inner classes in his book Effective Java.
     *
     * Some time Interviewer ask you to write code to create instance of inner class which can be tricky if you haven't
     * used them recently. Just remember that every inner class instance is associated with one outer class instance.
     *
     *
     * Read more: https://javarevisited.blogspot.com/2012/12/inner-class-and-nested-static-class-in-java-difference.html#ixzz6G4Eg1Ixe
     * */
    public static void main(String args[]){
        StaticNested nested = new StaticNested();
        nested.name();
    }
    //static nested class in java
    private static class StaticNested{
        public void name(){
            System.out.println("static nested class example in java");
        }
    }
}
