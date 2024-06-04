package org.kenny.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem:
You have an empty text editor. Initially, the editor contains an empty string. You are given q operations that can be performed on the editor. Each operation is described by a type and an optional argument.

The following operations are supported:

1 x: Append string x to the end of the editor's current string.
2 k: Delete the last k characters from the editor's current string.
3 k: Print the k-th character of the editor's current string.
4: Undo the last operation of type 1 or 2, reverting the editor back to the state before that operation.
Write a function performOperations to process the given operations and return the output of all the "print" operations (type 3) concatenated together.

Function Signature:
String performOperations(List<String> operations)

Input:

A list of strings operations where each string represents an operation. The length of the list is between 1 and 10^5.
Each operation string is a space-separated string containing the operation type and an optional argument x or k. The argument is an integer and only applicable for operations of type 2 and 3.
The integer arguments x and k are positive and will not exceed the length of the editor's current string.
Output:

Return a string containing the output of all the "print" operations (type 3) concatenated together.
Example:
Input:
["1 abc", "3 2", "2 1", "3 1"]
Output:
"b"

Explanation:

Operation 1: Append "abc" to the empty string. Current string = "abc".
Operation 2: Print the 2nd character of the current string. Output = "b".
Operation 3: Delete the last character from the current string. Current string = "ab".
Operation 4: Print the 1st character of the current string. Output = "b".
Note:

The editor's string is initially empty.
The "print" operations (type 3) are only performed on valid indices of the current string.
The "undo" operation (type 4) is only performed when there is a valid previous operation to undo.
 */
public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> operations = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            operations.add(scanner.nextLine());
        }

        String result = performOperations(operations);
        System.out.println(result);

        scanner.close();
    }

    private static String performOperations(List<String> operations) {
        return null;
    }


}
