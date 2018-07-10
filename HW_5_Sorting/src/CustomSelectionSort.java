public class CustomSelectionSort {
    // основная концепци - начиная с первого элемента последовательно проверяем не он ли самый маленький, если нет
    // меняем их местами меняя значение минЭл = найденного наименьшего на текущий момент, дальше продолжаем с того
    // места где остановились сравнивать с минЭл следующие при этом указатель на наименьший не изменяется до конца
    // текущего цикла, в конце цикла двигаем указатель на наименьши на 1 вправо и начиная с указательНаНаименьший +1
    // продолжаем сравнивать по индукции
    private int[] array;
    private int pointerMin;
    private int minEl;

    public CustomSelectionSort(int[] array) {
        this.array = array;
        this.minEl = this.array[this.pointerMin];
    }

    public int[] sortMePleaseSelectionWay() {
        for (int j = 0; j < this.array.length; j++) {
            this.pointerMin = j;
            minEl = this.array[this.pointerMin];
            for (int i = pointerMin + 1; i < this.array.length; i++) {
                if (minEl > this.array[i]) {
                    minEl = this.array[i];
                    swapThem(pointerMin, i);
                }
            }
        }
        return this.array;
    }

    private void swapThem(int i, int i1) {
        int tempEl = this.array[i];
        this.array[i] = this.array[i1];
        this.array[i1] = tempEl;
    }

    public static void main(String[] args) {
        int[] testAr = new int[]{23, 234, 1, 32, 3, 544, 655, 338, 8, 3, 5, 44};
        CustomSelectionSort customSelectionSort = new CustomSelectionSort(testAr);
        printAr(customSelectionSort.sortMePleaseSelectionWay());
    }

    private static void printAr(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
