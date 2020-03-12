package javaLanguage.interfaces;

public interface Relatable {
    /**
     * this (object calling isLargerThan)
     * and other must be instances of
     * the same class returns 1, 0, -1
     * if this is greater than,
     * equal to, or less than other
     * <p>
     * All constant values defined in an interface are implicitly public, static, and final.
     * Once again, you can omit these modifiers.
     */
    public int isLargerThan(Relatable other);
}
