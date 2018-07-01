import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomLinkedList implements Collection<CustomLinkedListNodeElement> {
    private volatile AtomicInteger sizeOfRealExistingElementsInList = new AtomicInteger(0);
    //    private volatile int commonSizeOfList;
//    private volatile int nextVacantBacket;
    private volatile CustomLinkedListNodeElement tail;
    private volatile CustomLinkedListNodeElement head;

    //    public void setNextVacantBacketIndex(int nextVacantBacketIndex) {
    CustomLinkedList() {
        this.tail = this.head = null;
        this.sizeOfRealExistingElementsInList = new AtomicInteger(0);
        setTail(tail);
        setHead(head);

    }

    private CustomLinkedList setTail(CustomLinkedListNodeElement tail) {
        if (tail.getNextNeighbour().equals(null)) {
            this.tail = tail;
        }
        return this;
    }

    //    }
    public CustomLinkedListNodeElement getTail() {
        return tail;
    }

    //        this.nextVacantBacketIndex = nextVacantBacketIndex;

    public int getSizeOfRealExistingElementsInList() {
        return sizeOfRealExistingElementsInList.get();
    }

    public CustomLinkedListNodeElement getHead() {
        return head;
    }

    private CustomLinkedList setHead(CustomLinkedListNodeElement head) {
        if (head.getPreviousNeighbour().equals(null)) {
            this.head = head;
        }
        return this;
    }

    public boolean addAfterPointed(CustomLinkedListNodeElement addingAfterElement,
                                   CustomLinkedListNodeElement poinedElement) {
        boolean result = false;
        try {
            if ((poinedElement != null) && contains(poinedElement)) {
                CustomLinkedListNodeElement
                        nextFromPointed =
                        (CustomLinkedListNodeElement) poinedElement.getNextNeighbour();
                poinedElement.setNextNeighbour(addingAfterElement);
                nextFromPointed.setPreviousNeighbour(addingAfterElement);
            }
            this.sizeOfRealExistingElementsInList.incrementAndGet();
            result = true;
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    public boolean addBeforePointed(CustomLinkedListNodeElement addingBeforeElement,
                                    CustomLinkedListNodeElement poinedElement) {
        boolean result = false;
        try {
            if ((poinedElement != null) && contains(poinedElement)) {
                CustomLinkedListNodeElement
                        previouseFromPointed =
                        (CustomLinkedListNodeElement) poinedElement.getNextNeighbour();
                poinedElement.setNextNeighbour(addingBeforeElement);
                previouseFromPointed.setNextNeighbour(addingBeforeElement);
            }
            this.sizeOfRealExistingElementsInList.incrementAndGet();
            result = true;
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    public boolean add(CustomLinkedListNodeElement addingNodeElement) {
        boolean result = false;
        try {
            CustomLinkedListNodeElement tempTail = this.getTail();
            this.getTail().setNextNeighbour(addingNodeElement);
            addingNodeElement.setPreviousNeighbour(tempTail).setNextNeighbour(null);
            this.setTail(addingNodeElement);
            this.sizeOfRealExistingElementsInList.incrementAndGet();
            result = true;
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    @Override
    public int size() {
        return sizeOfRealExistingElementsInList.get();
    }

    @Override
    public boolean isEmpty() {
        return sizeOfRealExistingElementsInList.get() == 0;
    }

    @Override
    public boolean contains(Object anotherElement) {
        boolean result = false;
        try {
            CustomLinkedListNodeElement wantedElement = (CustomLinkedListNodeElement) anotherElement;
            if (anotherElement != null) {
                result = isPresentRecursiveApproach(wantedElement, this.getHead());
            }
        } catch (Exception ignore) {
            return result;
        }
        return result;
    }

    private boolean isPresentRecursiveApproach(CustomLinkedListNodeElement wantedElement,
                                               CustomLinkedListNodeElement tempHead) {
        boolean result = false;
        if (wantedElement == null) {
            return result;
        }
        try {
            do {// берём голову и проверяем на равенство, если она не равна тогда берём её следующего соседа и проверяем
                // его на равенство, если нет берём его соседасоседа... - while
                CustomLinkedListNodeElement nextNeighbour = (CustomLinkedListNodeElement) tempHead.getNextNeighbour();
                if (wantedElement.equals(nextNeighbour)) {
                    result = true;
                    break;
                } else {
                    isPresentRecursiveApproach(wantedElement, nextNeighbour);
                }
            } while (tempHead.getNextNeighbour() != null);
        } catch (Exception ignore) {
            return result;
        }
        return result;
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

    private boolean addElementIntoTail(CustomLinkedListNodeElement addingNodeElement) {
        boolean result = false;
        return result;
    }

    @Override
    public boolean remove(Object otherObject) {
        return false;
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
}
