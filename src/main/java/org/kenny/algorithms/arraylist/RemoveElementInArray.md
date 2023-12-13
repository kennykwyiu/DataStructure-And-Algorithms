
## Problem Statement

You are given an array of integers and a target value. Your task is to remove all occurrences of the target value from the array and return the new length.

Write a function `removeTarget` to solve the problem.

**Function Signature:**

```java
public int removeTarget(int[] nums, int target)
```

**Input:**

- An array of integers `nums` (1 <= nums.length <= 10^4)
- An integer `target` (-10^9 <= target <= 10^9)

**Output:**

- An integer representing the new length of the modified array.

**Example:**

```java
int[] nums = {3, 5, 2, 5, 6, 5};
int target = 5;

int length = removeTarget(nums, target);
```

**Output:**

The modified array after removing all occurrences of the target value will be `{3, 2, 6}`. Therefore, the new length will be `3`.

---
