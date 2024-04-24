package Mod03;
import java.util.ArrayList;

public class Practice {

    /*
    - The remove() method is used to remove an element based
    on its position. Once the item is removed, all elements below it
    in the list shift forward in the list and the size is reduced by one.
    ex. kids.remove(1) removes at index 1.

   - kids.add("Natalie"); The add() method is used to add an element to the end of
    the collection

    -The get() method is used to access an element by its position
     NOTE: To use the get() method in a loop, you can use the
     size() methods to return the number of elements.

    - The set() method is used to update an element,
     Specify its position & it's new value ex. kids.set(2, "Zach");

   - Collections.sort() -sorting an ArrayList. It can sort alphabetically or numerically

   - clear() - clearing all items in an ArrayList
    */

    public static void main(String[] args) {
        // Because it is a generic class, you must specify the type of,
        // data that it manages
        ArrayList<String> kids = new ArrayList<String>();
        kids.add("Natalie");
        kids.add("Brittany");
        kids.add("Zachary");
        kids.add("Tina");

        // print the list currently
        System.out.println("Before Brittany removed: ");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println((i + 1) + " : " + kids.get(i)); }

        // removed brittany
        kids.remove(1);
        System.out.println("After Brittany removed: ");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println((i + 1) + " : " + kids.get(i)); }

        // adding Brittany back in
        kids.add("Brittany");
        System.out.println("After Brittany re-added: "); for (int i = 0; i < kids.size(); i++) {
            System.out.println((i + 1) + " : " + kids.get(i)); }
    }
}