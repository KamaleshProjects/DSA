package com.dsa.vec;

/**
 * Provides an implementation for a {@link RingVecArr} that is backed by an array
 * @param <T> type of the elements in the vector
 */
public class RingVecArr<T> implements RingVec<T> {

    private Object[] arr;
    private int head;
    private int tail;
    private int length;

    private static final int INITIAL_CAPACITY = 4;

    public RingVecArr() {
        this.arr = new Object[INITIAL_CAPACITY];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * @param element element to be appended at the head of the ring vector
     */
    @Override
    public void appendHead(T element) {
        if (element == null) throw new NullPointerException("element to be appended cannot be null");
        if (this.length == this.arr.length) {

        }
        this.arr[this.head] = element;
        if (this.head == 0) {
            this.head = this.arr.length - 1;
        } else {
            this.head--;
        }
        this.length++;
    }

    /**
     * @param element element to be appended at the tail of the ring vector
     */
    @Override
    public void appendTail(T element) {
        if (element == null) throw new NullPointerException("element to be appended cannot be null");
        if (this.length == this.arr.length) {

        }
        this.arr[this.tail] = element;
        if (this.tail == this.arr.length - 1) {
            this.tail = 0;
        } else {
            this.tail++;
        }
        this.length++;
    }

    /**
     * @return the element popped at the head of the ring vector
     */
    @Override
    @SuppressWarnings("unchecked")
    public T popHead() {
        if (this.length * 2 < this.arr.length) {

        }
        T poppedElement = (T) this.arr[this.head];
        this.arr[this.head] = null;
        if (this.head == this.arr.length - 1) {
            this.head = 0;
        } else {
            this.head++;
        }
        this.length--;
        return poppedElement;
    }

    /**
     * @return the element popped at the tail of the ring vector
     */
    @Override
    @SuppressWarnings("unchecked")
    public T popTail() {
        if (this.length * 2 < this.arr.length) {

        }
        T poppedElement = (T) this.arr[this.tail];
        this.arr[this.tail] = null;
        if (this.tail == 0) {
            this.tail = this.arr.length - 1;
        } else {
            this.tail--;
        }
        this.length--;
        return poppedElement;
    }
}
