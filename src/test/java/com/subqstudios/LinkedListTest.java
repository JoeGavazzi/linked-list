package com.subqstudios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class LinkedListTest {

    private static final int LISTS_TO_TEST = 5;
    private static final int EMPTY = 0;
    private static final int ONE_ITEM = 1;
    private static final int TWO_ITEMS = 2;
    private static final int THREE_ITEMS = 3;
    private static final int FOUR_ITEMS = 4;
    List<LinkedList<String>> linkedLists;

    @BeforeEach
    public void setUp() {
        linkedLists = new ArrayList<>();
        List<String> elements = new ArrayList<>();

        for (int i = EMPTY; i < LISTS_TO_TEST; i++) {
            linkedLists.add(new LinkedList<>(elements));
            elements.add(String.valueOf(i));
        }
    }

    @Test
    public void getFirst_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> linkedLists.get(EMPTY).getFirst());
    }

    @Test
    public void getFirst_multipleItemLists_returnsFirstItem() {
        for (int i = ONE_ITEM; i < linkedLists.size(); i++) {
            String firstItem = linkedLists.get(i).getFirst();

            assertEquals("0", firstItem, "getFirst() should return the first element");
        }
    }

    @Test
    public void getLast_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> linkedLists.get(EMPTY).getLast());
    }

    @Test
    public void getLast_singleAndMultipleItemLists_returnsLastItem() {
        for (int i = ONE_ITEM; i < linkedLists.size(); i++) {
            String lastItem = linkedLists.get(i).getLast();

            assertEquals(String.valueOf(i - 1), lastItem, "getLast() should return the last element");
        }
    }

    @Test
    public void addFirst_zeroToNSizedList_addsItemToFrontOfList() {
        for (LinkedList<String> linkedList : linkedLists) {
            int sizeBefore = linkedList.size();

            String newItem = "newItem";
            linkedList.addFirst(newItem);

            assertEquals(sizeBefore + 1, linkedList.size(), "addFirst() should increase " +
                    "the list's size by 1");
            assertEquals(newItem, linkedList.getFirst(), "addFirst() should add the element " +
                    "to the front of the list");
        }
    }

    @Test
    public void addLast_multipleItemLists_addsItemToEndOfList() {
        for (LinkedList<String> linkedList : linkedLists) {
            int sizeBefore = linkedList.size();

            String newItem = "newItem";
            linkedList.addLast(newItem);

            assertEquals(sizeBefore + 1, linkedList.size(), "getLast() should increase " +
                    "the list's size by 1");
            assertEquals(newItem, linkedList.getLast(), "getLast() should add the element " +
                    "to the end of the list");
        }
    }

    @Test
    public void removeFirst_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> linkedLists.get(EMPTY).removeFirst());
    }

    @Test
    public void removeFirst_singleItemList_removesOnlyItem() {
        String first = linkedLists.get(ONE_ITEM).getFirst();
        String removedFirst = linkedLists.get(ONE_ITEM).removeFirst();

        assertEquals(first, removedFirst, "removeFirst() should return the element it removed");
        assertEquals(EMPTY, linkedLists.get(ONE_ITEM).size(), "List should be empty");
    }

    @Test
    public void removeFirst_multipleItemLists_removesFirstItem() {
        for (int i = TWO_ITEMS; i < linkedLists.size(); i++) {
            int sizeBefore = linkedLists.get(i).size();

            String first = linkedLists.get(i).getFirst();
            String newFirst = linkedLists.get(i).get(1);
            String removedFirst = linkedLists.get(i).removeFirst();

            assertEquals(first, removedFirst, "removeFirst() should return the element it removed");
            assertEquals(newFirst, linkedLists.get(i).getFirst(), "First element should now be the " +
                    "element that came after the removed element");
            assertEquals(sizeBefore - ONE_ITEM, linkedLists.get(i).size(), "List size should decrease by 1");
        }
    }

    @Test
    public void removeLast_emptyList_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> linkedLists.get(EMPTY).removeLast());
    }

    @Test
    public void removeLast_singleItemList_removesOnlyItem() {
        String last = linkedLists.get(ONE_ITEM).getLast();
        String removedLast = linkedLists.get(ONE_ITEM).removeLast();

        assertEquals(last, removedLast, "removeLast() should return the element it removed");
        assertEquals(EMPTY, linkedLists.get(1).size(), "List should be empty");
    }

    @Test
    public void removeLast_multipleItemLists_removesAndReturnsLastItem() {
        for (int i = TWO_ITEMS; i < linkedLists.size(); i++) {
            int sizeBefore = linkedLists.get(i).size();

            String newLast = linkedLists.get(i).get(linkedLists.get(i).size() - 1 - ONE_ITEM);
            String last = linkedLists.get(i).getLast();
            String removedLast = linkedLists.get(i).removeLast();

            assertEquals(last, removedLast, "removeLast() should return the element it removed");
            assertEquals(sizeBefore - ONE_ITEM, linkedLists.get(i).size(), "List size should decrease by 1");
            assertEquals(newLast, String.valueOf(i - 2), "Last element should now be the element that " +
                    "came before the removed element");
        }
    }

    @Test
    public void add_oneItem_addsItemToList() {
        String element = "element";
        for (LinkedList<String> linkedList : linkedLists) {
            int sizeBefore = linkedList.size();
            linkedList.add(element);

            assertEquals(sizeBefore + ONE_ITEM, linkedList.size(), "List size should be 1 item larger");
        }
    }

    @Test
    public void add_atNegativeIndex_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedLists.get(EMPTY).add(-1,  "element"));
    }

    @Test
    public void add_atIndexGreaterThanSize_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedLists.get(EMPTY).add(1, "element"));
    }

    @Test
    public void add_atIndexZero_addsItemToBeginningOfList() {
        String element = "element";
        for (LinkedList<String> linkedList : linkedLists) {
            int sizeBefore = linkedList.size();
            linkedList.add(0, element);

            assertEquals(sizeBefore + 1, linkedList.size(), "List size should be 1 larger");
            assertEquals(element, linkedList.getFirst(), "First element should be the added element");
        }
    }

    @Test
    public void add_atIndexOne_addsItemToMiddleOfList() {
        String element = "element";

        int sizeBefore = linkedLists.get(2).size();
        linkedLists.get(2).add(1, element);

        assertEquals(sizeBefore + 1, linkedLists.get(2).size(), "List size should be 1 larger");
        assertEquals(element, linkedLists.get(2).get(1), "Element at index 1 should be the added element");

    }

    @Test
    public void add_atIndexLast_addsItemToEndOfList() {
        String element = "element";
        for (LinkedList<String> linkedList : linkedLists) {
            int sizeBefore = linkedList.size();
            linkedList.add(sizeBefore, element);

            assertEquals(sizeBefore + 1, linkedList.size(), "List size should be 1 larger");
            assertEquals(element, linkedList.getLast(), "Last element should be the added element");
        }
    }

    @Test
    public void addAll_zeroToNSizedList_addsAllItemsToList() {
        List<String> elements = Arrays.asList("element1", "element2", "element3");
        for (LinkedList<String> linkedList : linkedLists) {
            int sizeBefore = linkedList.size();
            linkedList.addAll(elements);

            assertEquals(sizeBefore + elements.size(), linkedList.size(), "List size should be 3 larger");
        }
    }

    @Test
    public void addAll_singleAndMultiItemLists_addsItemsToListAtIndex() {
        List<String> elements = Arrays.asList("element1", "element2", "element3");
        for (int i = 0; i < linkedLists.size(); i++) {
            int sizeBefore = linkedLists.get(i).size();
            linkedLists.get(i).addAll(i, elements);

            assertEquals(sizeBefore + elements.size(), linkedLists.get(i).size(), "List size should be 3 larger");
        }
    }

    @Test
    public void indexOf_multipleItemLists_returnsFirstIndexOfElement() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("element", "element", "element", "element", "element"));
        int index = list.indexOf("element");

        assertEquals(0, index, "Index should be 0");
    }

    @Test
    public void indexOf_duplicateItemsInList_returnsFirstIndexOfElementFromIndex() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("element", null, null, "element", null));
        int index = list.indexOf("element", 1);

        assertEquals(3, index, "Index should be " + 3);
    }

    @Test
    public void lastIndexOf_duplicateItemsInList_returnsLastIndexOfElement() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("element", "element", "element", "element", "element"));
        int index = list.lastIndexOf("element");

        assertEquals(list.size() - 1, index, "Index should be " + (list.size() - 1));
    }

    @Test
    public void lastIndexOf_duplicateItemsInList_returnsLastIndexOfElementFromIndex() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("element", null, null, "element", null));
        int index = list.lastIndexOf("element", 2);

        assertEquals(0, index, "Index should be " + 0);
    }
}
