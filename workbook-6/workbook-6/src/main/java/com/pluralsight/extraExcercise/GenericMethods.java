package com.pluralsight.extraExcercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* EXERCISE GIVEN BY EZRA

Write a Generic Class that contains the following generic methods and Distinct elements in an ArrayList:
1. Return a new ArrayList The list contains the non-duplicate elements from the original list.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)

2. Write a method to create a generic method that takes 2 lists of the same type & merges them into a single list.
    This method alternates the elements of each list.

3. Write a method to create a generic method that takes a list of any type
    & returns it as a new list with the elements in reverse order.

* */
public class GenericMethods {

    // Method to remove duplicates from an ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Create a new HashSet from the input list. HashSet automatically removes any duplicate elements
        // Set<E> set = new HashSet<>(list);

        // Convert the HashSet back to an ArrayList and return it
        // This ensures the result is an ArrayList without duplicates
        // return new ArrayList<>(set);

        // another way
        ArrayList<E> newList = new ArrayList<>();
        for (E item : list){
            if(!newList.contains(item)){
                newList.add(item);
            }
        }
        return newList;
    }


    // Method to merge two lists by alternating their elements
    public static <E> ArrayList<E> mergeAlternately(ArrayList<E> list1, ArrayList<E> list2) {
        /*
        // list 1
        list2.add(4);
        list2.add(5);

        // list 2
        list3.add(7);
        list3.add(8);
        list3.add(6);
        */
        // Create a new ArrayList to store the merged elements from list1 and list2
        ArrayList<E> mergedList = new ArrayList<>();

        // Get the sizes of both input lists
        int size1 = list1.size();
        int size2 = list2.size();

        // Determine the maximum size between list1 and list2
        int maxSize = Math.max(size1, size2);
        System.out.println("max size: " + maxSize); // 3

        // Iterate through each index up to the maximum size
        for (int i = 0; i < maxSize; i++) {
            // Add elements from list1 to the mergedList if the index is within the bounds of list1
            // 2
            if (i < size1) {
                mergedList.add(list1.get(i));
            }
            // Add elements from list2 to the mergedList if the index is within the bounds of list2
            // 3
            if (i < size2) {
                mergedList.add(list2.get(i));
            }
        }

        // Return the mergedList containing elements from both lists
        return mergedList;
    }


    // Method to reverse the elements of a list
    public static <E> ArrayList<E> reverseList(ArrayList<E> list) {
        // Create a new ArrayList to store the reversed elements
        ArrayList<E> reversedList = new ArrayList<>(list.size());

        // Iterate through the input list in reverse order
        for (int i = list.size() - 1; i >= 0; i--) {
            // Add each element from the input list to the reversed list
            reversedList.add(list.get(i));
        }

        // Return the reversed list
        return reversedList;
    }


    // Main method for testing
    public static void main(String[] args) {
        System.out.println();
        // Test removeDuplicates
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        list1.add(3);
        System.out.println("Original List: " + list1);
        System.out.println("After removing duplicates: " + removeDuplicates(list1));

        System.out.println();
        // Test mergeAlternately
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(6);
        System.out.println("List 1: " + list2);
        System.out.println("List 2: " + list3);
        System.out.println("Merged List: " + mergeAlternately(list2, list3));
        System.out.println();

        // Test reverseList
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("b");
        list4.add("c");
        System.out.println("Original List: " + list4);
        System.out.println("Reversed List: " + reverseList(list4));
    }
}

