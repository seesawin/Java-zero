package javaLanguage.oop.objects;

public class ThisKeyWords {
}

class Point {
    public int x = 0;
    public int y = 0;

    //constructor
    public Point(int a, int b) {
        x = a;
        y = b;
    }
}

class Point2 {
    public int x = 0;
    public int y = 0;

    //constructor
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    private int x, y;
    private int width, height;

    // If present, the invocation of another constructor must be the first line in the constructor.
    public Rectangle() {
        this(0, 0, 1, 1);
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}