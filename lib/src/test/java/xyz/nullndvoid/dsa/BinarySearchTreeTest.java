package xyz.nullndvoid.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class BinarySearchTreeTest {
    @Test
    public void testEmptyTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());
    }

    @Test
    public void testInsertSingleElement() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(5));
    }

    @Test
    public void testInsertMultipleElements() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);

        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertTrue(bst.search(1));
        assertTrue(bst.search(9));
    }

    @Test
    public void testInsertDuplicateValues() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(5);
        bst.insert(5);

        assertTrue(bst.search(5));
    }

    @Test
    public void testSearchNonExistentValue() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertFalse(bst.search(10));
        assertFalse(bst.search(1));
        assertFalse(bst.search(6));
    }

    @Test
    public void testSearchInEmptyTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertFalse(bst.search(5));
    }

    @Test
    public void testWithStringValues() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("dog");
        bst.insert("cat");
        bst.insert("elephant");
        bst.insert("ant");

        assertTrue(bst.search("dog"));
        assertTrue(bst.search("cat"));
        assertTrue(bst.search("elephant"));
        assertTrue(bst.search("ant"));
        assertFalse(bst.search("zebra"));
    }

    @Test
    public void testSearchReturnsCorrectNode() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertFalse(bst.search(10));
    }

    @Test
    public void testInsertWithNullValue() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertThrows(NullPointerException.class, () -> {
            bst.insert(null);
        });
    }

    @Test
    public void testSearchWithNullValue() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        assertThrows(NullPointerException.class, () -> {
            bst.search(null);
        });
    }

    @Test
    public void testLargeTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 100; i++) {
            bst.insert(i);
        }

        for (int i = 1; i <= 100; i++) {
            assertTrue(bst.search(i));
        }

        assertFalse(bst.search(101));
        assertFalse(bst.search(0));
    }

    @Test
    public void testSortEmptyTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        ArrayList<Integer> result = bst.sort();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSortSingleElement() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        ArrayList<Integer> result = bst.sort();
        assertEquals(1, result.size());
        assertEquals(Integer.valueOf(5), result.get(0));
    }

    @Test
    public void testSortMultipleElements() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);

        ArrayList<Integer> result = bst.sort();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(9);

        assertEquals(expected, result);
    }

    @Test
    public void testSortWithDuplicates() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(5);
        bst.insert(3);

        ArrayList<Integer> result = bst.sort();
        assertEquals(2, result.size());
        assertEquals(Integer.valueOf(3), result.get(0));
        assertEquals(Integer.valueOf(5), result.get(1));
    }

    @Test
    public void testSortStringValues() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("dog");
        bst.insert("cat");
        bst.insert("elephant");
        bst.insert("ant");
        bst.insert("bear");

        ArrayList<String> result = bst.sort();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("ant");
        expected.add("bear");
        expected.add("cat");
        expected.add("dog");
        expected.add("elephant");

        assertEquals(expected, result);
    }

    @Test
    public void testSortLargeTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] values = { 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45 };

        for (int value : values) {
            bst.insert(value);
        }

        ArrayList<Integer> result = bst.sort();

        // Check if sorted in ascending order
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1) < result.get(i));
        }

        assertEquals(values.length, result.size());
    }
}
