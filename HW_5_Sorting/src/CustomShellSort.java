public class CustomShellSort {
    private final int[] array;
    private int minEl;
    private int minElPointer = 0;

    public CustomShellSort(int[] array) {
        this.array = array;
        this.minEl = array[minElPointer];
    }

    // принцип - полученный массив разбиваю на равные части , за исключением последнего разбиения, которое может быть
    // меньше чем предыдущие(при нечётном количестве элементов, или делителе) для каждого отдельного применяю
    // сортировку вставками , после этого разбиваю массив на пропорционально большие участки и повторяю, в последней
    // итерации отправляю полный массив в сортировку вставками.
    public static void main(String[] args) {
        int razmer = (int) ((Math.random() + 1) * 10000);
        int[] array = new int[razmer];
        for (int i = 0; i < razmer; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        CustomShellSort customShellSort = new CustomShellSort(array);
        printArray(customShellSort.shellSortMePlease());
    }

    private static void printArray(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private int[] shellSortMePlease() {
        int h = 20;
        for (int i = h; i < array.length && h >= 1; i = i + h) {
            if (h == 1) {
                return array;
            }
            if (minEl > array[i]) {
                minEl = array[i];
                shiftTo(minElPointer, i, h);
                array[minElPointer] = minEl;
            }
            h = h / 2;
        }
        return array;
    }

    private void shiftTo(int minElPointer, int i, int h) {
        for (int j = i; j >= minElPointer; j = j - h) {
            array[j] = array[j - h];
        }
    }
}
