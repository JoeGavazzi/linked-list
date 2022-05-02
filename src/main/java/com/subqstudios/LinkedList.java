package com.subqstudios;

import java.util.*;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param e the element to add
     */
    @Override
    public void addFirst(E e) {
        Node<E> n = new Node<>(null, e, null);
        if (head == null) {
            head = n;
            tail = head;
        } else {
            n.next = head;
            head = n;
            head.next.prev = n;
        }
        modCount++;
        size++;
    }

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param e the element to add
     */
    @Override
    public void addLast(E e) {
        Node<E> n = new Node<>(null, e, null);
        if (head == null) {
            head = n;
            tail = head;
        } else {
            n.prev = tail;
            tail = n;
            tail.prev.next = n;
        }
        modCount++;
        size++;
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(size);
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size);
    }

    /**
     * Inserts the specified element at the front of this list.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     */
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    /**
     * Inserts the specified element at the end of this list.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     */
    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    /**
     * Retrieves and removes the first element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    /**
     * Retrieves and removes the last element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    /**
     * Retrieves, but does not remove, the first element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the last element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return getLast();
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
     */
    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
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
     */
    @Override
    public boolean offer(E e) {
        return offerLast(e);
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeFirst();
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
        if (isEmpty()) {
            return null;
        }
        return pollFirst();
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getFirst();
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
        if (isEmpty()) {
            return null;
        }
        return peekFirst();
    }

    /**
     * Pushes an element onto the stack represented by this list (in other
     * words, at the head of this list).
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     */
    @Override
    public void push(E e) {
        addFirst(e);
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeFirst();
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
        //TODO:
        if (isEmpty()) {
            return false;
        }
        return remove(o);
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
        if (isEmpty()) {
            return false;
        }
        int index = lastIndexOf(o);
        try {
            remove(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // **List implementation

    /**
     * {@inheritDoc}
     *
     * @param o element to be checked for containment in this list
     * @implSpec This implementation iterates over the elements in the collection,
     * checking each element in turn for equality with the specified element.
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * {@inheritDoc}
     * 
     * @param c collection to be checked for containment in this list 
     * @return {@code true} if this list contains all of the elements of the
     * specified collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        //TODO:
        throw new UnsupportedOperationException();
    }
    
    /**
     * {@inheritDoc}
     * 
     * @param fromIndex low endpoint (inclusive) of the subList 
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        //TODO:
        throw new UnsupportedOperationException();
    }

    /**
     * @return the list as an array
     */
    @Override
    public Object[] toArray() {
        //TODO:
        throw new UnsupportedOperationException();
    }

    /**
     * @param a   the array into which the elements of this list are to 
     *            be stored, if it is big enough; otherwise, a new array of the
     *            same runtime type is allocated for this purpose.
     * @param <T> the component type of the array
     * @return  an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        //TODO:
        throw new UnsupportedOperationException();
    }



    /**
     * {@inheritDoc}
     *
     * @return {@code true} if this list contains no elements, {@code false}
     * otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     *
     * @param o element to be removed from this list, if present
     *
     * @implSpec This implementation iterates over the collection looking for the
     * specified element.  If it finds the element, it removes the element
     * from the collection using the iterator's remove method.
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (ListIterator<E> iter = listIterator(0); iter.hasNext(); ) {
                E e = iter.next();
                if (e == null) {
                    iter.remove();
                    return true;
                }
            }
        } else {
            for (ListIterator<E> iter = listIterator(0); iter.hasNext(); ) {
                E e = iter.next();
                if (e.equals(o)) {
                    iter.remove();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @implSpec This implementation calls {@code removeRange(0, size())}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless {@code remove(int
     * index)} or {@code removeRange(int fromIndex, int toIndex)} is
     * overridden.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * The number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    // Search methods

    /**
     * Returns the index of the first occurrence of the specified element
     *
     * @param o element to search for
     * @implSpec This implementation first gets a list iterator (with
     * {@code listIterator()}).  Then, it iterates over the list until the
     * specified element is found or the end of the list is reached.
     * If the list contains the element, the index of the first
     * matching element is returned; otherwise, {@code -1} is returned.
     *
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if the element is not found
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (ListIterator<E> iter = listIterator(0); iter.hasNext(); ) {
                E e = iter.next();
                if (e == null) {
                    return iter.previousIndex();
                }
            }
        } else {
            for (ListIterator<E> iter = listIterator(0); iter.hasNext(); ) {
                E e = iter.next();
                if (e.equals(o)) {
                    return iter.previousIndex();
                }
            }
        }
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, searching forwards from {@code index}, or returns -1 if
     * the element is not found. More formally, returns the lowest index {@code i} 
     * such that {@code (i >= index && (e==null ? get(i)==null : e.equals(get(i)))}), 
     * or -1 if there is no such index. (Returns -1 if the list is empty.)
     * 
     * @param e element to search for
     * @param index index to start searching from
     * @return the index of the first occurrence of the element in the list
     *         at position {@code index} or later in the list.
     */
    public int indexOf(E e, int index) {
        return indexOf(e);
    }

    /**
     * Returns the index of the last occurrence of the specified element
     *
     * @param o element to search for
     * @implSpec This implementation first gets a list iterator that points to the end
     * of the list (with {@code listIterator(size())}).  Then, it iterates
     * backwards over the list until the specified element is found, or the
     * beginning of the list is reached.
     * If the list contains the element, the index of the last
     * matching element is returned; otherwise, {@code -1} is returned.
     *
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if the element is not found
     *
     */
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (ListIterator<E> iter = listIterator(size()); iter.hasPrevious(); ) {
                E e = iter.previous();
                if (e == null) {
                    return iter.previousIndex();
                }
            }
        } else {
            for (ListIterator<E> iter = listIterator(size()); iter.hasPrevious(); ) {
                E e = iter.previous();
                if (e.equals(o)) {
                    return iter.previousIndex();
                }
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in
     * this list, searching backwards from {@code index}, or returns -1 if
     * the element is not found.
     *
     * @param e element to search for
     * @param index index to start searching backwards from
     * @return the index of the last occurrence of the element at position
     *         {@code index} or earlier in the list, or -1 if the element is not found.
     */
    public int lastIndexOf(E e, int index) {
        return lastIndexOf(e);
    }

    // Iterator operations

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
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public void add(int index, E e) {
        checkIndexOutOfBounds(index, 0, size);
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> n = getNode(index);
            Node<E> newNode = new Node<>(n.prev, e, n);
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;
            modCount++;
            size++;
        }
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
        boolean added = true;
        for (E data : c) {
            added &= add(data);
        }
        return added;
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
     * @param index index at which to insert first element
     * @param c elements to be inserted into this list
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int i = index;
        int prevSize = size;
        boolean added = true;
        for (E data : c) {
            add(++i, data);
            added &= size > prevSize;
            prevSize = size;
        }
        return added;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     */
    @Override
    public E get(int index) {
        ListIterator<E> iter;
        E data;
        if (index / 2 < size) {
            iter = listIterator();
            data = head.data;
            for (int i = 0; i < index; i++) {
                data = iter.next();
            }
        } else {
            iter = listIterator(size);
            data = tail.data;
            for (int i = size; i > index; i--) {
                data = iter.previous();
            }
        }
        return data;
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
     * @param index index of the element to replace
     * @param e element to be stored at the specified position
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public E set(int index, E e) {
        checkIndexOutOfBounds(index, 0, size - 1);
        ListIterator<E> iter;
        if (index / 2 < size) {
            iter = listIterator();
            for (int i = 0; i < index; i++) {
                iter.next();
            }
        } else {
            iter = listIterator(size);
            for (int i = size; i > index; i--) {
                iter.previous();
            }
        }
        iter.set(e);
        return e;
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
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        checkIndexOutOfBounds(index, 0, index);
        ListIterator<E> iter;
        E data = null;
        if (index <= size / 2) {
            iter = listIterator();
            for (int i = 0; i < index; i++) {
                data = iter.next();
            }
            if (Objects.isNull(data)) {
                modCount++;
                size--;
                return head.data;
            }
        } else {
            iter = listIterator(size);
            for (int i = size; i > index; i--) {
                data = iter.previous();
            }
            if (Objects.isNull(data)) {
                modCount++;
                size--;
                return tail.data;
            }
        }
        iter.remove();
        modCount++;
        size--;
        return data;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * 
     * @return a list iterator over the elements in this list (in proper
     *         sequence). The returned list iterator is <i>fail-fast</i>.
     *         If the list changes, the iterator will throw a 
     *         {@code ConcurrentModificationException}.     
     */
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
    
    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @param index index of first element to be returned from the list
     *              iterator (by a call to the {@code next} method)
     * @return a list iterator over the elements in this list (in proper
     *         sequence). The returned list iterator is <i>fail-fast</i>.
     *         If the list changes, the iterator will throw a 
     *         {@code ConcurrentModificationException}.     
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    /*                                        0     1     2
     *                                       head node1 node2 ...
     * Init                  ---->  cursor: ^                       (current: null,  cursorNext: head,  prevIndex() = -1, nextIndex = 0)
     * After one call to next---->  cursor: |----^                  (current: head,  cursorNext: node1, prevIndex() =  0, nextIndex = 1)
     * Second call to next   ---->  cursor:      |-----^            (current: node1, cursorNext: node2, prevIndex() =  1, nextIndex = 2)
     *
     *                                             7     8     9
     *                                       ... [s-2] [s-1] tail
     * Init                  ---->  cursor:                      ^ (current: null,  cursorNext: tail,  prevIndex() = 9, nextIndex = 10)
     * After one call to prev---->  cursor:                 ^----| (current: tail,  cursorNext: [s-1], prevIndex() = 8, nextIndex = 9)
     * Second call to prev   ---->  cursor:           ^-----|      (current: [s-1], cursorNext: [s-2], prevIndex() = 7, nextIndex = 8)
     */
    private class ListItr implements ListIterator<E>{
        private Node<E> current;                    // Node returned last
        private Node<E> cursorNext;                 // Node directly after the cursor.
        private int nextIndex;                      // the index of cursorNext
        private int expectedModCount = modCount;    // number of modifications to the list
        private boolean canSet;
        private boolean canRemove;

        ListItr(int index) {
            checkIndexOutOfBounds(index, 0, size);
            if (index <= size / 2) {
                cursorNext = head;
                for (nextIndex = 0; nextIndex < index; nextIndex++) {
                    cursorNext = cursorNext.next;
                }
            } else {
                cursorNext = tail;
                for (nextIndex = size; nextIndex > index; nextIndex--) {
                    cursorNext = cursorNext.prev;
                }
            }
            canSet = canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }
        
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            checkAndFailIfModified();
            current = cursorNext;
            cursorNext = cursorNext.next;
            nextIndex++;
            canSet = canRemove = true;
            return current.data;
        }
        
        @Override
        public boolean hasPrevious() {
            return previousIndex() > -1;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            checkAndFailIfModified();
            current = cursorNext;
            cursorNext = cursorNext.prev;
            nextIndex--;
            canSet = canRemove = true;
            return current.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }
        
        @Override
        public int previousIndex() {
            return nextIndex - 1;       // might have to change this to be the index of current(?) or some other value
        }
        
        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            checkAndFailIfModified();
            removeNode(current);
            if (cursorNext == current) {
                cursorNext = current.next;
            } else {
                nextIndex--;
            }
            canSet = canRemove = false;
            expectedModCount++;
        }

        @Override
        public void set(E e) {
            if (!canSet) {
                throw new IllegalStateException();
            }
            checkAndFailIfModified();
            current.data = e;
        }

        @Override
        public void add(E e) {
            checkAndFailIfModified();
            LinkedList.this.add(nextIndex, e);
            nextIndex++;
            expectedModCount++;
            canSet = canRemove = false;
        }
        
        void checkAndFailIfModified() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingItr<>(new ListItr(size));
    }
    
    private static class DescendingItr<E> implements Iterator<E> {
        ListIterator<E> listIterator;
        
        DescendingItr(ListIterator<E> listIterator) {
            this.listIterator = listIterator;
        }
        
        @Override
        public boolean hasNext() {
            return listIterator.hasPrevious();
        }

        @Override
        public E next() {
            return listIterator.previous();
        }

        @Override
        public void remove() {
            listIterator.remove();
        }
    }

    // lowerBound & upperBound are both exclusive
    private void checkIndexOutOfBounds(int index, int lowerBound, int upperBound) {
        if (index < lowerBound || index > upperBound) {
            throw new IndexOutOfBoundsException();
        }
    }

    // **Node operations

    private Node<E> getNode(int index) {
        checkIndexOutOfBounds(index, 0, size);
        Node<E> n;
        if (index <= size / 2) {
            n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        } else {
            n = tail;
            for (int i = size; i > index; i--) {
                n = n.prev;
            }
        }
        return n;
    }

    private E removeNode(Node<E> n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        E data = n.data;
        if (head == n && !Objects.isNull(head.next)) {
            head = n.next;
            head.prev = null;
        } else if (tail == n) {
            tail = n.prev;
            tail.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        n = null;
        return data;
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
