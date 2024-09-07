package com.dsa.vec;

/**
 * Provides an implementation for a {@link Vec} that is backed by an array
 * @param <T>
 */
public class VecArr<T> implements Vec<T> {

    private int length;
    private Object[] arr;
    private int capacity;

    public VecArr() {
        this.arr = new Object[2];
        this.length = 0;
        this.capacity = 2;
    }

    /**
     * appends element to the end of the vector
     *
     * @param element element to be appended to the vector
     */
    @Override
    public void append(T element) {
        if (element == null) throw new NullPointerException("element to be appended cannot be null");
        if (this.length == this.capacity) {
            // re-alloc to bigger array and copy over existing elements
            int reCapacity = this.length * 2;
            Object[] reArr = new Object[reCapacity];
            System.arraycopy(this.arr, 0, reArr, 0, this.length);
            this.arr = reArr;
            this.capacity = reCapacity;
        }
        // append element at the end of the vector
        this.arr[this.length] = element;
        length++;
    }

    /**
     * @param index index of an element inside the vector
     * @return the element present at index
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException(
                    "index:: " + index + "is out of bounds on vec of length:: " + this.length
            );
        }
        // this should be a safe cast, as we are trying to cast back to the type that the vec is made up of
        return (T) this.arr[index];
    }

    /**
     * sets element at index
     *
     * @param element element to be set at index
     * @param index   index where the element needs to be set
     */
    @Override
    public void set(T element, int index) {
        if (element == null) throw new NullPointerException("element to be set cannot be null");
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException(
                    "index:: " + index + "is out of bounds on vec of length:: " + this.length
            );
        }
        this.arr[index] = element;
    }

    /**
     * @return length of the vector (total no of elements the vector is holding)
     */
    @Override
    public int length() {
        return this.length;
    }

    /**
     * deletes the element at the end of the vector
     *
     * @return the element at the end of the vector that was deleted
     */
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (this.length * 2 < this.capacity) {
            // re-alloc to smaller array and copy over existing elements
            int reCapacity = this.length;
            Object[] reArr = new Object[reCapacity];
            System.arraycopy(this.arr, 0, reArr, 0, this.length);
            this.arr = reArr;
            this.capacity = reCapacity;
        }
        // this should be a safe cast, as we are trying to cast back to the type that the vec is made up of
        T poppedElement = (T) this.arr[this.length];
        this.arr[this.length] = null;
        this.length--;
        return poppedElement;
    }

    /**
     * makes space to insert element at provided index by offsetting the other elements predictably
     *
     * @param element element to be inserted at index
     * @param index   index where the element needs to be inserted
     */
    @Override
    public void insert(T element, int index) {
        throw new RuntimeException("To be implemented");
    }

    /**
     * deletes the element at the provided index and offsets the remaining elements predictably
     *
     * @param index index where the element needs to be deleted
     * @return element that was deleted
     */
    @Override
    public T delete(int index) {
        throw new RuntimeException("To be implemented");
    }
}
