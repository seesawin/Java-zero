package javaLanguage.languageBasic.variables;

import java.util.Arrays;

public class ArrayTest {
    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html

    public static void main(String[] args) {
        int[] array = new int[1000];
        int[] array2 = new int[1000];
        for (int j = array.length - 1; j > 0; j--) {
            array[array.length - j] = j;
            array2[array.length - j] = j;
        }

        // Searching an array for a specific value to get the index at which it is placed (the binarySearch method).
        int i = Arrays.binarySearch(array, 8000);
        System.out.println(i);

        // Comparing two arrays to determine if they are equal or not (the equals method).
        boolean equals1 = Arrays.equals(array, array2);
        System.out.println(equals1);

        // Filling an array to place a specific value at each index (the fill method).
        Arrays.fill(array, 999);

        // Sorting an array into ascending order. This can be done either sequentially, using the sort method,
        // or concurrently, using the parallelSort method introduced in Java SE 8. Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.
        Arrays.sort(array);

        Arrays.stream(array).forEach(System.out::println);

    }


}

class MultiDimArrayDemo {
    public static void main(String[] args) {
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
    }
}

class ArrayCopyDemo {
    public static void main(String[] args) {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
    }
}

class ArrayCopyOfDemo {
    public static void main(String[] args) {

        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));
    }
}