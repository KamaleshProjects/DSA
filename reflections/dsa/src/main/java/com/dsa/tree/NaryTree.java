package com.dsa.tree;

import java.util.Optional;

/**
 * Provides an implementation for a {@link Tree} with support for any node to have 'n' no of children
 * @param <T>
 */
public class NaryTree<T> implements Tree<T> {

    private TreeNode<T> rootNode;

    /**
     *
     * @param root rootNode for initializing the tree
     */
    public NaryTree(T root) {
        this.rootNode = new TreeNode<>(root);
    }

    /**
     *
     * @param rootNode root for initializing the tree
     */
    public NaryTree(TreeNode<T> rootNode) {
        this.rootNode = rootNode;
    }

    public NaryTree(T[][] ancestralConnection, T root) {
        build(ancestralConnection, root);
    }

    /**
     * @param parentNode tree node to which the childNode needs to be attached
     * @param childNode  node that needs to be attached to the children of parentNode
     */
    @Override
    public void addChildNode(TreeNode<T> parentNode, TreeNode<T> childNode) {
        parentNode.getChildren().append(childNode);
    }

    /**
     *
     * @param ancestralConnection
     * @return
     */
    private void build(T[][] ancestralConnection, T root) {
        this.rootNode = new TreeNode<>(root);
        for (T[] ts : ancestralConnection) {
            T parent = ts[0];
            T child = ts[1];
            addChildNode(parent, child);
        }
    }

    /**
     * @param parent containing element of the parent node
     * @param child  containing element of the child node to inserted
     */
    @Override
    public void addChildNode(T parent, T child) {

    }

    public Optional<TreeNode<T>> find(T element, TreeNode<T> startNode) {
        if (startNode.getElement().equals(element)) {
            return Optional.of(startNode);
        }
        // TODO: waiting for a queue implementation
        throw new RuntimeException();
    }

}
