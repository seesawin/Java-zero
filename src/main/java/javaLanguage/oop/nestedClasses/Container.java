package javaLanguage.oop.nestedClasses;

public class Container {
    /**
     * First to get the terms right:
     *
     * A nested class is a class which is contained in another class at the source code level.
     * It is static if you declare it with the static modifier.
     * A non-static nested class is called inner class. (I stay with non-static nested class.)
     *
     * You use static nested classes if you just want to keep your classes together if they belong
     * topically together or if the nested class is exclusively used in the enclosing class.
     * There is no semantic difference between a static nested class and every other class.
     *
     * Non-static nested classes are a different beast. Similar to anonymous inner classes, such nested
     * classes are actually closures. That means they capture their surrounding scope and their enclosing
     * instance and make that accessible. Perhaps an example will clarify that. See this stub of a Container:
     * */
    public class Item{
        Object data;
        public Container getContainer(){
            return Container.this;
        }
        public Item(Object data) {
            super();
            this.data = data;
        }

    }

    /*
    public static Item create(Object data){
        // does not compile since no instance of Container is available
        return new Item(data);
    }
    */

    public Item createSubItem(Object data){
        // compiles, since 'this' Container is available
        return new Item(data);
    }
}
