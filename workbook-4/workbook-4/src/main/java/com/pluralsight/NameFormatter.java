package com.pluralsight;

import java.util.regex.Pattern;

public class NameFormatter {

    private NameFormatter() {

    }

    public static String format (String firstName, String lastName){
        return String.format("%s, %s", lastName, firstName);
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix){
        return String.format("%s, %s. %s %s, %s", lastName, prefix, firstName, middleName,suffix);
    }

    public static String format(String fullName){
        String[] splitName = fullName.split(Pattern.quote(" "));
        return String.format("%s, %s", splitName[1], splitName[0]);
    }
}

