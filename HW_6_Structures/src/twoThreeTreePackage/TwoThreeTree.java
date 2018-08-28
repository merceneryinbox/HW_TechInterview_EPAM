package twoThreeTreePackage;

import java.util.List;

public class TwoThreeTree {
    private List<TwoThreeTreeNode> treeNodes;
    private TwoThreeTreeNode rootNode;
    private int size;

    public TwoThreeTree() {
    }

    public TwoThreeTree(List<TwoThreeTreeNode> treeNodes, TwoThreeTreeNode rootNode, int size) {
        this.treeNodes = treeNodes;
        this.rootNode = rootNode;
        this.size = size;
    }

    public List<TwoThreeTreeNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<TwoThreeTreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }

    public TwoThreeTreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TwoThreeTreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(TwoThreeTreeNode n) {
        TwoThreeTreeNode twoThreeTreeNode = searchPlaceFor(n);
    }

    private TwoThreeTreeNode searchPlaceFor(TwoThreeTreeNode n) {
        TwoThreeTreeNode nodePresentYet = null;
        TwoThreeTreeNode nodePlaceHolder = null;
        TwoThreeTreeNode isPresent = findParent(n);
        if (n.equals(this.getRootNode())) {
            return nodePresentYet;
        }


        return nodePlaceHolder;
    }

    private boolean searchPlaceFor(TwoThreeTreeNode notRootNode, TwoThreeTreeNode currentNode) {
        if (notRootNode != null) {
            Integer currentNodeKey = currentNode.getKey();
            Integer notRootNodeKey = notRootNode.getKey();

            TwoThreeTreeNode parentNode = null;
            TwoThreeTreeNode nodePresentYet = null;
            TwoThreeTreeNode leftHand = notRootNode.getLeftChildNode();
            TwoThreeTreeNode rightHand = notRootNode.getRightChildNode();

            Integer notRootNodeLeftKey = null;
            Integer notRootNodeRightKey = null;
            if (leftHand != null) {
                notRootNodeLeftKey = leftHand.getKey();
            }

            if (rightHand != null) {
                notRootNodeRightKey = rightHand.getKey();
            }

            if (notRootNode.equals(currentNode)) {
                return false;
            }

            if (notRootNodeLeftKey != null && notRootNodeRightKey != null) {
                if (currentNodeKey < notRootNodeLeftKey) {
                    searchPlaceFor(leftHand, currentNode);
                }

                if (currentNodeKey > notRootNodeRightKey) {
                    setRootNode(rightHand);
                }

                // самый простой случай когда есть место между двумя нодами левый из которых меньше текущего, а
                // правый больше текущего и когда это дванод
                if (currentNodeKey > notRootNodeLeftKey && currentNodeKey < notRootNodeRightKey) {
                    leftHand.setRightChildNode(currentNode);
                    rightHand.setLeftChildNode(currentNode);
                    currentNode.setLeftChildNode(rightHand);
                    currentNode.setRightChildNode(leftHand);

                    recursiveGrowTreeFrom(currentNode);
                }
                return true;
            }
        }
        return true;
    }

    private void recursiveGrowTreeFrom(TwoThreeTreeNode currentNode) {
        TwoThreeTreeNode newRootNode = null;

    }

    public TwoThreeTreeNode findParent(TwoThreeTreeNode n) {
        if (n.equals(rootNode)) {
            return true;
        } else if (n) {
            return false;
        }
    }

    public void remove(TwoThreeTreeNode n) {

    }

    public void checkAddedNode(TwoThreeTreeNode n) {

    }

    public void extractParentNodeOnTop(TwoThreeTreeNode threeNode) {

    }
}
