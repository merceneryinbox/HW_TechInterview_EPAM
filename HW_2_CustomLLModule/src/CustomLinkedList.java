import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList implements List<CustomLinkedListNodeElement> {
    CustomLinkedListNodeElement[] internalArray;
    private volatile int sizeOfRealExistingElementsInList = 0;
    private volatile int commonSizeOfList;
    private volatile int nextVacantBacket;

    public int getSizeOfRealExistingElementsInList() {
        return sizeOfRealExistingElementsInList;
    }

    public int getCommonSizeOfList() {
        return commonSizeOfList;
    }

    public void setCommonSizeOfList(int commonSizeOfList) {
        this.commonSizeOfList = commonSizeOfList;
    }

    public int getNextVacantBacket() {
        return nextVacantBacket;
    }

    public void setNextVacantBacket(int nextVacantBacket) {
        this.nextVacantBacket = nextVacantBacket;
    }

    public CustomLinkedListNodeElement getTail() {
        return tail;
    }

    public void setTail(CustomLinkedListNodeElement tail) {
        this.tail = tail;
    }

    public CustomLinkedListNodeElement getHead() {
        return head;
    }

    public void setHead(CustomLinkedListNodeElement head) {
        this.head = head;
    }

    private volatile CustomLinkedListNodeElement tail;
    private volatile CustomLinkedListNodeElement head;

    public CustomLinkedList() {
        internalArray = new CustomLinkedListNodeElement[100];
        nextVacantBacket = 0;
        tail = head = internalArray[0];
        commonSizeOfList = internalArray.length;
    }

    public CustomLinkedList(CustomLinkedListNodeElement[] internalArray) {
        this.internalArray = internalArray;
        commonSizeOfList = internalArray.length;
        for (int i = 0; i < internalArray.length; i++) {
            if (!internalArray[i].equals(null)) {
                sizeOfRealExistingElementsInList++;
            }
        }
        if (internalArray.length > 0) {
            tail = internalArray[0];
            head = internalArray[sizeOfRealExistingElementsInList - 1];
        }
        nextVacantBacket = sizeOfRealExistingElementsInList + 1;
    }

    public void setSizeOfRealExistingElementsInList(int newSizeOfrealExisitingElementsInList) {
        this.sizeOfRealExistingElementsInList = newSizeOfrealExisitingElementsInList;
        nextVacantBacket = sizeOfRealExistingElementsInList + 1;
    }

    public boolean setInternalLLArray(CustomLinkedList incomeLL) {
        try {
            this.internalArray = incomeLL.internalArray;
            this.commonSizeOfList = internalArray.length;
            this.sizeOfRealExistingElementsInList = ensureNotEmptyElSize(internalArray);
            this.tail = incomeLL.tail;
            this.head = incomeLL.head;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int ensureNotEmptyElSize(CustomLinkedListNodeElement[] internalArray) {
        int result = 0;
        if (internalArray.length > 0) {
            for (int i = 0; i < internalArray.length; i++) {
                if (!internalArray[i].equals(null)) {
                    result++;
                }
            }
        }
        return result;

    }

    @Override
    public int size() {
        return sizeOfRealExistingElementsInList;
    }

    @Override
    public boolean isEmpty() {
        return sizeOfRealExistingElementsInList == 0 ? true : false;
    }

    @Override
    public boolean contains(Object anotherElement) {
        boolean result = false;

        for (int i = 0; i < internalArray.length; i++) {
            CustomLinkedListNodeElement checkingObject = (CustomLinkedListNodeElement) anotherElement;
            if (checkingObject.equals(internalArray[i])) {
                result = true;
            }
        }
        return result;
    }

    public int containsCustomLLElement(Object checkingObject) {
        int index = -1;
        for (int i = 0; i < internalArray.length; i++) {
            if (checkingObject.equals(internalArray[i])) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public Iterator<CustomLinkedListNodeElement> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(CustomLinkedListNodeElement addingNodeElement) {
        return sizeOfRealExistingElementsInList >= commonSizeOfList ? enlargeArrayTwiceAndAddElement(addingNodeElement)
                                                                    : addElementIntoTail(addingNodeElement);
    }

    private boolean addElementIntoTail(CustomLinkedListNodeElement addingNodeElement) {
        boolean result = false;
        this.internalArray[nextVacantBacket++] = addingNodeElement;
        return result;
    }

    private boolean enlargeArrayTwiceAndAddElement(CustomLinkedListNodeElement addingNodeElement) {
        boolean result = false;
        try {
            int oldSize = this.commonSizeOfList;
            int newCommonSize = oldSize * 2;
            CustomLinkedListNodeElement[] newInternalArray = new CustomLinkedListNodeElement[newCommonSize];
            for (int i = 0; i < oldSize; i++) {
                newInternalArray[i] = internalArray[i];
            }
            nextVacantBacket = newInternalArray.length;
            this.internalArray = newInternalArray;
            this.add(addingNodeElement);
            sizeOfRealExistingElementsInList = nextVacantBacket - 1;
            commonSizeOfList = newCommonSize;
            result = true;
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public boolean remove(Object otherObject) {
        boolean result = false;
        CustomLinkedListNodeElement otherElement = (CustomLinkedListNodeElement) otherObject;
        int index = containsCustomLLElement(otherElement);
        if (index >= 0 && otherElement.equals(internalArray[index])) {
            shiftNextArrayElementsIntoCurrentPosition(index);
            setSizeOfRealExistingElementsInList(--sizeOfRealExistingElementsInList);
            result = true;
        }
        return result;
    }

    private void shiftNextArrayElementsIntoCurrentPosition(int placeOfRemovingElement) {

        CustomLinkedListNodeElement[]
                tempArrayBefore =
                new CustomLinkedListNodeElement[internalArray.length - placeOfRemovingElement];
        CustomLinkedListNodeElement[]
                tempArrayAfter =
                new CustomLinkedListNodeElement[internalArray.length - placeOfRemovingElement - 1];

        for (int tempArrayPointer = 0; tempArrayPointer < placeOfRemovingElement; tempArrayPointer++) {
            tempArrayBefore[tempArrayPointer] = internalArray[tempArrayPointer];
        }
        if (placeOfRemovingElement < internalArray.length) {
            for (int tempArrayPointer = placeOfRemovingElement + 1, internalArrayPointer = tempArrayPointer + 1;
                 tempArrayPointer < internalArray.length;
                 tempArrayPointer++) {
                tempArrayAfter[tempArrayPointer] = internalArray[internalArrayPointer];
            }
        }
        for (int i = 0; i < tempArrayBefore.length; i++) {
            this.internalArray[i] = tempArrayBefore[i];
        }
        for (int i = 0; i < tempArrayAfter.length; i++, placeOfRemovingElement++) {
            this.internalArray[placeOfRemovingElement] = tempArrayAfter[i];
        }
    }

    private void insertLLElementIntoIndex(int insertionPosition, CustomLinkedListNodeElement insertingElement) {
        if (sizeOfRealExistingElementsInList + 1 > this.commonSizeOfList) {
            twiceInternalArraySize();
        }
        CustomLinkedListNodeElement[] tempArrayBeforInsertion = new CustomLinkedListNodeElement[insertionPosition];
        CustomLinkedListNodeElement[]
                tempArrayAfterInsertion =
                new CustomLinkedListNodeElement[this.internalArray.length - insertionPosition];
        int tempArrayPointer;
        int internalPointer = 0;
        for (tempArrayPointer = 0; tempArrayPointer < tempArrayBeforInsertion.length; tempArrayPointer++) {
            tempArrayBeforInsertion[tempArrayPointer] = internalArray[tempArrayPointer];
        }

        for (int indexOfAfterArray = 0, internalArrayPointer = tempArrayPointer + 1;
             indexOfAfterArray < tempArrayAfterInsertion.length;
             indexOfAfterArray++, internalArrayPointer++) {
            tempArrayAfterInsertion[indexOfAfterArray] = internalArray[internalArrayPointer];
        }
        insertingElement.setPreviousNeighbour(tempArrayBeforInsertion[tempArrayBeforInsertion.length - 1]);
        tempArrayBeforInsertion[tempArrayBeforInsertion.length - 1].setNextNeighbour(insertingElement);
        insertingElement.setNextNeighbour(tempArrayAfterInsertion[0]);
        insertingElement.setPreviousNeighbour(tempArrayBeforInsertion[tempArrayBeforInsertion.length - 1]);
        tempArrayAfterInsertion[0].setPreviousNeighbour(insertingElement);

        for (int i = 0; i < tempArrayBeforInsertion.length; i++, internalPointer++) {
            this.internalArray[i] = tempArrayBeforInsertion[i];
        }
        for (int i = 1; i < this.internalArray.length; i++, internalPointer++) {
            this.internalArray[internalPointer] = tempArrayAfterInsertion[i];
        }
        this.internalArray[insertionPosition] = insertingElement;
    }

    private boolean twiceInternalArraySize() {
        boolean result = false;
        CustomLinkedListNodeElement[]
                newDoubledCustomNodeArray =
                new CustomLinkedListNodeElement[this.internalArray.length * 2];
        for (int i = 0; i < this.internalArray.length; i++) {
            newDoubledCustomNodeArray[i] = this.internalArray[i];
        }
        for (int i = 0; i < this.internalArray.length; i++) {
            newDoubledCustomNodeArray[i] = this.internalArray[i];
        }
        this.internalArray = newDoubledCustomNodeArray;
        result = true;
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends CustomLinkedListNodeElement> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends CustomLinkedListNodeElement> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public CustomLinkedListNodeElement get(int index) {
        return null;
    }

    @Override
    public CustomLinkedListNodeElement set(int index, CustomLinkedListNodeElement element) {
        return null;
    }

    @Override
    public void add(int index, CustomLinkedListNodeElement insertingElement) {
        if (index >= size() || index <= 0) {
            System.out.println("Here can be placed out of bound array exception.");
        }
        insertLLElementIntoIndex(index, insertingElement);
    }

    @Override
    public CustomLinkedListNodeElement remove(int index) {

        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<CustomLinkedListNodeElement> listIterator() {
        return null;
    }

    @Override
    public ListIterator<CustomLinkedListNodeElement> listIterator(int index) {
        return null;
    }

    @Override
    public List<CustomLinkedListNodeElement> subList(int fromIndex, int toIndex) {
        return null;
    }
}
