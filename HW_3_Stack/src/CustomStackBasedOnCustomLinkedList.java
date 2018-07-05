public class CustomStackBasedOnCustomLinkedList<T> {
    private static volatile CustomLinkedList customLinkedList = new CustomLinkedList();
    private CustomLinkedListNodeElement<T> tmpNode;
    //push, pop,  size, isEmpty O(1)

    public CustomStackBasedOnCustomLinkedList() {
    }

    public CustomStackBasedOnCustomLinkedList<T> push(T insertingElement) {
        tmpNode = new CustomLinkedListNodeElement<>(insertingElement);
        CustomLinkedListNodeElement head = customLinkedList.getHead();
        customLinkedList.addBeforePointed(tmpNode, head);
        return this;
    }

    public CustomLinkedListNodeElement<T> pop() {
        CustomLinkedListNodeElement popEl = customLinkedList.getHead();
        CustomLinkedListNodeElement secondInQueue = (CustomLinkedListNodeElement) popEl.getNextNeighbour();
        customLinkedList.setHead(secondInQueue);
        popEl.killMyNeighbours();
        return popEl;
    }

    public int size() {
        return customLinkedList.size();
    }

    public boolean isEmpty() {
        return customLinkedList.isEmpty();
    }
}
