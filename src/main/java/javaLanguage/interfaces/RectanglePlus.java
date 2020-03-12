package javaLanguage.interfaces;

import java.awt.*;

public class RectanglePlus implements Relatable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public RectanglePlus() {
        origin = new Point(0, 0);
    }

    public RectanglePlus(Point p) {
        origin = p;
    }

    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }

    public RectanglePlus(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }

    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect
                = (RectanglePlus) other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }

    public Object findSmallest(Object object1, Object object2) {
        Relatable obj1 = (Relatable)object1;
        Relatable obj2 = (Relatable)object2;
        if ((obj1).isLargerThan(obj2) < 0)
            return object1;
        else
            return object2;
    }

    public boolean isEqual(Object object1, Object object2) {
        Relatable obj1 = (Relatable)object1;
        Relatable obj2 = (Relatable)object2;
        if ( (obj1).isLargerThan(obj2) == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        RectanglePlus obj1 = new RectanglePlus();
        obj1.move(5, 6);
        RectanglePlus obj2 = new RectanglePlus();
        int largerThan = obj1.isLargerThan(obj2);
        System.out.println(largerThan);

        RectanglePlus obj11 = new RectanglePlus();
        RectanglePlus obj22 = new RectanglePlus();
        boolean equal = obj11.isEqual(obj11, obj22);
        System.out.println("equal: " + equal);

    }
}