import java.util.ArrayList;
import java.util.List;

/**
 * Стэк на основе массива расширяемого при переполнении за счет использования резервных массивов в ArrayList для
 * уменьшения обращений к памяти при стандартной реализации с копированием старого массива в увеличенный по отношению к
 * старому новый.
 *
 * @param <T>
 */

public class StackBasedOnArray<T> {
    private T[] currentArray;
    private int currentStackPointer = 0;
    private int currentArrayIdentificator = 0;
    private List<T[]> arraysStore = new ArrayList<>(64);
    private int size;

    public StackBasedOnArray() {
        this.currentArray = (T[]) new Object[64];
        this.arraysStore.add(this.currentArray);
    }

    private int getCurrentStackPointer() {
        return currentStackPointer;
    }

    private void setCurrentStackPointer(int currentStackPointer) {
        if (currentStackPointer < 0 && this.getCurrentArrayIdentificator() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (currentStackPointer < 0 && this.getCurrentArrayIdentificator() > 0) {
            int temppointer = this.getCurrentArrayIdentificator() - 1;
            this.setCurrentArrayIdentificator(temppointer);
            this.setCurrentStackPointer(64);
        } else {
            this.currentStackPointer = currentStackPointer;
        }
    }

    private int getCurrentArrayIdentificator() {
        return currentArrayIdentificator;
    }

    private void setCurrentArrayIdentificator(int currentArrayIdentificator) {
        this.currentArrayIdentificator = currentArrayIdentificator;
    }

    public StackBasedOnArray<T> push(T insertingElement) {
        if (this.getCurrentStackPointer() >= this.currentArray.length) {
            useNextArrayFromList();
            insertIntoStack(this.getCurrentArrayIdentificator(), insertingElement);
        } else {
            insertIntoStack(currentArrayIdentificator, insertingElement);
        }
        return this;
    }

    private boolean insertIntoStack(int arrayIdentificator, T insertingElement) {
        try {
            this.arraysStore.get(arrayIdentificator)[this.getCurrentStackPointer()] = insertingElement;
            this.setCurrentStackPointer(this.currentStackPointer++);
        } catch (Exception ignore) {
            return false;
        }
        return true;
    }

    private void useNextArrayFromList() {
        this.setCurrentArrayIdentificator(this.currentArrayIdentificator++);
        this.setCurrentStackPointer(0);
    }

    public T pop() {
        T popEl = null;
        if (this.size == 0) {
            return popEl;
        } else {
            popEl = this.arraysStore.get(this.getCurrentArrayIdentificator())[this.getCurrentStackPointer()];
            this.arraysStore.get(this.getCurrentArrayIdentificator())[this.getCurrentStackPointer()] = null;
            this.setCurrentStackPointer(this.currentStackPointer--);
        }
        return popEl;
    }

    public int size() {
        int temp = this.getCurrentArrayIdentificator() + 1;
        int tempSize = 0;
        if (temp > 0) {
            tempSize = (temp - 1) * 64;
            this.size = tempSize + this.getCurrentStackPointer();
        } else {
            this.size = this.getCurrentStackPointer();
        }
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }
}
