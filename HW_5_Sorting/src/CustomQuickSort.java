public class CustomQuickSort {
    static class QuickSort {
        final int[] ar;

        QuickSort(int[] ar) {
            this.ar = ar;
        }


        public void qSort(int lo, int hi) {
            if (ar==null||hi-lo<2){
                return;
            }

            int initilLo = lo;
            int initialHi = hi;
            int pivot = lo;
            while (lo<=hi) {
                while (ar[pivot] >= ar[lo]) {
                    if (lo==hi&&hi==initialHi){
                        swap(pivot,lo);
                        break;
                    }
                    lo++;
                }
                while (ar[pivot] <= ar[hi]) {
                    if (lo==hi && ar[pivot] > ar[hi-1] && lo>=initilLo){
                        swap(pivot,hi-1);
                        break;
                    }
                    hi--;
                }
                if (ar[pivot] > ar[hi] && ar[pivot] < ar[lo]) {
                    swap(lo, hi);
                }

                if (lo==hi){
                    qSort(initilLo,hi-1);
                    qSort(hi+1,initialHi);
                    break;
                }
            }
        }

        private void swap(int from, int to) {
            int tmp = ar[from];
            ar[from] = ar[to];
            ar[to] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {4, 1, 44, 54, 22222, 3, 56, 7, 7, 8, 8, 9, 9, 9, 87, 6, 54};
        new QuickSort(ints).qSort(0, ints.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}