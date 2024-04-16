package com.pluralsight;
import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        displayScores();
    }
    //display test scores method
    public static void displayScores() {
        int[] testScores = {60,70,80,82,55,90,92,98,20,100};
        int max = 0;
        int min = max;
        int median = 0;
        int average = 0;
        // calculate max
        for (int testScore : testScores) {
            if (max < testScore) {
                max = testScore;
            }
            min = max;
        }
        // calculate min
        for (int testScore : testScores) {
            if (testScore < min) {
                min = testScore;
            }
        }
        // calculate average
        for (int testScore : testScores) {
           average += testScore;
           average = average / testScores.length;
        }
        // find median
        Arrays.sort(testScores);
        int length = testScores.length;
        if(length % 2 == 0) {
            int firstMedian = length/2;
            int secondMedian = (length/2) + 1;
            median = testScores[firstMedian] + testScores[secondMedian];
            median = median / 2;
        }
        else {
            median = length / 2;
        }
        // print results
        System.out.printf("High score: %d\n", max);
        System.out.printf("Low score: %d\n",min);
        System.out.printf("Average: %d\n", average);
        System.out.printf("Median: %d\n", median);
    }
}