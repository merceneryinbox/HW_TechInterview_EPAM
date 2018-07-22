public class CustomQuickSort {
    static class QuickSort {
        final int[] ar;

        QuickSort(int[] ar) {
            this.ar = ar;
        }

        // основная рабочая  часть выполняет разбиение
        private int partition(int arr[], int initialLeft, int initialRight) {
            int fromLeftIndex = initialLeft, fromRightIndex = initialRight;

            // получаем индекс оси посередине данного массива(для уменьшения стека вызовов)
            int pivotIndex = getPivotIndex(initialLeft, initialRight);
            // получаем сам осевой элемент для сравнения в основном цикле
            int pivotEl = arr[pivotIndex];

            // устанавливаем внешнее условие работы цикла - итерация до того момента пока указателли не встретятся
            while (fromLeftIndex <= fromRightIndex) {

                // разбегаемся слева и инкрементируем левый указатель пока элементы в массиве по левому указателю
                // меньше опорного элемента
                while (arr[fromLeftIndex] < pivotEl) {
                    fromLeftIndex++;
                }

                // как только попался элемент из массива который не меньше(т.е.м.б. и равен !) из левых
                // перескакиваем на указатель который бегает справа налево и проверяем что все элементы с правым
                // указателем больше опорного, а заодно ищем элемент справа, который меньше опорного чтобы свопнуть
                // его с левым , который больше опорного
                // (здесь заложена проверка на случай если массив отсортирован в
                // обратном
                // порядке левый указатель не будет инкрементиться бесконечно, а дойдя до оси отдаст итерацию правому
                // указателю !
                while (arr[fromRightIndex] > pivotEl) {
                    fromRightIndex--;
                }

                // найдя элемент справа, который не больше (т.е.м.б. равен!) опорного проверяем что индексы не
                // пробежали мимо друг друга и свопаем правый с левым, таким образом здесь учтён и случай когда
                // осевой элемент является равным элементу по индексу = lо но не равен hi и случай когда осевой равен
                // по индексу hi но не равен по индексу lo (например если lo элемент с самого начала оказался больше
                // чем опорный, тогда итерация продолжается справа , а справа оказались элементы все больше чем
                // опорный тогда правый укзатель не будет бежать до левого а дойдя до опорного передаст управление
                // ниже для замены первого в lo который больше чем опорный для замены их.

                if (fromLeftIndex <= fromRightIndex) {
                    swap(fromLeftIndex, fromRightIndex);
                    fromLeftIndex++;
                    fromRightIndex--;
                }

                // дальше при любом раскладе итерация продолжается слева если индексы не пересеклись после изменения
                // в последнем шаге.
            }
            return fromLeftIndex;
        }

        private int getPivotIndex(int initialLeft, int initialRight) {
            return (initialRight - initialLeft) / 2;
        }

        private void swap(int from, int to) {
            int tmp = ar[from];
            ar[from] = ar[to];
            ar[to] = tmp;
        }

        // внешняя функция управления сортировкой разбивает массив на подмоссивы, получая при этом следующий осевой
        // элемент и частично сортирую массив в ходе вычисления местоположения оси
        public void qSort(int left, int right) {

            int index = partition(ar, left, right);
            if (left < index - 2) {
                qSort(left, index - 1);
            }

            if (index + 1 < right) {
                qSort(index, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {998, 7, 8, 34, 3, 2, 1, 342, 33, 33, 3, 57, 8, 76};
        new QuickSort(ints).qSort(0, ints.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}