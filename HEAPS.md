# Heaps

VERY AWESOME DSA NOTES BY JH

<img src="prime.png" alt="The Primeagen" width="40"/>
<img src="cazzo.png" alt="Crying fuck" width="40"/>
<img src="prime.png" alt="The Primeagen" width="40"/>
<img src="cazzo.png" alt="Crying fuck" width="40"/>
<img src="prime.png" alt="The Primeagen" width="40"/>
<img src="cazzo.png" alt="Crying fuck" width="40"/>
<img src="prime.png" alt="The Primeagen" width="40"/>
<img src="cazzo.png" alt="Crying fuck" width="40"/>
<img src="prime.png" alt="The Primeagen" width="40"/>

A heap is an ADT that maintains a collection of items with associated priority values, and can get and remove the item with highest priority efficiently.

New items with arbitrary priorities can be added at any time.

## Operations

`EmptyHeap` will return a new, empty heap.

* insert(key)
* get_max
* delete_max
* heapify_down

We typically store the keys/items in an array, similar to how we could store and index a binary tree.

I will write some Heap code and tests in [MaxHeap.java](lib/src/main/java/xyz/nullndvoid/dsa/MaxHeap.java).

# Heapify Down

This has a time complexity of O(n).

The workings are as follows.

Take a nearly complete (or complete, yet invalid) max heap formed by an array of N elements.


![Original list passed into heapify down](HeapifyOriginalList.drawio.svg)

Above: a visualisation of the (invalid) heap formed by this array.

* Consider that `bubble_down` has no work to be done on the leaf nodes.
* Swapping two elements is a constant-time operation, for this we use $C$.
* Each 'layer' has a maximum distance it may move. The root can move down the whole tree. This is however the worst case, and layers below this will move at most less than this.
* Take $h \approx \log n$ to be the height of the tree.

If you have convinced yourself of these things, then we could write the total `heapify_down` cost like so:

$$Cost = C\left[n/4 + 2n/8+3n/16+\dots+h\right]$$

Now, we may take $n/4$ to be $2^k$ for some $k$. This means $n = 2^{k + 2}$ so $h = \log n = k + 2$

$$Cost = C2^k\left[1 + 2/2+3/4+\dots+\frac{k+1}{2^k}\right]$$

The series in brackets is bounded by the infinite geometric series:

$$\sum_{i=1}^{\infty} \frac{i}{2^{i-1}} = \sum_{i=1}^{\infty} i \cdot \left(\frac{1}{2}\right)^{i-1}$$

This infinite series converges to exactly **4** (using the formula for the sum of $i \cdot r^{i-1}$).

Since our finite series is bounded by 4:

$$Cost \leq C \cdot 2^k \cdot 4 = 4C \cdot 2^k$$

Substituting back $2^k = n/4$:

$$Cost \leq 4C \cdot \frac{n}{4} = C \cdot n$$

Therefore, **heapify is O(n)**.

## Why This Matters

- **Building a heap from scratch**: O(n) instead of O(n log n) if we inserted one by one
- **Heapsort**: The initial heapify step is O(n), then we do n deletions of O(log n) each
- **Most work happens at bottom**: ~50% of nodes are leaves (do nothing), ~25% move at most 1 level, etc.
