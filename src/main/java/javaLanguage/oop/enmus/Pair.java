package javaLanguage.oop.enmus;

import java.io.Serializable;

public final class Pair<L, R> implements Serializable {
    private L left;
    private R right;

    private Pair() {
    }

    public Pair(final L left, final R right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> Pair<L, R> of(final L left, final R right) {
        return new Pair(left, right);
    }


    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public void setLeft(final L left) {
        this.left = left;
    }

    public void setRight(final R right) {
        this.right = right;
    }
}
