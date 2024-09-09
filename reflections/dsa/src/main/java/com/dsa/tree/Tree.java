package com.dsa.tree;

/**
 * Provides APIs for interacting with tree-like data structures
 * @param <T>  type of the elements in the tree
 */
public interface Tree<T> {

    /**
     *
     * @param parentNode any node that belongs to the tree
     * @param childNode node that needs to be attached to the children of parentNode
     */
    void addChildNode(TreeNode<T> parentNode, TreeNode<T> childNode);

    /**
     *
     * @param parent containing element of the parent node
     * @param child containing element of the child node to inserted
     */
    void addChildNode(T parent, T child);
}
