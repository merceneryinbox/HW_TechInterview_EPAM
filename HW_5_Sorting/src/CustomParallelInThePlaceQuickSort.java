import java.util.concurrent.RecursiveTask;

public class CustomParallelInThePlaceQuickSort<T extends Comparable> extends RecursiveTask {
    private final T[] array;
    int initialLo;
    int initialHi;

    public CustomParallelInThePlaceQuickSort(T[] array) {
        this.array = array;
        initialLo = 0;
        initialHi = array.length - 1;
    }

    public CustomParallelInThePlaceQuickSort(T[] array, int initialLo, int initialHi) {
        this.array = array;
        this.initialLo = initialLo;
        this.initialHi = initialHi;
    }

    public void parallelQsort(){
        if (initialHi-initialLo < 2){
            return;
        }
        int pivot = new CustomParallelInThePlaceQuickSort<T>(array).compute();
        if (initialHi - initialLo < 7) {
            parallelQsort(initialLo, pivot);
            parallelQsort(pivot,initialHi);
            return;
        }

        parallelQsort(initialLo, pivot - 1);
        parallelQsort(pivot+1, initialHi);
    }

    private void parallelQsort(int initialLo, int initialHi) {
        if (initialHi-initialLo < 7){
            insertionSort(initialLo,initialHi);
            return;
        }
        int innerInitialLo=initialLo;
        int innerInitialRight=initialHi;
        int pivot = new CustomParallelInThePlaceQuickSort(array, innerInitialLo, innerInitialRight).compute();

        parallelQsort(innerInitialLo, pivot - 1);
        parallelQsort(pivot+1, innerInitialRight);
        return;
    }

    @Override
    protected Integer compute() {
        int left = initialLo;
        int right = initialHi;
        int pivot = initialHi/2 + initialLo/2;
        T pivotEl = array[pivot];
        while (left <= right) {
            while (array[left].compareTo(pivotEl) < 0) {
                left++;
            }
            while (array[right].compareTo(pivotEl) > 0) {
                right--;
            }
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        return initialLo;
    }

    private void insertionSort(int lo, int hi) {
        T elMin = (T) array[lo];
        int minPoint = lo;

        for (int i = lo + 1; i < hi; i++) {
            if (array[i].compareTo(elMin) > 0) {
                swap(i, minPoint);
                elMin = (T) array[i];
                minPoint = i;
                for (int j = i; j > lo; j--) {
                    if (array[j - 1].compareTo(array[j]) > 0) {
                        T tmp2 = (T) array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = (T) tmp2;
                    }
                }
            }
        }
    }

    private void swap(int i, int minPoint) {
        T temp = (T) array[i];
        array[i] = array[minPoint];
        array[minPoint] = (T) temp;
    }

    public static void main(String[] args) {
        Integer[] ints = {998, 7, 8, 34, 3, 2, 1, 342, 33, 33, 3, 57, 8, 76, 99, 77, 78, 364, 35, 23, 21, 3142, 313,
                          323, 3, 57, 8, 76, 3, 2, 1, 342, 33, 33, 3, 57, 8, 76, 99, 77, 78, 364, 35, 23, 21, 3142};
        CustomParallelInThePlaceQuickSort customParallelInThePlaceQuickSort = new CustomParallelInThePlaceQuickSort
                (ints);

        customParallelInThePlaceQuickSort.parallelQsort();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

}
