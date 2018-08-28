package twoThreeTreePackage;

import lombok.Data;

@Data
public class TwoThreeTreeNode<V> implements Comparable<TwoThreeTreeNode> {
    Integer key;

    V currentLeftFieldValue;
    V currentRightFieldValue;
    TwoThreeTreeNode leftChildNode;
    TwoThreeTreeNode rightChildNode;
    TwoThreeTreeNode middleChildNode;

    @Override
    public int compareTo(TwoThreeTreeNode o) {
        if (o == null || !(o instanceof TwoThreeTreeNode)) {

            throw new ClassCastException("Wrong object detected");
        }
        return Integer.compare(o.getKey(), this.getKey());
    }
}
