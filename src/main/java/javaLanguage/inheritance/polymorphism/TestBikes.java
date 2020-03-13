package javaLanguage.inheritance.polymorphism;

public class TestBikes {
    /**
     * The Java virtual machine (JVM) calls the appropriate method for the object that is referred to in each
     * variable. It does not call the method that is defined by the variable's type. This behavior is referred
     * to as virtual method invocation and demonstrates an aspect of the important polymorphism features
     * in the Java language.
     */
    public static void main(String[] args) {
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);

        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();
    }
}
