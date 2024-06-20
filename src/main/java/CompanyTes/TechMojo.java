import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TechMojo {

    public static List<Integer> targetSum(int[] arr, int target){
        Map<Integer,Integer>
                map=new HashMap<>();
        List<Integer> ans = new ArrayList<>();
         for(int i=0;i<arr.length;i++){
             if(map.containsKey(target-arr[i])){
                 Integer firstIndex = map.get(target-arr[i]);
                 //System.out.println("firstIndex : "+firstIndex);
                 ans.add(firstIndex);
                 ans.add(i);
                 return ans;
             }
             map.put(arr[i],i);
             //System.out.println("Map : "+map);
         }
     return  ans;
    }

    /*public static void main(String[] args) {
        method(null);
    }*/

    public static void method(Object o) {
        System.out.println("Object method");
    }

    public static void method(String s) {
        System.out.println("String method");
    }

   /* public static void main(String[] args) {
       // System.out.println("Ans : "+ targetSum(new int[]{2,7,11,15},9));
        System.out.println("Ans : "+ targetSum(new int[]{3,2,4},6));
    }*/
     public static void main(String[] args) {
      //  Collection c = new HashSet();
      //  print(c);
         String[] strs = {"flower", "carflow", "abcfdel"};

         // Map to store character occurrences
         Map<Character, List<Integer>> charIndexMap = new LinkedHashMap<>();

         // Populate the map
         for (int i = 0; i < strs.length; i++) {
             for (int j = 0; j < strs[i].length(); j++) {
                 char ch = strs[i].charAt(j);
                 List<Integer> indices = charIndexMap.get(ch);
                 if (indices == null) {
                     indices = new ArrayList<>();
                     charIndexMap.put(ch, indices);
                    // System.out.println("Map : "+charIndexMap);
                 }
                 indices.add(i);
             }
         }
         System.out.println("Map : "+charIndexMap);


         // 1. Print common characters
         System.out.print("1. Common characters - ");
         System.out.println("Keys : "+charIndexMap.keySet()+" , value :  "+charIndexMap.values());
         for (char ch : charIndexMap.keySet()) {
             if (charIndexMap.get(ch).size() == strs.length) {
                 System.out.print("Element present : "+ch);
             }else{
                 System.out.println("Element not present : "+ ch);
             }
         }
         System.out.println();

         // 2. Print indexes of characters
         System.out.println("2. Getting the indexes of the characters");
         List<Character> sortedChars = new ArrayList<>(charIndexMap.keySet());
         Collections.sort(sortedChars);
         for (char ch : sortedChars) {
             System.out.print(ch + " - ");
             List<Integer> indices = charIndexMap.get(ch);
             for (int i = 0; i < indices.size(); i++) {
                 if (i > 0) {
                     System.out.print(", ");
                 }
                 System.out.print(indices.get(i));
             }
             System.out.println();
         }
         //----------------------------
         HashMap<String, List<String>> clientHotelMap = new HashMap<>();
         clientHotelMap.put("c1", Arrays.asList("h1", "h2"));
         clientHotelMap.put("c2", Arrays.asList("h2", "h3", "h4"));
         clientHotelMap.put("c3", Arrays.asList("h3", "h2"));
         clientHotelMap.put("c4", Arrays.asList("h1", "h2", "h3", "h4"));
         // Create a HashMap to store the count of hotels per client

         List<String> commonHotels = findCommonHotels(clientHotelMap);

         System.out.println("Output: " + commonHotels);
     }

    /**
     * Find the hotels that are common to all clients
     *
     * @param clientHotelMap Mapping of clients to hotels
     * @return List of common hotels
     */
    public static List<String> findCommonHotels(HashMap<String, List<String>> clientHotelMap) {

        // Create a HashMap to store the count of hotels per client
        HashMap<String, Integer> hotelCountMap = countHotelOccurrences(clientHotelMap);
        return getCommonHotels(hotelCountMap, clientHotelMap.size());
    }

    /**
     * Count the occurrences of each hotel across clients
     *
     * @param clientHotelMap Mapping of clients to hotels
     * @return Map of hotels to their occurrence count
     */
    public static HashMap<String, Integer> countHotelOccurrences(HashMap<String, List<String>> clientHotelMap) {
        HashMap<String, Integer> hotelCountMap = new HashMap<>();
        for (List<String> hotels : clientHotelMap.values()) {
            for (String hotel : hotels) {
                hotelCountMap.put(hotel, hotelCountMap.getOrDefault(hotel, 0) + 1);
            }
        }
        System.out.println("Hoetl Count : "+hotelCountMap);
        return hotelCountMap;
    }

    /**
     * Get the common hotels based on the occurrence count
     *
     * @param hotelCountMap   Map of hotels to their occurrence count
     * @param numberOfClients Total number of clients
     * @return List of common hotels
     */
    public static List<String> getCommonHotels(HashMap<String, Integer> hotelCountMap, int numberOfClients) {
        List<String> commonHotels = new ArrayList<>();
        for (String hotel : hotelCountMap.keySet()) {
            if (hotelCountMap.get(hotel) == numberOfClients) {
                commonHotels.add(hotel);
            }
        }
        return commonHotels;
    }

    public static void print(Collection c) {
        System.out.println("Collection");
    }

    public static void print(Set s) {
        System.out.println("Set");
    }

    public static void print(HashSet hs) {
        System.out.println("HashSet");
    }

    public static void print(Object obj) {
        System.out.println("Object");
    }
}
