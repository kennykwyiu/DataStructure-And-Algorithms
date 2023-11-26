# Mini-Max Sum

Given an array of 5 integers, find the minimum and maximum possible sums that can be obtained by summing exactly 4 of the 5 integers.

## Function Signature

```java
void miniMaxSum(List<Integer> arr)

```

## Input

The function `miniMaxSum` takes in a single parameter:

- `arr`: A list of 5 integers.

## Output

The function should print two space-separated integers on a new line:

- The minimum sum of 4 of the 5 integers.
- The maximum sum of 4 of the 5 integers.

## Example

Input

```
arr = [1, 2, 3, 4, 5]

```

Output

```
10 14

```

## Explanation

The minimum sum can be obtained by summing all the elements except the largest element (5 + 4 + 3 + 2 = 14).
The maximum sum can be obtained by summing all the elements except the smallest element (1 + 2 + 3 + 4 = 10).

---
