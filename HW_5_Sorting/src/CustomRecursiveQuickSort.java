public class CustomRecursiveQuickSort {
    int[] ar;
    int left;
    int right;

    public CustomRecursiveQuickSort(int[] ar) {
        this.ar = ar;
        left = 0;
        right = ar.length - 1;
    }

    public void recursiveQuickSort(int left, int right) {
        if (right - left < 2) {
            return;
        }
        int initLeft = left;
        int initRight = right;
        int pivot = left + (right - left) / 2;

        while (initLeft <= initRight) {
            while (ar[left] < ar[pivot]) {
                left++;
            }
            while (ar[right] > ar[pivot]) {
                right--;
            }

            if (left < right) {
                swap(left, right);

                if (left < right) {
                    left++;
                }

                if (right > left) {
                    right--;
                }
            }
            if (left >= right) {
                break;
            }
        }
        recursiveQuickSort(initLeft, right );
        recursiveQuickSort(right + 1 , initRight);
    }

    private int getPivotIndex(int initialLeft, int initialRight) {
        return initialRight / 2 + initialLeft / 2;
    }

    private void swap(int from, int to) {
        if (from != to) {
            int tmp = ar[from];
            ar[from] = ar[to];
            ar[to] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {
                998, 7, 8, 34, 3, 2, 1, 342
        };
        new CustomRecursiveQuickSort(ints).recursiveQuickSort(0, ints.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
