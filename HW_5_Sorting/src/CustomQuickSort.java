public class CustomQuickSort {
    int[] firstIncomeArray;

    public CustomQuickSort(int[] firstIncomeArray) {
        this.firstIncomeArray = firstIncomeArray;
    }

    public void quickSort() {
        if (firstIncomeArray == null || firstIncomeArray.length < 2) {
            return;
        }
        int lo = 0;
        int hi = firstIncomeArray.length - 1;
        quickSort(lo, hi);
    }

    public void quickSort(int leftMargine, int rightMargin) {

        if (rightMargin - leftMargine < 2) {
            return;
        }
        int newLo = leftMargine;
        int newHi = rightMargin;
        int pivot = leftMargine;

        while (newHi > newLo) {
            while (firstIncomeArray[pivot] >= firstIncomeArray[newLo] && newLo < rightMargin && newHi > newLo) {
                newLo++;
            }

            while (firstIncomeArray[pivot] <= firstIncomeArray[newHi] && newHi > leftMargine && newHi > newLo) {
                newHi--;
            }
            if (newLo < newHi) {
                swap(newLo, newHi);
                newLo++;
                newHi--;
            }

            if (newHi <= newLo && firstIncomeArray[newHi] < firstIncomeArray[pivot]) {
                swap(newHi, pivot);
            }
        }

        if (newHi > leftMargine) {
            quickSort(leftMargine, newHi - 1);
        }

        if (newLo < rightMargin) {
            quickSort(newHi + 1, rightMargin);
        }
    }

    private void swap(int newLo, int newHi) {
        int i = firstIncomeArray[newLo];
        firstIncomeArray[newLo] = firstIncomeArray[newHi];
        firstIncomeArray[newHi] = i;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{12, 22, 2, 222, 21, 2, 0, 3, 32, 12, 6};
        CustomQuickSort customQuickSort = new CustomQuickSort(ar);
        customQuickSort.quickSort();
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
