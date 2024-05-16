package com.pluralsight.workingWithInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<>();
        myFamily.add( new Person("Dana", "Wyatt", 63) );
        myFamily.add( new Person("Zachary", "West", 31) );
        myFamily.add( new Person("Elisha", "Aslan", 14) );
        myFamily.add( new Person("Beth", "Aslan", 14) );
        myFamily.add( new Person("Ian", "Austin", 16) );
        myFamily.add( new Person("Zephaniah", "Hughes", 9) );
        myFamily.add( new Person("Ezra", "Aiden", 17) );

        // call collections to sort and overed the compareTo method
        Collections.sort(myFamily);
        // then compare by age
        myFamily.sort(Comparator.comparing(Person::getAge));
        // print out the sorted list
        for(Person person : myFamily){
            System.out.println(person);
        }
    }

}
