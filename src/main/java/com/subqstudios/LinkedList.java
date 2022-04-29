package com.subqstudios;

import java.util.*;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable {
    private Node<E> head = new Node<>(null, null, null);
    private Node<E> tail = new Node<>(null, null, null);

    private int size = 0;

    public LinkedList() {
        head.next = head.prev = head;
        tail.prev = tail.next = tail;
    }

    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * Retrieves, but does not remove, the first element of this list.
     * <p>
     * This method differs from {@link #peekFirst peekFirst} only in that it
     * throws an exception if this list is empty.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E getFirst() {
        return get(0);
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     * This method differs from {@link #peekLast peekLast} only in that it
     * throws an exception if this list is empty.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param e the element to add
     */
    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param e the element to add
     */
    @Override
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * Retrieves and removes the first element of this list.  This method
     * differs from {@link #pollFirst pollFirst} only in that it throws an
     * exception if this list is empty.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E removeFirst() {
        return null;
    }

    /**
     * Retrieves and removes the last element of this list.  This method
     * differs from {@link #pollLast pollLast} only in that it throws an
     * exception if this list is empty.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E removeLast() {
        return null;
    }

    /**
     * Removes the first occurrence of the specified element from this list.
     * If the list does not contain the element, it is unchanged.
     * More formally, removes the first element {@code e} such that
     * {@code Objects.equals(o, e)} (if such an element exists).
     * Returns {@code true} if this list contained the specified element
     * (or equivalently, if this list changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    /**
     * Removes the last occurrence of the specified element from this list.
     * If the list does not contain the element, it is unchanged.
     * More formally, removes the last element {@code e} such that
     * {@code Objects.equals(o, e)} (if such an element exists).
     * Returns {@code true} if this list contained the specified element
     * (or equivalently, if this list changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    // **Deque implementation.

    /**
     * Retrieves and removes the first element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E pollFirst() {
        return null;
    }

    /**
     * Retrieves and removes the last element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E pollLast() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the first element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E peekFirst() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the last element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E peekLast() {
        return null;
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this deque
     * @throws NullPointerException     if the specified element is null and this
     *                                  deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *                                  element prevents it from being added to this deque
     */
    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this deque
     * @throws NullPointerException     if the specified element is null and this
     *                                  deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *                                  element prevents it from being added to this deque
     */
    @Override
    public boolean offerLast(E e) {
        return false;
    }

    /**
     * Inserts the specified element into the queue represented by this list
     * (in other words, at the tail of this list).
     *
     * <p>This method is equivalent to {@link #offerLast}.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this deque
     * @throws NullPointerException     if the specified element is null and this
     *                                  deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *                                  element prevents it from being added to this deque
     */
    @Override
    public boolean offer(E e) {
        return false;
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns
     * {@code null} if this deque is empty.
     *
     * <p>This method is equivalent to {@link #pollFirst()}.
     *
     * @return the first element of this deque, or {@code null} if
     * this deque is empty
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque (in other words, the first element of this deque).
     * This method differs from {@link #peek peek} only in that it throws an
     * exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #getFirst()}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E element() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque (in other words, the first element of this deque), or
     * returns {@code null} if this deque is empty.
     *
     * <p>This method is equivalent to {@link #peekFirst()}.
     *
     * @return the head of the queue represented by this deque, or
     * {@code null} if this deque is empty
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * Pushes an element onto the stack represented by this list (in other
     * words, at the head of this list) if it is possible to do so
     * immediately without violating capacity restrictions, throwing an
     * {@code IllegalStateException} if no space is currently available.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     * @throws IllegalStateException    if the element cannot be added at this
     *                                  time due to capacity restrictions
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this deque
     * @throws NullPointerException     if the specified element is null and this
     *                                  deque does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *                                  element prevents it from being added to this deque
     */
    @Override
    public void push(E e) {

    }

    /**
     * Pops an element from the stack represented by this list.  In other
     * words, removes and returns the first element of this list.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this deque (which is the top
     * of the stack represented by this deque)
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E pop() {
        return null;
    }


    /**
     * Retrieves and removes the head of the queue represented by this list
     * (in other words, the first element of this list).
     * This method differs from {@link #poll() poll()} only in that it
     * throws an exception if this list is empty.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E remove() {
        return null;
    }

    // **List implementation

    /**
     * {@inheritDoc}
     *
     * @param o
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @implSpec This implementation iterates over the elements in the collection,
     * checking each element in turn for equality with the specified element.
     */
    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the {@code add} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     * @implSpec This implementation calls {@code add(size(), e)}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless
     * {@link #add(int, Object) add(int, E)} is overridden.
     */
    @Override
    public boolean add(E e) {
        addBefore(e, head);
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param o
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @implSpec This implementation iterates over the collection looking for the
     * specified element.  If it finds the element, it removes the element
     * from the collection using the iterator's remove method.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} if the iterator returned by this
     * collection's iterator method does not implement the {@code remove}
     * method and this collection contains the specified object.
     */
    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param c
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IllegalStateException         {@inheritDoc}
     * @implSpec This implementation iterates over the specified collection, and adds
     * each object returned by the iterator to this collection, in turn.
     *
     * <p>Note that this implementation will throw an
     * {@code UnsupportedOperationException} unless {@code add} is
     * overridden (assuming the specified collection is non-empty).
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * <p>This implementation gets an iterator over the specified collection and
     * a list iterator over this list pointing to the indexed element (with
     * {@code listIterator(index)}).  Then, it iterates over the specified
     * collection, inserting the elements obtained from the iterator into this
     * list, one at a time, using {@code ListIterator.add} followed by
     * {@code ListIterator.next} (to skip over the added element).
     *
     * <p>Note that this implementation will throw an
     * {@code UnsupportedOperationException} if the list iterator returned by
     * the {@code listIterator} method does not implement the {@code add}
     * operation.
     *
     * @param index
     * @param c
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return super.addAll(index, c);
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this list
     * @implSpec This implementation calls {@code removeRange(0, size())}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless {@code remove(int
     * index)} or {@code removeRange(int fromIndex, int toIndex)} is
     * overridden.
     */
    @Override
    public void clear() {
        super.clear();
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    // Search methods

    /**
     *
     *
     * @param o
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @implSpec This implementation first gets a list iterator (with
     * {@code listIterator()}).  Then, it iterates over the list until the
     * specified element is found or the end of the list is reached.
     */
    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    /**
     *
     *
     * @param o
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @implSpec This implementation first gets a list iterator that points to the end
     * of the list (with {@code listIterator(size())}).  Then, it iterates
     * backwards over the list until the specified element is found, or the
     * beginning of the list is reached.
     */
    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }


    // CRUD operations

    /**
     * Returns the element at the specified position in this list.
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with {@code listIterator(index)}).  Then, it gets
     * the element using {@code ListIterator.next} and returns it.
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with {@code listIterator(index)}).  Then, it gets
     * the current element using {@code ListIterator.next} and replaces it
     * with {@code ListIterator.set}.
     *
     * <p>Note that this implementation will throw an
     * {@code UnsupportedOperationException} if the list iterator does not
     * implement the {@code set} operation.
     *
     * @param index
     * @param e
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public E set(int index, E e) {
        return super.set(index, e);
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with {@code listIterator(index)}).  Then, it
     * inserts the specified element with {@code ListIterator.add}.
     *
     * <p>Note that this implementation will throw an
     * {@code UnsupportedOperationException} if the list iterator does not
     * implement the {@code add} operation.
     *
     * @param index
     * @param e
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public void add(int index, E e) {
        addBefore(e, index == size ? head : getNode(index));
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with {@code listIterator(index)}).  Then, it removes
     * the element with {@code ListIterator.remove}.
     *
     * <p>Note that this implementation will throw an
     * {@code UnsupportedOperationException} if the list iterator does not
     * implement the {@code remove} operation.
     *
     * @param index
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        modCount++;
        return null;
    }

    // **Node operations

    private Node<E> addBefore(E e, Node<E> n) {
        Node<E> newNode = new Node<>(n.prev, e, n);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        modCount++;
        size++;
        return newNode;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = head;
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {
                n = n.next;
            }
        } else {
            for (int i = size; i > index; i--) {
                n = n.prev;
            }
        }
        return n;
    }

    private E removeNode(Node<E> n) {
        // if this list is empty
//        if (n == head) {
//            throw new NoSuchElementException();
//        }
        E e = n.data;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
        n = null;
        return e;
    }

    /**
     * Returns an iterator over the elements in this list in reverse
     * sequential order.  The elements will be returned in order from
     * last (tail) to first (head).
     *
     * @return an iterator over the elements in this deque in reverse
     * sequence
     */
    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @param index index of first element to be returned from the list
     *              iterator (by a call to the {@code next} method)
     * @return a list iterator over the elements in this list (in proper
     * sequence)
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E>{
        Node<E> lastPtr;
        Node<E> curPtr = head;
        int curPtrIndex;
        int expectedModCount = modCount;

        ListItr(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            if (index < size / 2) {
                curPtr = curPtr.next;
                for (curPtrIndex = 0; curPtrIndex <= index; curPtrIndex++) {
                    curPtr = curPtr.next;
                }
            } else {
                for (int ptrIndex = size; ptrIndex > index; ptrIndex--) {
                    curPtr = curPtr.prev;
                }
            }
            curPtrIndex = index;
        }

        @Override
        public boolean hasNext() {
            return curPtrIndex < size;  // maybe !=
        }

        @Override
        public E next() {
            if (nextIndex() >= size) {
                throw new NoSuchElementException();
            }
            checkConcurrentModifications();
            lastPtr = curPtr;
            curPtr = curPtr.next;
            curPtrIndex++;
            return lastPtr.data;
        }

        @Override
        public boolean hasPrevious() {  // maybe !=
            return curPtrIndex > 0;

        }

        @Override
        public E previous() {
            if (previousIndex() < 0) {
                throw new NoSuchElementException();
            }
            checkConcurrentModifications();
            lastPtr = curPtr;
            curPtr = curPtr.prev;
            curPtrIndex--;
            return lastPtr.data;
        }

        @Override
        public int nextIndex() {
            return curPtrIndex;
        }

        @Override
        public int previousIndex() {
            return curPtrIndex - 1;
        }

        @Override
        public void remove() {
            checkConcurrentModifications();

        }

        @Override
        public void set(E e) {
            checkConcurrentModifications();

        }

        @Override
        public void add(E e) {
            checkConcurrentModifications();

        }

        void checkConcurrentModifications() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
