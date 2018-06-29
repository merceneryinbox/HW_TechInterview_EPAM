public class CustomLinkedListNodeElement<T extends Object> {

    private T previousNeighbour;
    private T nextNeighbour;
    private int body;

    public CustomLinkedListNodeElement(int body) {
        this.body = body;
    }

    public CustomLinkedListNodeElement(T previousNeighbour, T nextNeighbour, int body) {
        this.previousNeighbour = previousNeighbour;
        this.nextNeighbour = nextNeighbour;
        this.body = body;
    }

    public T getPreviousNeighbour() {
        return previousNeighbour;
    }

    public void setPreviousNeighbour(T previousNeighbour) {
        this.previousNeighbour = previousNeighbour;
    }

    public T getNextNeighbour() {
        return nextNeighbour;
    }

    public void setNextNeighbour(T nextNeighbour) {
        this.nextNeighbour = nextNeighbour;
    }

    public int getBody() {
        return body;
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
}
