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

        return new int[0];
    }
}
