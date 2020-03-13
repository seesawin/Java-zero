package javaLanguage.inheritance.abstracts;

abstract class GraphicObject {
    int x, y;

    // to provide member variables and methods that are wholly shared by all subclasses
    void moveTo(int newX, int newY) {
    }

    // that need to be implemented by all subclasses but must be implemented in different ways
    abstract void draw();

    abstract void resize();
}

class Circle extends GraphicObject {
    void draw() {
    }

    void resize() {
    }
}

class Rectangle extends GraphicObject {
    void draw() {
    }

    void resize() {
    }
}
