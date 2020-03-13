package javaLanguage.inheritance.usingTheKeywordSuper;

public class Subclass extends Superclass {
    /**
     * Hiding Fields
     * Within a class, a field that has the same name as a field in the superclass hides the superclass's field,
     * even if their types are different. Within the subclass, the field in the superclass cannot be referenced
     * by its simple name. Instead, the field must be accessed through super, which is covered in the next section.
     * <p>
     * Generally speaking, we don't recommend hiding fields as it makes code difficult to read.
     */
    public int KEY = 168;

    // overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();
        System.out.println("Printed in Subclass. KEY is " + KEY);
    }

    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();
    }
}
