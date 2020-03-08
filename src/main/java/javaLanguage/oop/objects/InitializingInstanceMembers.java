package javaLanguage.oop.objects;

public class InitializingInstanceMembers {
    /**
     * Normally, you would put code to initialize an instance variable in a constructor.
     * There are two alternatives to using a constructor to initialize instance variables:
     * initializer blocks and final methods.
     *
     * Initializer blocks for instance variables look just like static initializer blocks,
     * but without the static keyword:
     *
     * The Java compiler copies initializer blocks into every constructor.
     * Therefore, this approach can be used to share a block of code between multiple constructors.
     *
     * */
    {
        // whatever code is needed for initialization goes here
    }

    private String myVar = initializeInstanceVariable();

    // This is especially useful if subclasses might want to reuse the initialization method.
    // The method is final because calling non-final methods during instance initialization can cause problems.
    protected final String initializeInstanceVariable() {

        // initialization code goes here
        return null;
    }
}
