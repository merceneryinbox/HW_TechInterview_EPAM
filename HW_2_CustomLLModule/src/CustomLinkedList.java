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

    private synchronized CustomLinkedList setTail(CustomLinkedListNodeElement tailCandidate) {
        if (tailCandidate != null) {
            CustomLinkedListNodeElement realTail = this.getTail();
            realTail.setNextNeighbour(tailCandidate);
            tailCandidate.setPreviousNeighbour(realTail);
            tailCandidate.setNextNeighbour(null);
        }
        return this;
    }

    private synchronized CustomLinkedList setHead(CustomLinkedListNodeElement headCandidate) {
        if (headCandidate != null) {
            headCandidate.setPreviousNeighbour(null);
            CustomLinkedListNodeElement realHead = this.head;
            headCandidate.setNextNeighbour(realHead);
            realHead.setPreviousNeighbour(headCandidate);
            this.head = headCandidate;
        }
        return this;
    }

    public synchronized CustomLinkedListNodeElement getTail() {
        return this.tail;
    }

    public synchronized CustomLinkedListNodeElement getHead() {
        return this.head;
    }

    public synchronized boolean addAfterPointed(CustomLinkedListNodeElement addingAfterElement,
                                                CustomLinkedListNodeElement pointedElement) {
        boolean result = false;
        if (this.contains(pointedElement)) {
            CustomLinkedListNodeElement findedPointed = this.findPointed(pointedElement);
            try {
                if (!findedPointed.isTail()) { // before tail
                    CustomLinkedListNodeElement
                            nextFromPointed =
                            (CustomLinkedListNodeElement) pointedElement.getNextNeighbour();
                    pointedElement.setNextNeighbour(addingAfterElement); // set inserting element as next(after) for
                    // pointed
                    addingAfterElement.setPreviousNeighbour(pointedElement); // set pointed
                    // element as
                    // previous for inserting

                    nextFromPointed.setPreviousNeighbour(addingAfterElement);//set inserting as previous for element
                    // that
                    // stands after pointed
                    addingAfterElement.setNextNeighbour(nextFromPointed);// set next after pointed as next for inserting
                    result = true;
                } else if (pointedElement.isTail()) {
                    this.setTail(addingAfterElement);
                    result = true;
                }
                this.sizeOfRealExistingElementsInList.incrementAndGet();
                result = true;
            } catch (Exception e) {
                return result;
            }
        }
        return result;
    }

    public synchronized boolean addBeforePointed(CustomLinkedListNodeElement addingBeforeElement,
                                                 CustomLinkedListNodeElement pointedElement) {
        boolean result = false;
        CustomLinkedListNodeElement pointedFinded = findPointed(pointedElement);

        if (pointedFinded != null) {
            try {
                if (!pointedElement.isHead()) { // if not head
                    CustomLinkedListNodeElement
                            previouseFromPointed =
                            (CustomLinkedListNodeElement) pointedFinded.getPreviousNeighbour();
                    pointedFinded.setPreviousNeighbour(addingBeforeElement);
                    previouseFromPointed.setNextNeighbour(addingBeforeElement);
                    addingBeforeElement.setNextNeighbour(pointedFinded);
                    addingBeforeElement.setPreviousNeighbour(previouseFromPointed);
                } else if (pointedFinded.isHead()) {
                    this.setHead(addingBeforeElement);
                }
                this.sizeOfRealExistingElementsInList.incrementAndGet();
                result = true;
            } catch (Exception e) {
                return result;
            }
        }
        return result;
    }

    public synchronized boolean add(CustomLinkedListNodeElement addingNodeElement) {
        boolean result = false;
        try {
            CustomLinkedListNodeElement tempTail = this.getTail();
            this.getTail().setNextNeighbour(addingNodeElement);
            this.setTail(addingNodeElement);
            this.sizeOfRealExistingElementsInList.incrementAndGet();
            addingNodeElement.setPreviousNeighbour(tempTail);
            addingNodeElement.setPreviousNeighbour(tempTail).setNextNeighbour(null);
            result = true;
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    private synchronized CustomLinkedListNodeElement findPointed(CustomLinkedListNodeElement pointedElement) {
        CustomLinkedListNodeElement result = null;
        if (pointedElement != null) {
            do {// берём голову и проверяем на равенство, если она не равна тогда берём её следующего соседа и проверяем
                // его на равенство, если нет берём его соседасоседа... - while
                CustomLinkedListNodeElement
                        nextNeighbour =
                        (CustomLinkedListNodeElement) pointedElement.getNextNeighbour();
                if (pointedElement.equals(nextNeighbour)) {
                    result = nextNeighbour;
                    break;
                } else {
                    findPointed(nextNeighbour);
                }
            } while (pointedElement.getNextNeighbour() != null);
        }
        return result;
    }

    @Override
    public synchronized int size() {
        return sizeOfRealExistingElementsInList.get();
    }

    @Override
    public synchronized boolean isEmpty() {
        return sizeOfRealExistingElementsInList.get() == 0;
    }

    @Override
    public synchronized boolean contains(Object anotherElement) {
        return this.findPointed((CustomLinkedListNodeElement) anotherElement) == null;

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
    public synchronized boolean remove(Object otherObject) {
        boolean result = false;
        CustomLinkedListNodeElement tmpOtherObject = (CustomLinkedListNodeElement) otherObject;
        try {
            if (this.contains(tmpOtherObject)) {
                if (((tmpOtherObject.isTail() == false) && (tmpOtherObject.isHead() == false))) {
                    CustomLinkedListNodeElement tempDeletingElement = this.findPointed(tmpOtherObject);
                    CustomLinkedListNodeElement
                            previousFromPointed =
                            (CustomLinkedListNodeElement) tempDeletingElement.getPreviousNeighbour();
                    CustomLinkedListNodeElement
                            nextFromPointed =
                            (CustomLinkedListNodeElement) tempDeletingElement.getNextNeighbour();
                    previousFromPointed.setNextNeighbour(nextFromPointed);
                    nextFromPointed.setPreviousNeighbour(previousFromPointed);
                    result = true;
                } else if (tmpOtherObject.isHead()) {
                    CustomLinkedListNodeElement
                            nextOfhead =
                            (CustomLinkedListNodeElement) tmpOtherObject.getNextNeighbour();
                    this.setHead(nextOfhead);
                    tmpOtherObject.killMyNeighbours(); // flipping edges
                    result = true;
                } else if (tmpOtherObject.isTail()) {
                    CustomLinkedListNodeElement
                            previousOfTail =
                            (CustomLinkedListNodeElement) tmpOtherObject.getPreviousNeighbour();
                    this.setTail(previousOfTail);
                    tmpOtherObject.killMyNeighbours(); // flipping edges
                    result = true;
                }
            }
        } catch (Exception ignore) {
            return result;
        }
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
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized void clear() {
        this.setTail(null).setHead(null).sizeOfRealExistingElementsInList = new AtomicInteger(0);
    }
}
