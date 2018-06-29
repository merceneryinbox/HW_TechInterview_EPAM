public class CustomLLTestMain {
    public static void main(String[] args) {
        CustomLinkedList customLinkedListNodeElements = new CustomLinkedList();
        CustomLinkedListNodeElement element = new CustomLinkedListNodeElement(99);
        System.out.println(element);
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(0));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(1));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(2));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(3));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(4));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(5));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(6));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(7));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(8));
        customLinkedListNodeElements.add(new CustomLinkedListNodeElement(9));
        customLinkedListNodeElements.stream().peek(el -> System.out.println(el)).count();
    }
}
