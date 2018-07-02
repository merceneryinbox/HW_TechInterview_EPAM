public class CustomLinkedListNodeElement<T extends Object> {

    private T previousNeighbour;
    private T nextNeighbour;
    private int body;

    public CustomLinkedListNodeElement() {
        this.body = 0;
        this.previousNeighbour = null;
        this.nextNeighbour = null;

    }

    CustomLinkedListNodeElement(int body) {
        this.body = body;
        this.previousNeighbour = null;
        this.nextNeighbour = null;
    }

    public CustomLinkedListNodeElement(T previousNeighbour, T nextNeighbour, int body) {
        this.body = body;
        this.previousNeighbour = previousNeighbour;
        this.nextNeighbour = nextNeighbour;
    }

    T getPreviousNeighbour() {
        return previousNeighbour;
    }

    CustomLinkedListNodeElement setPreviousNeighbour(T previousNeighbour) {
        this.previousNeighbour = previousNeighbour;
        return this;
    }

    T getNextNeighbour() {
        return nextNeighbour;
    }

    CustomLinkedListNodeElement setNextNeighbour(T nextNeighbour) {
        this.nextNeighbour = nextNeighbour;
        return this;
    }

    private int getBody() {
        return body;
    }

    public boolean lookForEqualFromNextNeighbour(CustomLinkedListNodeElement wantedNode) {
        return this.getNextNeighbour().equals(wantedNode);
    }

    public void killMyNeighbours() {
        setPreviousNeighbour(null);
        setNextNeighbour(null);
    }

    @Override
    public int hashCode() {
        return getBody() + super.hashCode() * 31 + (int) (Math.random() + 1) * Integer.MAX_VALUE % 2;
    }

    @Override
    public boolean equals(Object otherObject) {
        if ((otherObject == null) || (getClass() != otherObject.getClass()) || this != otherObject) {
            return false;
        } else {
            CustomLinkedListNodeElement tempCustom = (CustomLinkedListNodeElement) otherObject;
            return this.getPreviousNeighbour().equals(tempCustom.getPreviousNeighbour())
                    && this.getNextNeighbour().equals(tempCustom.getNextNeighbour())
                    && this.getBody() == tempCustom.getBody();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Its Custom Linked List class with double linked queue Body is = " + this.getBody();
    }

    public boolean isTail() {
        return this.getNextNeighbour() == null;
    }

    public boolean isHead() {
        return this.getPreviousNeighbour() == null;
    }
}
