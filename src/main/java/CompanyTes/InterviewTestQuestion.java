import javax.swing.event.ChangeEvent;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class InterviewTestQuestion {

    public static void printOccurance(String data){
        //tatadocomo
        //
        /*
       List<Character> characters = new ArrayList<>();
       for(int i=0;i<data.length();i++){
           characters.add(data.charAt(i));
       }
       */


      //Map<Character,Long> freq =characters.stream().collect(Collectors.groupingBy(Character,counting()));

        Map<Character,Integer> ans = new LinkedHashMap<>();

       for(int i=0;i<data.length();i++){
        ans.put(data.charAt(i),ans.getOrDefault(data.charAt(i),0)+1);
       }

       System.out.println(ans);
    }

    public static void main(String[] args) {
        printOccurance("tatadocomo");
    }
}
