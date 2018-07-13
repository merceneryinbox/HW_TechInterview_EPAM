public class CustomShellSort {
    private final int[] array;
    private int minEl;
    private int minElPointer = 0;
    private int h;

    public CustomShellSort(int[] array) {
        this.array = array;
        this.minEl = array[minElPointer];
        h = array.length / 3;
    }

    // принцип - полученный массив разбиваю на подмассивы состоящие из элементов находящихся на расстоянии H , за
    // для каждого отдельного применяю
    // сортировку вставками , после этого разбиваю массив на мньшие участки и повторяю, в последней
    // итерации отправляю полный массив в сортировку вставками.
    public static void main(String[] args) {
        int razmer = 20;
        int[] array = new int[razmer];
        for (int i = 0; i < razmer; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Начальное состояние!");
        printArray(array);

        System.out.println();
        CustomShellSort customShellSort = new CustomShellSort(array);

        System.out.println("Конечное состояние!");
        printArray(customShellSort.shellSortMePlease());
    }

    private static void printArray(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private int[] shellSortMePlease() {
        while (h >= 1) {
            minElPointer = 0;
            while (minElPointer < array.length - h) {
                minEl = array[minElPointer];
                for (int i = minElPointer + h; i < array.length; i = i + h) {
                    if (minEl > array[i]) {
                        minEl = array[i];
                        shiftArrayTo(minElPointer, i);
                        array[minElPointer] = minEl;
                    }
                }
                minElPointer = minElPointer + h;
            }
            h = h / 2;
        }
        return array;
    }

    private void shiftArrayTo(int from, int to) {
        for (int j = to; j > from; j = j - h) {
            array[j] = array[j - h];
        }
    }
}
