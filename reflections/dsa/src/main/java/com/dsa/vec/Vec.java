package com.dsa.vec;

/**
 * Provides APIs for interacting with vectors (similar to arraylist in java, vectors in c++, list in python etc.)
 * @param <T> type of the elements in the vector
 */
public interface Vec<T> {

    /**
     * appends element to the end of the vector
     * @param element element to be appended to the vector
     */
    void append(T element);

    /**
     *
     * @param index index of an element inside the vector
     * @return the element present at index
     */
    T get(int index);

    /**
     * sets element at index
     * @param element element to be set at index
     * @param index index where the element needs to be set
     */
    void set(T element, int index);

    /**
     *
     * @return length of the vector (total no of elements the vector is holding)
     */
    int length();

    /**
     * deletes the element at the end of the vector
     * @return the element at the end of the vector that was deleted
     */
    T pop();

    /**
     * makes space to insert element at provided index by offsetting the other elements predictably
     * @param element element to be inserted at index
     * @param index index where the element needs to be inserted
     */
    void insert(T element, int index);

    /**
     * deletes the element at the provided index and offsets the remaining elements predictably
     * @param index index where the element needs to be deleted
     * @return element that was deleted
     */
    T delete(int index);
}
