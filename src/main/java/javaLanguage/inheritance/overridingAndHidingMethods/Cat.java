package javaLanguage.inheritance.overridingAndHidingMethods;

public class Cat extends Animal {
    /**
     * Static Methods
     * If a subclass defines a static method with the same signature as a static method in the superclass,
     * then the method in the subclass hides the one in the superclass.
     *
     * The distinction between hiding a static method and overriding an instance method has important implications:
     * 1)The version of the overridden instance method that gets invoked is the one in the subclass.
     * 2)The version of the hidden static method that gets invoked depends on whether it is invoked from
     * the superclass or the subclass.
     *
     * */
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    /**
     * Instance Methods
     *
     * An instance method in a subclass with the same signature (name, plus the number and the type of
     * its parameters) and return type as an instance method in the superclass overrides
     * the superclass's method.
     *
     * */
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Animal.testClassMethod();
        Cat.testClassMethod();

        Cat myCat = new Cat();
        myCat.testInstanceMethod();
        myCat.testClassMethod();

        Animal myAnimal = myCat;
        myAnimal.testInstanceMethod();
        // Static methods in interfaces are never inherited.
        myAnimal.testClassMethod();
    }
}