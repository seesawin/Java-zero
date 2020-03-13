package javaLanguage.inheritance.polymorphism;

public class Bicycle {
    /**
     * What You Can Do in a Subclass
     * <p>
     * A subclass inherits all of the public and protected members of its parent, no matter what package the
     * subclass is in. If the subclass is in the same package as its parent, it also inherits the
     * package-private members of the parent. You can use the inherited members as is, replace them, hide them,
     * or supplement them with new members:
     * <p>
     * 1)The inherited fields can be used directly, just like any other fields.
     * 2)You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
     * 3)You can declare new fields in the subclass that are not in the superclass.
     * 4)The inherited methods can be used directly as they are.
     * 5)You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it.
     * 6)You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
     * 7)You can declare new methods in the subclass that are not in the superclass.
     * 8)You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.
     * 9)The following sections in this lesson will expand on these topics.
     * <p>
     * Private Members in a Superclass
     * <p>
     * A subclass does not inherit the private members of its parent class. However, if the superclass has
     * public or protected methods for accessing its private fields, these can also be used by the subclass.
     * <p>
     * A nested class has access to all the private members of its enclosing class—both fields and methods.
     * Therefore, a public or protected nested class inherited by a subclass has indirect access to all of
     * the private members of the superclass.
     */
    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public void printDescription() {
        System.out.println("\nBike is " + "in gear " + this.gear
                + " with a cadence of " + this.cadence +
                " and travelling at a speed of " + this.speed + ". ");
    }

}
