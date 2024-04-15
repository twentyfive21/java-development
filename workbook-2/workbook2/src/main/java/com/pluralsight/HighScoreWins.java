package com.pluralsight;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HighScoreWins {
    // main method
    public static void main(String[] args) {
        getScoreInfo();
    }
    // get user input method
    public static void getScoreInfo () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide the game details: ");
        String fullMatch = scanner.nextLine();
        formatMatch(fullMatch);
    }
    public static void formatMatch (String fullMatch) {
        // declare String[] to format team comparisons
        String[] teams;
        String[] splitTeams;
        String[] splitScores;

        // split into correct sections
        teams = fullMatch.split(Pattern.quote("|"));
        splitTeams = teams[0].split(Pattern.quote(":"));
        splitScores = teams[1].split(Pattern.quote(":"));

        // final split into 4 variables for comparisons
        String teamOne = splitTeams[0];
        String teamTwo = splitTeams[1];
        int teamOneScore = Integer.parseInt(splitScores[0]);
        int teamTwoScore = Integer.parseInt(splitScores[1]);

        // send to last method to check & display winner
        checkWinner(teamOne, teamTwo, teamOneScore, teamTwoScore);
    }
    // check winner method
    public static void checkWinner (String teamOne,String teamTwo,int teamOneScore,int teamTwoScore) {
        if (teamOneScore > teamTwoScore) {
            System.out.printf("!!! Winner is %s !!! \n", teamOne);
            System.out.printf("!!! With %d points!!", teamOneScore);
        } else {
            System.out.printf("!!! Winner is %s !!! \n", teamTwo);
            System.out.printf("!!! With %d points!!", teamTwoScore);
        }
    }
}
// https://www.baeldung.com/java-string-split-multiple-delimiters