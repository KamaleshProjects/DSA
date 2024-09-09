package com.dsa.tree;

import com.dsa.vec.Vec;

/**
 * representation of a n-ary tree node with node contains an element and holds an arbitrary 'n' no of children
 * @param <T> type of the elements in the tree node
 */
public class TreeNode<T> {

    /**
     * a treenode without a containing element is pointless
     */
    private TreeNode() {

    }

    /**
     *
     * @param element containing element of the tree node
     */
    public TreeNode(T element) {
        this.element = element;
    }

    /**
     *
     * @param element containing element of the tree node
     * @param children children of the tree node
     */
    public TreeNode(T element, Vec<TreeNode<T>> children) {
        this.element = element;
        this.children = children;
    }

    private T element;
    private Vec<TreeNode<T>> children;

    /**
     *
     * @return the containing element of the tree node
     */
    public T getElement() {
        return this.element;
    }

    /**
     *
     * @return the children of the tree node
     */
    public Vec<TreeNode<T>> getChildren() {
        return this.children;
    }
}
