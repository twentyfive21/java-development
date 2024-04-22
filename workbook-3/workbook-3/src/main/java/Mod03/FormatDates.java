package Mod03;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        // get local date time and day and save it
        LocalDateTime today = LocalDateTime.now();
        // choose format
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm");
        // call the format method on the local date and pass the format wanted
        String formattedDate = today.format(fmt);
        // Sunday, Sep 5, 2021  10:02 format
        System.out.println(formattedDate);

        // challenge format 5:02 on 05-Sep-2021
        // create time format
        DateTimeFormatter challengeTime = DateTimeFormatter.ofPattern("HH:mm");
        // create date format
        DateTimeFormatter challengeDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        // format the time
        String challengeTimeFormat = today.format(challengeTime);
        // format the date
        String challengeDateFormat = today.format(challengeDate);
        // final string
        String challengeString =  challengeTimeFormat + " on " + challengeDateFormat;
        System.out.println(challengeString);
    }
}
