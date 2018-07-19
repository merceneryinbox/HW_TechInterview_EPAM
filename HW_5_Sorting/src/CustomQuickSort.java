public class CustomQuickSort {
    int[] firstIncomeArray;

    public CustomQuickSort(int[] firstIncomeArray) {
        this.firstIncomeArray = firstIncomeArray;
    }

    public void quickSort(int[] firstInAr) {
        if (firstInAr == null || firstInAr.length < 2) {
            return;
        }
        int lo = 0;
        int hi = firstInAr.length - 1;
        int pivot = lo;
        quickSort(lo, pivot);
        quickSort(pivot + 1, hi);
    }

    public void quickSort(int leftMargine, int rightMargin) {

        if (rightMargin-leftMargine<2){
            return;
        }
        int newLo = leftMargine;
        int newHi = rightMargin;
        int pivot = leftMargine;


        if (newHi>leftMargine){
            quickSort(leftMargine,newHi - 1);
        }

        if (newLo<rightMargin){
            quickSort(newHi+1,rightMargin);
        }
    }
}
