package com.pluralsight.workingWithInterfaces;

// comparable must be passed a object to compare
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Person otherPerson) {
        // First, compare last names
        int lastNameComparison = this.lastName.compareTo(otherPerson.lastName);
        /**
         * If this object is less than the other object, the method should return a negative integer.
         * If this object is equal to the other object, the method should return 0.
         * If this object is greater than the other object, the method should return a positive integer.
         */

        // If last names are the same, compare first names
        if (lastNameComparison == 0) {
            return this.firstName.compareTo(otherPerson.firstName);
        } else {
            return lastNameComparison;
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
