package xyz.nullndvoid.dsa;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    Node root;

    protected class Node {
        private T val;
        private Node left, right;

        private Node(T val, Node lf, Node rt) {
            this.val = val;
            this.left = lf;
            this.right = rt;
        }

    }

    public boolean isEmpty() {
        return (this.root) == null;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T value) throws NullPointerException {
        if (value == null)
            throw new NullPointerException();

        Node node = new Node(value, null, null);

        if (this.root == null) {
            this.root = node;
            return;
        }

        insert(this.root, node);
    }

    /**
     * Inserts a `newNode` below `root`.
     *
     * @param root    The root node being targeted.
     * @param newNode The new node to be inserted.
     */
    private void insert(Node root, Node newNode) {
        if (newNode.val.compareTo(root.val) < 0) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                insert(root.left, newNode);
            }
        } else if (newNode.val.compareTo(root.val) > 0) {
            if (root.right == null) {
                root.right = newNode;
            } else {
                insert(root.right, newNode);
            }
        } else {
            // Value already in the tree.
            return;
        }
    }

    /**
     * Worst case time complexity is O(height), where the average height is
     * O(sqrt(n)).
     *
     * @param parentNode The parent node to be searched.
     * @param val        The value to look for.
     * @return Whether the value was in the tree.
     */
    public boolean search(T val) {
        return search(this.root, val) != null;
    }

    /**
     * Worst case time complexity is O(height), where the average height is
     * O(sqrt(n)).
     *
     * @param parentNode The parent node to be searched.
     * @param val        The value to look for.
     * @return Whether the value was in the tree.
     */
    private Node search(Node parentNode, T val) {
        if (parentNode == null)
            return null;

        if (parentNode.val.compareTo(val) == 0) {
            return parentNode;
        } else if (parentNode.val.compareTo(val) > 0) {
            return search(parentNode.left, val);
        }

        return search(parentNode.right, val);
    }

    public ArrayList<T> sort() {
        ArrayList<T> out = new ArrayList<>();
        return sort(out, this.root);
    }

    private ArrayList<T> sort(ArrayList<T> list, Node parent) {
        if (parent == null)
            return list;

        sort(list, parent.left);
        list.add(parent.val);
        sort(list, parent.right);

        return list;
    }
}
