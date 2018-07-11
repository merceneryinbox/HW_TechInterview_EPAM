public class CustomInsertionSort {
    // принцип - двойной цикл внешний двигает указатель и сохраняет в темп текущию мин эл по указателю внутренний
    // цикл включается если следующий элемент меньше предыдущего и меняет их местами проверяя далее на сравнение
    // предыдущий элемент и элемент идущий перед предыдущим, меняет их если предыдущий меньше чем предпредыдущий
    int[] array;
    int minElPointer = 0;
    int minEl;

    public CustomInsertionSort(int[] array) {
        this.array = array;
    }

    public int[] sortMeInsertion() {
        minEl = array[minElPointer];
        for (int i = 1; i < this.array.length; i++) {
            for (int j = i; j > 0 && minEl > array[j]; j--) {
                minEl = array[j];
                shiftArray(minElPointer, j);
                minElPointer = j;
                array[j] = minEl;
            }
        }

        return this.array;
    }

    private void shiftArray(int minElPointer, int j) {
        for (int i = j; i >= minElPointer; i--) {
            swap(i - 1, i);
        }
    }

    private void swap(int j, int anotherJ) {
        int tmpEl = array[j];
        array[j] = array[anotherJ];
        array[anotherJ] = tmpEl;
    }

    public static void main(String[] args) {
        int[] testAr = new int[]{23, 34, 56, 67, 2, 34, 6, 78, 9, 43, 2, 1};
        CustomInsertionSort customInsertionSort = new CustomInsertionSort(testAr);
        printAr(customInsertionSort.sortMeInsertion());
    }

    private static void printAr(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
