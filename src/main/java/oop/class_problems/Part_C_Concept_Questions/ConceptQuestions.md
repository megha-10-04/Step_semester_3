# Part C — Concept Questions

## Question 1

Compare the time complexity for searching for a specific element in a 1D array when the array is unsorted versus when it is sorted. Explain the fundamental reason for this difference in search efficiency.

### Answer

In an unsorted 1D array, searching for a specific element generally requires checking the elements one by one, giving a time complexity of **O(n)**.

In a sorted array, **binary search** can be used. It repeatedly divides the search space into half, giving a time complexity of **O(log n)**.

The fundamental difference is that sorting provides information about the relative order of elements, allowing binary search to eliminate half of the remaining elements after each comparison.

---

## Question 2

When determining the Big-O complexity of an algorithm, constant multipliers are dropped. Explain why an algorithm performing '2n' operations is still classified as O(n), rather than O(2n), in Big-O notation.

### Answer

Big-O notation describes the **growth rate** of an algorithm as the input size increases. Constant multipliers do not change the growth rate.

For example, if an algorithm performs `2n` operations, the number of operations grows linearly with `n`. Therefore, the constant `2` is ignored and the complexity is written as **O(n)**.

---

## Question 3

Describe how the traversal strategy fundamentally differs between linear data structures (like arrays) and non-linear data structures (like trees), based on how elements are related.

### Answer

In a **linear data structure**, elements are arranged sequentially. Traversal generally proceeds from one element to the next in a single sequence, such as moving through an array from the first element to the last.

In a **non-linear data structure**, elements can have hierarchical or multiple relationships. For example, a tree can have a root with multiple child nodes. Traversal therefore follows a structure-specific strategy, such as visiting nodes using different tree traversal methods.