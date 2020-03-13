package javaLanguage.inheritance.polymorphism;

public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(
            int startCadence,
            int startSpeed,
            int startGear,
            String suspensionType) {
        super(startCadence,
                startSpeed,
                startGear);
        this.setSuspension(suspensionType);
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    private String suspension;

    public String getSuspension() {
        return this.suspension;
    }

    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "MountainBike has a" +
                getSuspension() + " suspension.");
    }
}
