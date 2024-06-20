package com.dsa.scaller.string;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtractingWordByLength {
    public static ArrayList<String> extractWordsByLength(String A) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        for(int i=0;i<A.length();i++){
            char data = A.charAt(i);

            if(('A'>= data && data<='Z') || ('a'>= data && data<='z')){
                System.out.print(" Data : "+ data);
                sb.append(data);
            }else{
                ans.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        return ans;
    }

    public static ArrayList<Integer> modifyArrayBasedOnNext(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<A.size();i++){

            if((i+1)<A.size()&&A.get(i)<A.get(i+1)){
                ans.add(A.get(i)+A.get(i+1));
                A.set(i,A.get(i)+A.get(i+1));
                i++;
            }else{
                ans.add(A.get(i));
            }

        }
        return ans;
    }
    //JavaJenkinsAWSSQL
    //JavaMicroservicesSpring BootDistributed SystemsAlgorithms
    public static void main(String[] args) {
      //  System.out.println(extractWordsByLength("Grapes6#"));
        System.out.println(modifyArrayBasedOnNext(new ArrayList<>(Arrays.asList(2,1,3))));
    }
}
