package com.dsa.geeksforgeek.recursuion;

public class JosephProblem {

    public static int josephProblem(int numberOfPeople,int killPosition){
        if(numberOfPeople==1)
            return 0;

        return ((josephProblem(numberOfPeople-1,killPosition) + killPosition ) % killPosition);
    }

    public static void main(String[] args) {
        System.out.println(josephProblem(5,3));
    }
}
