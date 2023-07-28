package com.techelevator;

public class HomeworkAssignment {
    private int possibleMarks;
    private int earnedMarks;
    private String submitterName;
    private String letterGrade;
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public String getLetterGrade() {
        if(earnedMarks >= 90) {
            return "A";
        }
        else if(earnedMarks >= 80 && earnedMarks < 90){
            return "B";
        }
        else if(earnedMarks >= 70 && earnedMarks < 80){
            return "C";
        }
        else if(earnedMarks >= 60 && earnedMarks < 70){
            return "D";
        }
        else {
            return "F";
        }

    }


    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }
}
