public class CustomStack<T> {
    private static volatile CustomLinkedList customLinkedList = new CustomLinkedList();
    private CustomLinkedListNodeElement tmpNode = null;
    //push, pop,  size, isEmpty O(1)

    public CustomStack() {
    }

    public CustomStack<T> push(T insertingElement) {
        tmpNode = new CustomLinkedListNodeElement(insertingElement);
        CustomLinkedListNodeElement head = customLinkedList.getHead();
        customLinkedList.addBeforePointed(tmpNode, head);
        return this;
    }

    public CustomLinkedListNodeElement<T> pop() {
        CustomLinkedListNodeElement popEl = customLinkedList.getHead();
        CustomLinkedListNodeElement secondInQueue = (CustomLinkedListNodeElement) popEl.getNextNeighbour();
        customLinkedList
        popEl.killMyNeighbours();


        return popEl;
    }
}
