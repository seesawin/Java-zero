package javaLanguage.oop.nestedClasses;

public class ShadowTest {
    // https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}

class Problem1 {
    static class Inner {
        String s;
        void testMethod() {
            s = "Set from Inner 111";
            this.s = "Set from Inner 222";
//            Problem2.this.1 = "Set from Inner 333";
            System.out.println(s + ":" + this.s);
        }
    }

    public static void main(String[] args) {
        Problem1.Inner p = new Problem1.Inner();
        p.testMethod();
    }
}

class Problem2 {
    String s;
    class Inner {
        String s;
        void testMethod() {
            s = "Set from Inner 111";
            this.s = "Set from Inner 222";
            Problem2.this.s = "Set from Inner 333";
            System.out.println(s + ":" + this.s + ":" + Problem2.this.s );

        }
    }

    public static void main(String[] args) {
        Problem2 p3 = new Problem2();
        Inner inner = p3.new Inner();
        inner.testMethod();
    }
}

