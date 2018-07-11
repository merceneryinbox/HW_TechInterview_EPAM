public class CustomShellSort {
    private final int[] array;

    public CustomShellSort(int[] array) {
        this.array = array;
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
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private int[] shellSortMePlease() {
        int h = 20;
        for (int i = h; i < array.length && h >= 1; i = i + h) {
            if (h == 1) {
                break;
            }
            if (array[i - h] > array[i]) {
                swap(i, i - h);
                for (int j = i - h; j > 0; j = j - h) {
                    if (array[j - h] > array[j]) {
                        swap(j, j - h);
                    }

                }
            }
            h = h / 2;
        }
        return array;
    }

    private void swap(int j, int i) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
