public class CustomInsertionSort {
    // принцип - двойной цикл внешний двигает указатель и сохраняет в темп текущию мин эл по указателю внутренний
    // цикл включается если следующий элемент меньше предыдущего и меняет их местами проверяя далее на сравнение
    // предыдущий элемент и элемент идущий перед предыдущим, меняет их если предыдущий меньше чем предпредыдущий
    private int[] array;
    private int minElPointer = 0;
    private int minEl;

    public CustomInsertionSort(int[] array) {
        this.array = array;
    }

    public int[] sortMeInsertion() {
        minEl = array[minElPointer];
        while (minElPointer < array.length) {
            minEl = array[minElPointer];
            for (int i = minElPointer + 1; i < this.array.length; i++) {
                if (minEl > array[i]) {
                    minEl = array[i];
                    shiftArray(minElPointer, i);
                    array[minElPointer] = minEl;
                }
            }
            minElPointer++;
        }
        return this.array;
    }

    private void shiftArray(int from, int to) {
        for (int i = to; i > from; i--) {
            array[i] = array[i - 1];
        }
    }


    public static void main(String[] args) {
        int[] testAr = new int[]{23, 34, 5, 67, 2, 34, 1};
        CustomInsertionSort customInsertionSort = new CustomInsertionSort(testAr);
        printAr(customInsertionSort.sortMeInsertion());
    }

    private static void printAr(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
