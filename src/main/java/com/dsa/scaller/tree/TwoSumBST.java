package com.dsa.scaller.tree;
import java.util.*;

public class TwoSumBST {
    //Problem Description
    //Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
    //
    //Return 1 to denote that two such nodes exist. Return 0, otherwise.
    //
    //
    //
    //Problem Constraints
    //1 <= size of tree <= 100000
    //
    //1 <= B <= 109
    //
    //
    //
    //Input Format
    //First argument is the head of the tree A.
    //
    //Second argument is the integer B.
    //
    //
    //
    //Output Format
    //Return 1 if such a pair can be found, 0 otherwise.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //         10
    //         / \
    //        9   20
    //
    //B = 19
    //Input 2:
    //
    //
    //          10
    //         / \
    //        9   20
    //
    //B = 40
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 10 + 9 = 19. Hence 1 is returned.
    //Explanation 2:
    //
    // No such pair exists.

    ArrayList<Integer> list = new ArrayList<>();

    public void inorder(TreeNode A) {
        if (A == null) return;
        inorder(A.left);
        list.add(A.val);
        inorder(A.right);
    }

    public int t2Sum(TreeNode A, int B) {
        inorder(A);
        int low = 0;
        int high = list.size() - 1;
        //System.out.println(list);

        while (low < high) {
            int data = list.get(low) + list.get(high);
            //System.out.println("High : "+high+" , low : "+ low+" , Data : "+ data);
            if (data == B) return 1;
            else if (data > B) {
                high--;
            } else {
                low++;
            }
        }

        return 0;
    }
}
