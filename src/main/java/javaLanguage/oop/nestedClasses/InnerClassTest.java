package javaLanguage.oop.nestedClasses;

public class InnerClassTest {
    public static void main(String args[]) {
        //creating local inner class inside method i.e. main()
        class Local {
            public void name() {
                System.out.println("Example of Local class in Java");

            }
        }
        //creating instance of local inner class
        Local local = new Local();
        local.name(); //calling method from local inner class

        //Creating anonymous inner class in Java for implementing thread
        Thread anonymous = new Thread(){
            @Override
            public void run(){
                System.out.println("Anonymous class example in java");
            }
        };
        anonymous.start();

        //example of creating instance of inner class
        InnerClassTest test = new InnerClassTest();
        InnerClassTest.Inner inner = test.new Inner();
        inner.name(); //calling method of inner class
    }

    //Creating Inner class in Java
    private class Inner{
        public void name(){
            System.out.println("Inner class example in java");
        }
    }
}
