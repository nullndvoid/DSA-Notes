/*
 * This source file was generated by the Gradle 'init' task
 */
package xyz.nullndvoid.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MaxHeapTest {
    @Test
    void constructorWorks() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        assertEquals(heap.size, 0);
        assertTrue(heap.isEmpty());
    }

    @Test
    void insertSingleElement() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(5);
        assertEquals(1, heap.size);
        assertFalse(heap.isEmpty());
    }

    @Test
    void insertMultipleElementsNoBubbleUp() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        assertEquals(3, heap.size);
    }

    @Test
    void bubbleUpWhenChildLargerThanParent() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(5);
        heap.insert(10); // Should bubble up to root
        assertEquals(2, heap.size);
    }

    @Test
    void bubbleUpThroughMultipleLevels() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(1);
        heap.insert(3);
        heap.insert(2);
        heap.insert(15); // Should bubble up to root through multiple levels
        assertEquals(4, heap.size);
    }

    @Test
    void parentLeftRightIndexCalculations() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        assertEquals(0, heap.parent(1));
        assertEquals(0, heap.parent(2));
        assertEquals(1, heap.parent(3));
        assertEquals(1, heap.left(0));
        assertEquals(2, heap.right(0));
        assertEquals(3, heap.left(1));
        assertEquals(4, heap.right(1));
    }

    @Test
    void bubbleUpStopsAtRoot() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        assertEquals(3, heap.size);
    }

    @Test
    void getMaxReturnsLargestElement() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        assertEquals(10, heap.getMax());
    }

    @Test
    void deleteMaxRemovesRootElement() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.deleteMax();
        assertEquals(2, heap.size);
    }

    @Test
    void deleteMaxMaintainsHeapProperty() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);
        heap.insert(4);
        heap.insert(2);
        heap.deleteMax();
        assertEquals(8, heap.getMax());
    }

    @Test
    void multipleInsertAndDeleteOperations() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(15);
        heap.insert(10);
        heap.insert(20);
        assertEquals(20, heap.getMax());
        heap.deleteMax();
        assertEquals(15, heap.getMax());
        heap.insert(25);
        assertEquals(25, heap.getMax());
    }

    @Test
    void heapWorksWithStrings() {
        MaxHeap<String> heap = new MaxHeap<>();
        heap.insert("apple");
        heap.insert("zebra");
        heap.insert("banana");
        assertEquals("zebra", heap.getMax());
    }

    @Test
    void complexBubbleUpScenario() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(100); // Should bubble all the way to root
        assertEquals(100, heap.getMax());
        assertEquals(7, heap.size);
    }

    @Test
    void deleteNodeFromMiddleOfHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);
        heap.insert(4);
        heap.insert(2);
        heap.deleteNode(1); // Delete node at index 1 (value 8)
        assertEquals(4, heap.size);
    }

    @Test
    void deleteNodeRequiresBubbleUp() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(8);
        heap.insert(15);
        heap.deleteNode(1); // Delete node at index 1, replacement should bubble up
        assertEquals(3, heap.size);
        assertEquals(15, heap.getMax());
    }

    @Test
    void deleteNodeRequiresBubbleDown() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);
        heap.deleteNode(1); // Delete node at index 1, replacement should bubble down
        assertEquals(4, heap.size);
    }

    @Test
    void deleteMaxOnSingleElementHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(42);
        heap.deleteMax();
        assertEquals(0, heap.size);
        assertTrue(heap.isEmpty());
    }

    @Test
    void deleteMaxOnEmptyHeapThrowsException() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        assertThrows(IndexOutOfBoundsException.class, () -> heap.deleteMax());
    }

    @Test
    void getMaxOnEmptyHeapThrowsException() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        assertThrows(IndexOutOfBoundsException.class, () -> heap.getMax());
    }

    @Test
    void bubbleDownWithOnlyLeftChild() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8); // This creates a scenario where bubble down encounters only left child
        heap.deleteMax();
        assertEquals(8, heap.getMax());
    }

    @Test
    void deleteNodeAtLeaf() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);
        heap.insert(4);
        heap.deleteNode(3); // Delete leaf node
        assertEquals(3, heap.size);
        assertEquals(10, heap.getMax());
    }

    @Test
    void multipleDeleteMaxOperations() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);

        heap.deleteMax();
        assertEquals(15, heap.getMax());
        heap.deleteMax();
        assertEquals(10, heap.getMax());
        heap.deleteMax();
        assertEquals(8, heap.getMax());
        assertEquals(2, heap.size);
    }

    @Test
    void constructorFromListCreatesValidHeap() {
        List<Integer> arr = List.of(4, 10, 3, 5, 1);
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        assertEquals(5, heap.size);
        assertEquals(10, heap.getMax());
    }

    @Test
    void constructorFromEmptyList() {
        List<Integer> arr = List.of();
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        assertEquals(0, heap.size);
        assertTrue(heap.isEmpty());
    }

    @Test
    void constructorFromSingleElementList() {
        List<Integer> arr = List.of(42);
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        assertEquals(1, heap.size);
        assertEquals(42, heap.getMax());
    }

    @Test
    void constructorFromSortedList() {
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        assertEquals(5, heap.size);
        assertEquals(5, heap.getMax());
    }

    @Test
    void constructorFromReverseSortedList() {
        List<Integer> arr = List.of(5, 4, 3, 2, 1);
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        assertEquals(5, heap.size);
        assertEquals(5, heap.getMax());
    }

    @Test
    void heapSortEmptyList() {
        List<Integer> arr = List.of();
        List<Integer> result = MaxHeap.heapsort(arr);
        assertTrue(result.isEmpty());
    }

    @Test
    void heapSortSingleElement() {
        List<Integer> arr = List.of(42);
        List<Integer> result = MaxHeap.heapsort(arr);
        assertEquals(List.of(42), result);
    }

    @Test
    void heapSortSortedList() {
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        List<Integer> result = MaxHeap.heapsort(arr);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    void heapSortReverseSortedList() {
        List<Integer> arr = List.of(5, 4, 3, 2, 1);
        List<Integer> result = MaxHeap.heapsort(arr);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    void heapSortRandomList() {
        List<Integer> arr = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        List<Integer> result = MaxHeap.heapsort(arr);
        assertEquals(List.of(1, 1, 2, 3, 3, 4, 5, 5, 6, 9), result);
    }

    @Test
    void heapSortWithDuplicates() {
        List<Integer> arr = List.of(5, 5, 5, 5, 5);
        List<Integer> result = MaxHeap.heapsort(arr);
        assertEquals(List.of(5, 5, 5, 5, 5), result);
    }

    @Test
    void heapSortWithStrings() {
        List<String> arr = List.of("zebra", "apple", "banana", "cherry");
        List<String> result = MaxHeap.heapsort(arr);
        assertEquals(List.of("apple", "banana", "cherry", "zebra"), result);
    }

    @Test
    void deleteNodeAtRoot() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);
        heap.deleteNode(0); // Should call deleteMax
        assertEquals(2, heap.size);
        assertEquals(8, heap.getMax());
    }

    @Test
    void deleteNodeInvalidIndex() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(10);
        heap.insert(8);
        assertThrows(IndexOutOfBoundsException.class, () -> heap.deleteNode(5));
    }

    @Test
    void deleteNodeFromSingleElementHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(42);
        heap.deleteNode(0);
        assertEquals(0, heap.size);
        assertTrue(heap.isEmpty());
    }

    @Test
    void constructorFromLargeList() {
        List<Integer> arr = List.of(1, 3, 6, 5, 2, 4, 7, 9, 8, 0);
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        assertEquals(10, heap.size);
        assertEquals(9, heap.getMax());
    }

    @Test
    void heapSortPreservesOriginalList() {
        List<Integer> original = List.of(3, 1, 4, 1, 5);
        List<Integer> result = MaxHeap.heapsort(original);
        assertEquals(List.of(3, 1, 4, 1, 5), original); // Original unchanged
        assertEquals(List.of(1, 1, 3, 4, 5), result);
    }

    @Test
    void deleteNodeCausesCorrectBubbleDirection() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(6);
        heap.insert(5);
        heap.insert(3);
        heap.deleteNode(2); // Delete node with value 10, replacement should bubble down
        assertEquals(6, heap.size);
    }

    @Test
    void heapMaintainsPropertyAfterMultipleOperations() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.insert(50);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        heap.insert(20);
        heap.deleteMax();
        heap.insert(60);
        heap.deleteNode(1);
        heap.insert(25);
        assertEquals(60, heap.getMax());
        assertTrue(heap.size >= 0);
    }
}
