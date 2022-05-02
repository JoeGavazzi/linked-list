package com.subqstudios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList<String> emptyList;
    private LinkedList<String> singleElementList;
    private LinkedList<String> twoElementList;
    private LinkedList<String> threeElementList;

    private final String one =    "one";
    private final String two =    "two";
    private final String three =  "three";

    @BeforeEach
    public void setUp() {
        emptyList = new LinkedList<>();

        singleElementList = new LinkedList<>();
        singleElementList.add(one);

        twoElementList = new LinkedList<>();
        twoElementList.add(one);
        twoElementList.add(two);

        List<String> elements = List.of(one, two, three);
        threeElementList = new LinkedList<>(elements);
    }

    @Test
    public void getFirst_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> emptyList.getFirst());
    }

    @Test
    public void getFirst_singleElementList_returnsFirstAndOnlyElement() {
        String firstElement = singleElementList.getFirst();

        assertEquals(one, firstElement, "getFirst() should return the first element");
    }

    @Test
    public void getFirst_twoElementList_returnsFirstElement() {
        String firstElement = twoElementList.getFirst();

        assertEquals(one, firstElement, "getFirst() should return the first element");
    }

    @Test
    public void getFirst_threeElementList_returnsFirstElement() {
        String firstElement = threeElementList.getFirst();

        assertEquals(one, firstElement, "getFirst() should return the first element");
    }

    @Test
    public void getLast_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> emptyList.getLast());
    }

    @Test
    public void getLast_singleElementList_returnsLastAndOnlyElement() {
        String lastElement = singleElementList.getLast();

        assertEquals(one, lastElement, "getLast() should return the last element");
    }

    @Test
    public void getLast_twoElementList_returnsLastElement() {
        String lastElement = twoElementList.getLast();

        assertEquals(two, lastElement, "getLast() should return the last element");
    }

    @Test
    public void getLast_threeElementList_returnsLastElement() {
        String lastElement = threeElementList.getLast();

        assertEquals(three, lastElement, "getLast() should return the last element");
    }

    @Test
    public void addFirst_emptyList_addsElementToList() {
        String newElement = "newElement";

        emptyList.addFirst(newElement);
        String firstElement = emptyList.getFirst();

        assertEquals(newElement, firstElement, "addFirst() should add the element to the list");
    }

    @Test
    public void addFirst_singleElementList_addsElementToList() {
        String newElement = "newElement";

        singleElementList.addFirst(newElement);
        String firstElement = singleElementList.getFirst();

        assertEquals(newElement, firstElement,"addFirst() should add the element to the list");
    }

    @Test
    public void addFirst_twoElementList_addsElementToList() {
        String newElement = "newElement";

        twoElementList.addFirst(newElement);
        String firstElement = twoElementList.getFirst();

        assertEquals(newElement, firstElement, "addFirst() should add the element to the list");
    }

    @Test
    public void addFirst_threeElementList_addsElementToList() {
        String newElement = "newElement";

        threeElementList.addFirst(newElement);
        String firstElement = threeElementList.getFirst();

        assertEquals(newElement, firstElement, "addFirst() should add the element to the list");
    }

    @Test
    public void addLast_emptyList_addsElementToList() {
        String newElement = "newElement";

        emptyList.addLast(newElement);
        String lastElement = emptyList.getLast();

        assertEquals(newElement, lastElement, "addLast() should add the element to the list");
    }

    @Test
    public void addLast_singleElementList_addsElementToList() {
        String newElement = "newElement";

        singleElementList.addLast(newElement);
        String lastElement = singleElementList.getLast();

        assertEquals(newElement, lastElement, "addLast() should add the element to the list");
    }

    @Test
    public void addLast_twoElementList_addsElementToList() {
        String newElement = "newElement";

        twoElementList.addLast(newElement);
        String lastElement = twoElementList.getLast();

        assertEquals(newElement, lastElement, "addLast() should add the element to the list");
    }

    @Test
    public void addLast_threeElementList_addsElementToList() {
        String newElement = "newElement";

        threeElementList.addLast(newElement);
        String lastElement = threeElementList.getLast();

        assertEquals(newElement, lastElement, "addLast() should add the element to the list");
    }

    @Test
    public void removeFirst_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> emptyList.removeFirst());
    }

    @Test
    public void removeFirst_singleElementList_removesOnlyElement() {
        String first = singleElementList.getFirst();
        String removed = singleElementList.removeFirst();

        assertEquals(first, removed,"removeFirst() should remove the first element");
        assertEquals(0, singleElementList.size(), "List size should be 0");
    }

    @Test
    public void removeFirst_twoElementList_removesFirstElement() {
        String first = twoElementList.getFirst();
        String removed = twoElementList.removeFirst();

        assertEquals(first, removed,"removeFirst() should remove the first element");
        assertEquals(1, twoElementList.size(), "List size should be 1");
    }

    @Test
    public void removeFirst_threeElementList_removesFirstElement() {
        String first = threeElementList.getFirst();
        String removed = threeElementList.removeFirst();

        assertEquals(first, removed,"removeFirst() should remove the first element");
        assertEquals(2, threeElementList.size(), "List size should be 2");
    }

    @Test
    public void removeLast_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> emptyList.removeLast());
    }

    @Test
    public void removeLast_singleElementList_removesOnlyElement() {
        String last = singleElementList.getLast();
        String removed = singleElementList.removeLast();

        assertEquals(last, removed,"removeLast() should remove the last element");
        assertEquals(0, singleElementList.size(), "List size should be 0");
    }

    @Test
    public void removeLast_twoElementList_removesLastElement() {
        String last = twoElementList.getLast();
        String removed = twoElementList.removeLast();

        assertEquals(last, removed,"removeLast() should remove the last element");
        assertEquals(1, twoElementList.size(), "List size should be 1");
    }

    @Test
    public void removeLast_threeElementList_removesLastElement() {
        String last = threeElementList.getLast();
        String removed = threeElementList.removeLast();

        assertEquals(last, removed,"removeLast() should remove the last element");
        assertEquals(2, threeElementList.size(), "List size should be 2");
    }
}
