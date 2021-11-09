package g14.g14_3;


import java.util.Arrays;

/**
 * Организовать сортировку массива методами Шелла, Хоара, пузырька,
 на основе бинарного дерева в разных потоках.
 */
public class Sorting {
    static int array[];



    public static void main(String[] args) {
        array = generateArray(0, 100, 50000);
        System.out.println("Start array" + Arrays.toString(array));
        int[] arrayChell = sortShell(array);
        int[] arrayHoara = sortHoara(array, 0, array.length - 1);
        int[] arrayBuble = sortBuble(array);
        int[] arrayTree = sortTree(array);
        System.out.println("Chell sort" + Arrays.toString(arrayChell));
        System.out.println("Hoara sort" + Arrays.toString(arrayHoara));
        System.out.println("Buble sort" + Arrays.toString(arrayBuble));
        System.out.println("Tree sort" + Arrays.toString(arrayTree));

    }

    private static int[] sortTree(int[] array) {
        int[] temp = new int[array.length];
        Tree tree = new Tree();
        for (int item : array) {
            tree.insert(item, item + "");
        }
        return temp;
    }

    public static int[] generateArray(int min, int max, int count) {
        int[] temp = new int[count];
        for (int i = 0; i < count; i++) {
            temp[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return temp;
    }

    public static int[] getArray() {
        return array;
    }

    /**
     * Сортировка методом Шелла
     * @param a
     * @return
     */
    public static int[] sortShell(int[] a) {
        int[] temp = copyMassiv(a);
        int n = temp.length;
        for (int step = n / 2; step > 0; step /= 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j >= 0 && temp[j] > temp[j + step] ; j -= step) {
                    int x = temp[j];
                    temp[j] = temp[j + step];
                    temp[j + step] = x;
                }
            }
        }
        return temp;
    }

    /**
     * Сортировка методом Хоара известен также как quickSort.
     * Данный метод использует вспомогательный метод  quickSort,
     * т.к. сортировка методом Хоара требует рекурсии.
     * Low и high изначально указываются как элемент с индексом 0 и
     * элемент конца списка, т.о. весь массив.
     *
     * @param array массив который подлежит сортировке
     * @param low девая граница сортировки,
     * @param high правая граница сортировки
     * @return
     */
    public static int[] sortHoara(int[] array, int low, int high) {
        int[] temp = copyMassiv(array);
        quickSort(temp, low, high);
        return temp;
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {

// Двигаем левый маркер слева направо пока элемент меньше, чем pivot

            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

// Двигаем правый маркер, пока элемент больше, чем pivot

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }

// Проверим, не нужно обменять местами элементы, на которые указывают маркеры

            if (leftMarker <= rightMarker) {

// Левый маркер будет меньше правого только если мы должны выполнить swap

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }

// Сдвигаем маркеры, чтобы получить новые границы

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


// Выполняем рекурсивно для частей

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }


    /**
     * Сортировка пузырьком
     * @param a
     * @return
     */
    public static int[] sortBuble(int[] a) {
        int[] temp = copyMassiv(a);
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < temp.length-1; i++) {
                if(temp[i] > temp[i+1]){
                    isSorted = false;
                    buf = temp[i];
                    temp[i] = temp[i+1];
                    temp[i+1] = buf;
                }
            }
        }
        return temp;
    }

    /**
     * Метод возвращает копию массива.
     * @param a
     * @return
     */
    public static int[] copyMassiv(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }
}
