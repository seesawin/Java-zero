package javaLanguage.oop.classes;

public class PassPrimitiveByValue {
    /**
     * Primitive arguments, such as an int or a double, are passed into methods by value.
     * This means that any changes to the values of the parameters exist only within the scope of the method.
     * When the method returns, the parameters are gone and any changes to them are lost. Here is an example:
     *
     * */
    public static void main(String[] args) {

        int x = 3;

        // invoke passMethod() with
        // x as argument
        passMethod(x);

        // print x to see if its
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);

        Person p = new Person(5);
        passMethod(p);
        System.out.println("After invoking passMethod, age = " + p.getAge());


    }

    // change parameter in passMethod()
    public static void passMethod(int p) {
        p = 10;
    }

    public static void passMethod(Integer p) {
        p = 10;
    }

    // change object
    public static void passMethod(Person p) {
        p.setAge(99);
    }


}

class Person {
    private int age;

    Person(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}