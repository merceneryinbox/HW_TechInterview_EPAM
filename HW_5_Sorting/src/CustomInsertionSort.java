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
        for (int i = 1; i < this.array.length; i++) {
            if (minEl > array[i]) {
                minEl = array[i];
                shiftArray(minElPointer, i);
                array[i] = minEl;
            }
        }
        return this.array;
    }

    private void shiftArray(int minElPointer, int j) {
        for (int i = j; i >= minElPointer; i--) {
            array[i] = array[i - 1];
        }
    }


    public static void main(String[] args) {
        int[] testAr = new int[]{23, 34, 56, 67, 2, 34, 6, 78, 9, 43, 2, 1};
        CustomInsertionSort customInsertionSort = new CustomInsertionSort(testAr);
        printAr(customInsertionSort.sortMeInsertion());
    }

    private static void printAr(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
