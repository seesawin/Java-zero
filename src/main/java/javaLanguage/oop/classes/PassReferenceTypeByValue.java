package javaLanguage.oop.classes;

public class PassReferenceTypeByValue {
    /**
     * Reference data type parameters, such as objects, are also passed into methods by value.
     * This means that when the method returns, the passed-in reference still references the same object as before.
     * However, the values of the object's fields can be changed in the method, if they have the proper access level.
     *
     * */
    public static void moveCircle(Circle circle, int deltaX, int deltaY) {
        // code to move origin of circle to x+deltaX, y+deltaY
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        // code to assign a new reference to circle
        circle = new Circle(0, 0);
    }

    public static void main(String[] args) {
        Circle c = new Circle(2, 4);
        PassReferenceTypeByValue.moveCircle(c, 5, 6);
        System.out.println(c.getX() + ":" + c.getY());
    }
}

class Circle {
    private int x;
    private int y;

    Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
