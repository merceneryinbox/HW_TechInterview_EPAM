import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList implements List<CustomLinkedListNodeElement> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
    public boolean add(CustomLinkedListNodeElement customLinkedListNodeElement) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
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
    public void add(int index, CustomLinkedListNodeElement element) {

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
