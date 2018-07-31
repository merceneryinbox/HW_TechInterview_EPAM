// основное по quickSort:
// две основные части - 1) внешняя функция управления разбиением(рекурсивная),
// 2) внутренняя функция вычисления местоположения осевого элемента состоит из двух невложенных циклов в третьем
// главном цикле (главный цикл проверяет не пересеклись ли правый и левый индексы вначале цикла и внизу перед свопом
// два внутренних цикла проверяют на строгое не равно
// индекс осевого элемента выбирается как деление суммы!! двух переданных индексов пополам для уменьшения количества
// рекурсивных вызовов методов в худшем случае.
// средняя и лучшая сложность nLog(n), наихудшая при обратно отсортированном массиве n в квадрате.

/**
 * NON-RECURSIVE QUICKSORT
 */
public class CustomQuickSort {
    static class QuickSort {
        final int[] ar;

        QuickSort(int[] ar) {
            this.ar = ar;
        }

        private int partitionAndPivotCalculator(int initialLeft, int initialRight) {
            int fromLeftIndex = initialLeft;
            int fromRightIndex = initialRight;

            int pivotIndex = getPivotIndex(initialLeft, initialRight);
            int pivotEl = ar[pivotIndex];

            while (fromLeftIndex<=fromRightIndex){
                while (ar[fromLeftIndex]<ar[pivotIndex]){
                    fromLeftIndex++;
                }
                while (ar[fromRightIndex]>ar[pivotIndex]){
                    fromRightIndex--;
                }

                if (fromLeftIndex<fromRightIndex){
                    swap(fromLeftIndex,fromRightIndex);
                    fromLeftIndex++;
                    fromRightIndex--;
                }
            }
            return fromLeftIndex;
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

        public void splitRunPartitioning(int left, int right) {

            int pivot = partitionAndPivotCalculator(left, right);
            if (left < pivot - 2) {
                splitRunPartitioning(left, pivot -1);
            }

            if (pivot + 2 < right) {
                splitRunPartitioning(pivot + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        int[]
                ints =
                {
                        998,
                        7,
                        8,
                        34,
                        3,
                        2,
                        1,
                        342,
                        33,
                        33,
                        3,
                        57,
                        8,
                        76,
                        876,
                        8,
                        34,
                        3,
                        2,
                        1
                };
        new QuickSort(ints).splitRunPartitioning(0, ints.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}