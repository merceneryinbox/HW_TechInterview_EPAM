public class CustomInsertionSort {
    // принцип - двойной цикл внешний двигает указатель и сохраняет в темп текущию мин эл по указателю внутренний
    // цикл включается если следующий элемент меньше предыдущего и меняет их местами проверяя далее на сравнение
    // предыдущий элемент и элемент идущий перед предыдущим, меняет их если предыдущий меньше чем предпредыдущий
    int[] array;

    public CustomInsertionSort(int[] array) {
        this.array = array;
    }

    public int[] sortMeInsertion() {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                swapThem(j, j - 1);
            }
        }

        return this.array;
    }

    private void swapThem(int j, int pointerOnMin) {
        int tmpEl = array[j];
        array[j] = array[pointerOnMin];
        array[pointerOnMin] = tmpEl;
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
