package com.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8FAQ {

    public  static  Map<String,Long> getFrequencyCount(String str){
        return Arrays.stream(str.split("")).filter(data->!" ".equals(data)).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
    }

    public  static void getDuplicateChars(String str){

        List<String>
                collect =
                Arrays.stream(str.split(""))
                        .filter(data -> !" ".equals(data))
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet().stream().filter(data -> data.getValue() > 1)
                        .map(data -> data.getKey())
                        .collect(Collectors.toList());
        System.out.println("Duplicate : "+ collect);
    }

    public static  Integer getSecondHighestNumber(int[] arr){
        return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
    }
    public static void main(String[] args) {
      //  System.out.println(getFrequencyCount("Akhilesh Kumar Gupta"));

        getDuplicateChars("Akhilesh Kumar Gupta");

        System.out.println(getSecondHighestNumber(new int[]{3,4,5}));

    }
}
