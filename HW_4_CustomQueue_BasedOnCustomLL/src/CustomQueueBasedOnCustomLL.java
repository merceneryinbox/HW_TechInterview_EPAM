public class CustomQueueBasedOnCustomLL<T> {
    CustomLinkedList<T> customLinkedList = new CustomLinkedList<T>();

    public CustomQueueBasedOnCustomLL() {
    }
//    boolean offer(E e);
//    E peek();
//    E poll();
//    E remove();

    public boolean offer(T element) {
        customLinkedList.add(new CustomLinkedListNodeElement<T>(element));
        return true;
    }

    public T peek() {
        return (T) customLinkedList.getTail();
    }

    public T poll() {
        CustomLinkedListNodeElement<T> tempEl = customLinkedList.getTail();
        customLinkedList.remove(tempEl);
        return (T) tempEl;
    }

    public T remove() {
        CustomLinkedListNodeElement<T> tempEl = customLinkedList.getTail();
        customLinkedList.remove(tempEl);
        if ((T) tempEl == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) tempEl;
    }
}
