package javaLanguage.languageBasic.variables;

public class PrimitiveDataTypes {
    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

    final static int i0 = 0;

    // Fields that are declared but not initialized will be set to a reasonable default by the compiler
    int i1;

    public void testDefaultValue() {
        // the compiler never assigns a default value to an uninitialized local variable.
        int i2 = 0;
        System.out.println(i0 + ":" + i1 + ":" + i2);
    }

    public static void main(String[] args) {
        PrimitiveDataTypes obj = new PrimitiveDataTypes();
        obj.testDefaultValue();
    }
}
