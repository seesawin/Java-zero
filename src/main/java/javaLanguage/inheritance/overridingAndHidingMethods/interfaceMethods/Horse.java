package javaLanguage.inheritance.overridingAndHidingMethods.interfaceMethods;

import java.math.BigDecimal;

public class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}

/**
 * Interface Methods
 * Default methods and abstract methods in interfaces are inherited like instance methods.
 * However, when the supertypes of a class or interface provide multiple default methods
 * with the same signature, the Java compiler follows inheritance rules to resolve the name conflict.
 * These rules are driven by the following two principles:
 * <p>
 * 1)Instance methods are preferred over interface default methods.
 */
class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}

interface Animal {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}

interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}

interface FireBreather extends Animal {
}

/**
 * 2)Methods that are already overridden by other candidates are ignored. This circumstance can arise
 * when supertypes share a common ancestor.
 */
class Dragon implements EggLayer, FireBreather {
    public static void main(String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}

interface OperateCar {
    default public int startEngine(String key) {
        // Implementation
        return Integer.valueOf(key);
    }
}

interface FlyCar {
    default public int startEngine(String key) {
        // Implementation
        return Integer.valueOf(key);
    }
}

/**
 * 3)If two or more independently defined default methods conflict, or a default method conflicts
 * with an abstract method, then the Java compiler produces a compiler error. You must explicitly
 * override the supertype methods.
 *
 * */
class FlyingCar implements OperateCar, FlyCar {
    // ...
    public int startEngine(String key) {
        int scale1 = new BigDecimal(key).multiply(new BigDecimal(Math.random())).scale();
        int scale2 = new BigDecimal(key).multiply(new BigDecimal(Math.random())).pow(2).scale();

        int i = FlyCar.super.startEngine(String.valueOf(scale1));
        int i1 = OperateCar.super.startEngine(String.valueOf(scale2));
        System.out.println(i);
        System.out.println(i1);
        return 0;
    }

    public int testSuperKeywords(String key) {
        int scale1 = new BigDecimal(key).multiply(new BigDecimal(Math.random())).scale();
        int scale2 = new BigDecimal(key).multiply(new BigDecimal(Math.random())).pow(2).scale();

        int i = FlyCar.super.startEngine(String.valueOf(scale1));
        int i1 = OperateCar.super.startEngine(String.valueOf(scale2));
        System.out.println(i);
        System.out.println(i1);
        return 0;
    }

    public static void main(String[] args) {
        FlyingCar fCar = new FlyingCar();
        fCar.startEngine("999");
        fCar.testSuperKeywords("1000");
    }
}