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
        this.insert(element, this.length);
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
    public T pop() {
        return this.delete(this.length - 1);
    }

    /**
     * makes space to insert element at provided index by offsetting the other elements predictably
     *
     * @param element element to be inserted at index
     * @param index   index where the element needs to be inserted
     */
    @Override
    public void insert(T element, int index) {
        if (element == null) throw new NullPointerException("element to be inserted cannot be null");
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException(
                    "index:: " + index + " is out of bounds on vec of length:: " + this.length
            );
        }
        if (this.length < this.capacity) {
            System.arraycopy(this.arr, index, this.arr, index + 1, this.length - index);
            this.arr[index] = element;
            this.length++;
            return;
        }
        int reCapacity = this.length * 2;
        Object[] reArr = new Object[reCapacity];
        System.arraycopy(this.arr, 0, reArr, 0, index);
        reArr[index] = element;
        System.arraycopy(this.arr, index, reArr, index + 1, this.length - index);
        this.length++;
        this.arr = reArr;
        this.capacity = reCapacity;
    }

    /**
     * re allocates the array into a bigger array with twice the capacity and copies over the elements
     */
    private void grow() {
        // re-alloc to bigger array and copy over existing elements
        int reCapacity = this.length * 2;
        Object[] reArr = new Object[reCapacity];
        System.arraycopy(this.arr, 0, reArr, 0, this.length);
        this.arr = reArr;
        this.capacity = reCapacity;
    }

    /**
     * re allocates the array into a smaller array with half the capacity and copies over the elements
     */
    private void shrink() {
        // re-alloc to smaller array and copy over existing elements
        int reCapacity = this.length;
        Object[] reArr = new Object[reCapacity];
        System.arraycopy(this.arr, 0, reArr, 0, this.length);
        this.arr = reArr;
        this.capacity = reCapacity;
    }

    /**
     * deletes the element at the provided index and offsets the remaining elements predictably
     *
     * @param index index where the element needs to be deleted
     * @return element that was deleted
     */
    @Override
    @SuppressWarnings("unchecked")
    public T delete(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException(
                    "index:: " + index + "is out of bounds on vec of length:: " + this.length
            );
        }
        if (this.length * 2 < this.capacity) {
            int reCapacity = this.length;
            Object[] reArr = new Object[reCapacity];
            T deletedElement = (T) this.arr[index];
            System.arraycopy(this.arr, 0, reArr, 0, index);
            System.arraycopy(this.arr, index + 1, reArr, index, this.length - index);
            reArr[this.length - 1] = null;
            this.length--;
            this.capacity = reCapacity;
            this.arr = reArr;
            return deletedElement;
         }
        T deletedElement = (T) this.arr[index];
        System.arraycopy(this.arr, index + 1, this.arr, index, this.length - index);
        this.arr[this.length] = null;
        this.length--;
        return deletedElement;
    }

    private static final String OPEN = "[ ";
    private static final String CLOSE = "]";
    private static final String SEPERATOR = " ";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OPEN);
        for (int i = 0; i < this.length; i++) {
            String objectRepr = this.arr[i].toString();
            sb.append(objectRepr);
            sb.append(SEPERATOR);
        }
        sb.append(CLOSE);
        return sb.toString();
    }
}
