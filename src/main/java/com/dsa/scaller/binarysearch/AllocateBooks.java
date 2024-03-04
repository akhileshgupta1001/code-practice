package com.dsa.scaller.binarysearch;

import java.util.*;

//Problem Description
//Given an array of integers A of size N and an integer B.
//
//The College library has N books. The ith book has A[i] number of pages.
//
//You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
//
//A book will be allocated to exactly one student.
//Each student has to be allocated at least one book.
//Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
//Calculate and return that minimum possible number.
//
//NOTE: Return -1 if a valid assignment is not possible.
//
//
//
//Problem Constraints
//1 <= N <= 105
//1 <= A[i], B <= 105
//
//
//
//Input Format
//The first argument given is the integer array A.
//The second argument given is the integer B.
//
//
//
//Output Format
//Return that minimum possible number.
//
//
//
//Example Input
//Input 1:
//A = [12, 34, 67, 90]
//B = 2
//Input 2:
//A = [12, 15, 78]
//B = 4
//
//
//Example Output
//Output 1:
//113
//Output 2:
//-1
//
//
//Example Explanation
//Explanation 1:
//
//There are two students. Books can be distributed in following fashion :
//1)  [12] and [34, 67, 90]
//    Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
//2)  [12, 34] and [67, 90]
//    Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
//3)  [12, 34, 67] and [90]
//    Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
//    Of the 3 cases, Option 3 has the minimum pages = 113.
//Explanation 2:
//Each student has to be allocated at least one book.
//But the Total number of books is less than the number of students.
//Thus each student cannot be allocated to atleast one book.
//
//Therefore, the result is -1.

public class AllocateBooks {
    public static boolean isAllocationPossible(List<Integer> bookPages, int totalStudents, int maxPagesPerStudent) {
        int studentCount = 1;
        int pagesSum = 0;

        for (int i = 0; i < bookPages.size(); i++) {
            if (pagesSum + bookPages.get(i) <= maxPagesPerStudent) {
                pagesSum += bookPages.get(i);
            } else {
                studentCount++;
                if (studentCount > totalStudents || bookPages.get(i) > maxPagesPerStudent) {
                    return false;
                }
                pagesSum = bookPages.get(i);
            }
            if (studentCount > totalStudents) {
                return false;
            }
        }
        return true;
    }

    public static int allocateBooks(List<Integer> bookPages, int totalBooks, int totalStudents) {
        int n = bookPages.size();
        if (n < totalStudents) {
            return -1;
        }
        int minPages = 0;
        int totalPages = 0;

        for (int i = 0; i < totalBooks; i++) {
            totalPages += bookPages.get(i);
        }
        int maxPages = totalPages;
        int result = -1;


        while (minPages <= maxPages) {
          //  int currentAllocation = minPages + (maxPages - minPages) / 2;
            int currentAllocation = (minPages + maxPages)/2;
            if (isAllocationPossible(bookPages, totalStudents, currentAllocation)) {
                result = currentAllocation;
                maxPages = currentAllocation - 1;
                System.out.println("Possible result : " +result);
            } else {
                minPages = currentAllocation + 1;
            }
            // currentAllocation = minPages + (maxPages - minPages) / 2;
        }
        return result;
    }


    public static int books(ArrayList<Integer> A, int B) {
        return allocateBooks(A, A.size(), B);
    }

    public static boolean isAllocationPossible(int[] A, int toatlSutudent, int currentAlocation){
        int studentCount =1;
        int pageSum=0;

        for(int i=0;i<A.length;i++){
            if(pageSum+A[i]<=currentAlocation){
                pageSum+=A[i];
            }else{
                studentCount++;
                if(studentCount> toatlSutudent || A[i]>currentAlocation){
                    return false;
                }
                pageSum=A[i];
            }

            if(studentCount> toatlSutudent){
                return false;
            }
        }
        return true;
    }
    public static int books(int[] A, int B) {
        int low =0;
        int high = 0;
        for(int i=0;i<A.length;i++){
            high += A[i];
        }
        int totalStudent = B;
        int res =-1;

        while(low<=high){
            int mid = (low + high)/2;

            if(isAllocationPossible(A,totalStudent,mid)){
                //System.out.println("Possible soultion : " +mid);
                res = mid;
                high = mid-1;
                 System.out.println("Possible soultion : " +res);

            }else{
                low = mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
       System.out.println(books(new ArrayList<>(Arrays.asList(31,14,19,75)),12));
       // System.out.println(books(new ArrayList<>(Arrays.asList(12,34,67,90)),2));

        System.out.println(books(new int[] {31,14,19,75},12));
    }
}
