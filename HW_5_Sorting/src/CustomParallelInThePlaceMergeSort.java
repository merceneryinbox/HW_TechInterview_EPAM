import java.util.concurrent.RecursiveAction;

public class CustomParallelInThePlaceMergeSort<T extends Comparable> {
    private final T[] array;

    public CustomParallelInThePlaceMergeSort(T[] array) {
        this.array = array;
    }

    class InnerFJPAction extends RecursiveAction {
        int lo;
        int hi;
        int middle;

        public InnerFJPAction(int lo, int hi, int middle) {
            this.lo = lo;
            this.hi = hi;
            this.middle = middle;
        }

        @Override
        protected void compute() {
            if (hi - lo <= 100) {
                insertionSort(lo, hi);
                return;
            } else {
                InnerFJPAction fjpAction1 = new InnerFJPAction(lo, middle, (middle - lo) / 2);
                InnerFJPAction fjpAction2 = new InnerFJPAction(middle + 1, (hi - middle) / 2, hi);
                invokeAll(fjpAction1, fjpAction2);
            }

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
    }
}
