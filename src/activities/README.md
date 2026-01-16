<h1 align="center">📌 Activity – Sorting & Selection (Java)</h1>

![Course](https://img.shields.io/badge/Data%20Structures-Lab-%2373c2fb)
![Topic](https://img.shields.io/badge/Topic-Sorting%20&%20Selection-%23ffb74d)
![Language](https://img.shields.io/badge/Language-Java-%23e57373)
![Level](https://img.shields.io/badge/Level-Intermediate-%2381c784)

---

## 🎯 Activity Objectives

This activity is designed to assess your **conceptual understanding** and **practical implementation skills of sorting algorithms and selection problems**.

By completing this activity, you will demonstrate your ability to:

- Apply sorting algorithms correctly (Bubble, Selection, Insertion, Merge, Quick)
- Understand and implement array-based problem solving
- Analyze time and space complexity
- Apply sorting to solve selection and pair problems efficiently

---

## 📚 Background

Sorting is a **core topic in data structures**, providing a foundation for **efficient searching, selection, and array manipulation**.
In this activity, you will solve problems using **sorting as a tool**, leveraging **Merge Sort** for correctness and efficiency.

---

## 🛠 General Rules & Constraints

❌ Do NOT use any Java built-in sort methods (`Arrays.sort()`, etc.) <br>
✅ Implement **sorting algorithms manually** <br>
✅ Time complexity must be considered <br>
❌ Avoid hardcoding solutions <br>
✅ Use clean and readable code structure <br>
✅ Test your solutions on **different types of arrays** (random, sorted, reverse, duplicates)

---

## 🧪 Activity Tasks

Below are the tasks along with references to the **solution files**, fully commented and explained.

---

### Task 1: Find the k-th Smallest Element in an Array

#### 📌 Objective:

Return the **k-th smallest element** in an unsorted array.

#### 📘 Key Insight:

- Sort the array first
- Access the `(k-1)`-th index after sorting

#### 📥 Input:

- Array of integers
- Integer `k`

#### 📤 Output:

- The k-th smallest element

#### 📌 Expected Complexity:

`O(n log n)` using Merge Sort

**Solution File:** [FindKthSmallest.java](FindKthSmallest.java)

---

### Task 2: Find the Maximum Difference

#### 📌 Objective:

Find the maximum difference arr[j] - arr[i] such that j > i and return the pair along with the difference.

#### 📘 Key Insight:

- Track the **minimum value** while iterating
- Update the maximum difference when possible

#### 📥 Input:

- Array of integers

#### 📤 Output:

- `int[] { maxDifference, firstElement, secondElement }`

#### 📌 Expected Complexity:

`O(n)`

**Solution File:** [MaxDifference.java](MaxDifference.java)

---

### Task 3: Find All Pairs with Sum = Target

#### 📌 Objective:

Find all pairs `(a, b)` such that `a + b = target`.

#### 📘 Key Insight:

- Sort the array first
- Use **two-pointer technique** for efficient lookup

#### 📥 Input:

- Array of integers
- Integer `target`

#### 📤 Output:

- All pairs of numbers summing to target

#### 📌 Expected Complexity:

`O(n log n)` for sorting + `O(n)` for two-pointer traversal

**Solution File:** [PairsWithSum.java](PairsWithSum.java)

---

### Task 4: Find the Missing Number in a Sequence

#### 📌 Objective:

Identify the missing number in an array containing integers from 1 to n with **exactly one missing number**.

#### 📘 Key Insight:

- Sort the array
- Compare expected sequence with actual array values

#### 📥 Input:

- Array of integers from 1 to n with one missing

#### 📤 Output:

- The missing integer

#### 📌 Expected Complexity:

`O(n log n)` due to sorting

**Solution File:** [FindMissingNumber.java](FindMissingNumber.java)

---

## ⚠️ Common Mistakes to Avoid

- Forgetting to sort arrays before applying selection logic
- Off-by-one errors in indexing (k-th element vs array indices)
- Not handling duplicate or edge case values
- Modifying array incorrectly during traversal
- Using inefficient brute-force approaches

---

## ✅ Learning Outcomes

After completing this activity, you should be able to:

- Implement **core sorting algorithms** in Java
- Solve **selection and array-based problems efficiently**
- Analyze **time and space complexity** for array operations
- Apply **algorithmic thinking** to real-world problem solving

---

> Good luck! Focus on **understanding the algorithms and problem-solving patterns**, not just copying solutions.
