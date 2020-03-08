package javaLanguage.oop.objects;

public class BicycleStaticTest {
    private int cadence;
    private int gear;
    private int speed;

    // add an instance variable for the object ID
    private int id;

    // add a class variable for the
    // number of Bicycle objects instantiated
    private static int numberOfBicycles = 0;

    /**
     * Constants
     * The static modifier, in combination with the final modifier, is also used to define constants.
     * The final modifier indicates that the value of this field cannot change.
     *
     * */
    static final double PI = 3.141592653589793;


    public BicycleStaticTest(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;

        // increment number of Bicycles
        // and assign ID number
        id = ++numberOfBicycles;
    }

    // new method to return the ID instance variable
    public int getID() {
        return id;
    }

    public static int getStaticClassVariables() {
        return numberOfBicycles;
    }

    public static void main(String[] args) {
        BicycleStaticTest obj1 = new BicycleStaticTest(1, 2, 3);
        BicycleStaticTest obj2 = new BicycleStaticTest(2, 3, 4);
        BicycleStaticTest obj3 = new BicycleStaticTest(3, 4, 5);
        System.out.println("BicycleStaticTest.numberOfBicycles: " + BicycleStaticTest.numberOfBicycles);
        System.out.println("BicycleStaticTest.numberOfBicycles: " + BicycleStaticTest.getStaticClassVariables());
        System.out.println("BicycleStaticTest.numberOfBicycles: " + obj3.getID());

        System.out.println("BicycleStaticTest.PI: " + BicycleStaticTest.PI);
    }
}
