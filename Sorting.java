import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] array0 = {10, 3, 5, 2, 1, 7, 6, 9, 4, 8};
        int[] array1 = array0.clone();
        int[] array2 = array1.clone();
        int[] array3 = array2.clone();

        selesctionSort(array0, true);
        System.out.println(Arrays.toString(array0));


        selesctionSort(array0, false);
        System.out.println(Arrays.toString(array0));


        bubbleSort(array1, true);
        System.out.println(Arrays.toString(array1));

        bubbleSort(array1, false);
        System.out.println(Arrays.toString(array1));

        recursiveSelectionSort(array2, 0, true);
        System.out.println(Arrays.toString(array2));

        recursiveSelectionSort(array2, 0, false);
        System.out.println(Arrays.toString(array2));


        recursiveBubbleSort(array3, 0, true);
        System.out.println(Arrays.toString(array3));

        recursiveBubbleSort(array3, 0, false);
        System.out.println(Arrays.toString(array3));
    }

    public static void recursiveBubbleSort(int[] array, int currentIndex, boolean isAscending) {
        if (currentIndex == array.length - 1) {
            return;
        }

        if (isAscending) {
            for (int i = 0; i < array.length - currentIndex - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }

        } else {
            for (int i = 0; i < array.length - currentIndex - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }

        }
        recursiveBubbleSort(array, currentIndex + 1, isAscending);
    }

    public static void recursiveSelectionSort(int[] array, int currentIndex, boolean isAscending) {
        if (isAscending) {
            int min = array[currentIndex];
            int indexOfMin = currentIndex;

            for (int i = currentIndex; i < array.length; i++) {
                if (array[i] < min) {
                    indexOfMin = i;
                    min = array[i];
                }
            }

            int temp = array[indexOfMin];
            array[indexOfMin] = array[currentIndex];
            array[currentIndex] = temp;

        } else {
            int max = array[currentIndex];
            int indexOfMax = currentIndex;

            for (int i = currentIndex; i < array.length; i++) {
                if (array[i] > max) {
                    indexOfMax = i;
                    max = array[i];
                }
            }

            int temp = array[indexOfMax];
            array[indexOfMax] = array[currentIndex];
            array[currentIndex] = temp;

        }

        if (currentIndex + 1 < array.length) {
            recursiveSelectionSort(array, currentIndex + 1, isAscending);
        }
    }

    public static void bubbleSort(int[] array, boolean isAscending) {
        if (isAscending) { //{3, 2, 1, 5, 4}
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j + 1] < array[j]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }

        }
    }

    public static void selesctionSort(int[] array, boolean isAscending) {
        int min, max;

        if (isAscending) {
            for (int i = 0; i < array.length; i++) {
                min = array[i];
                int indexOfMin = i;
                for (int j = i; j < array.length; j++) {
                    if (array[j] < min) {
                        min = array[j];
                        indexOfMin = j;
                    }
                }


                int temp = array[i];
                array[i] = array[indexOfMin];
                array[indexOfMin] = temp;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                max = array[i];
                for (int j = i; j < array.length; j++) {
                    int indexOfMin = i;
                    if (array[j] > max) {
                        max = array[j];
                        indexOfMin = j;
                    }

                    int temp = array[i];
                    array[i] = array[indexOfMin];
                    array[indexOfMin] = temp;
                }
            }

        }
    }
}
