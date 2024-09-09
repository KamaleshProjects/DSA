package com.dsa.vec;

/**
 *
 * @param <T>
 */
public interface RingVec<T> {

    /**
     *
     * @param element
     */
    void appendHead(T element);

    /**
     *
     * @param element
     */
    void appendTail(T element);

    /**
     *
     * @return
     */
    T popHead();

    /**
     *
     * @return
     */
    T popTail();
}
