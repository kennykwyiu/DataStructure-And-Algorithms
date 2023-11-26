**Problem:**

You are given an array of integers and you need to calculate the fractions of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with 6 places after the decimal.

**Function Signature:**

```python
def plusMinus(arr: List[int]) -> None:
    pass

```

**Input Format:**

The first line contains an integer, `n`, denoting the size of the array.
The second line contains `n` space-separated integers describing an array of numbers `arr` (a[0], a[1], ..., a[n-1]).

**Constraints:**

- 0 < n <= 100
- 100 <= arr[i] <= 100

**Output Format:**

Print the following lines, each to 6 decimal places:

1. The fraction of positive numbers in the array.
2. The fraction of negative numbers in the array.
3. The fraction of zeros in the array.

**Sample Input:**

```
6
-4 3 -9 0 4 1

```

**Sample Output:**

```
0.500000
0.333333
0.166667

```

**Explanation:**

There are 3 positive numbers, 2 negative numbers, and 1 zero in the array.
The fractions of positive numbers, negative numbers, and zeros are 3/6 = 0.500000, 2/6 = 0.333333, and 1/6 = 0.166667, respectively.

Let me know if you have any further questions or if there's anything else I can assist you with!