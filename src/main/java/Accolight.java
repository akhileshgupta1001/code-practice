import java.util.*;
import java.util.stream.Collectors;


class Student{
    private String name;
    private String batch;
    private String mobile;
    private Student(Builder builder){
        this.name=builder.name;
        this.batch=builder.batch;
        this.mobile=builder.mobile;
    }
    public  static  Builder builder(){
        return  new Builder();
    }

   // Getter

   static class Builder{

        private String name;
        private String batch;
        private String mobile;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name =
                    name;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch =
                    batch;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Builder setMobile(String mobile) {
            this.mobile =
                    mobile;
            return this;
        }

        public Student build(){
            this.name = name;
            this.mobile=mobile;
            this.batch=batch;
            return new Student(this);
        }
    }


}
public class Accolight {
    //String [] strArr = {"eat", "ate","tea", earth};
    //String str = aet;--> 3
    //  ["aet","aet","aet","earth"]
      // group ->
    //"eat", "ate","tea", earth  -> ate , eat , earth , tea
      public static int count(List<String> str,String targetSting){
          str.stream().collect(Collectors.groupingBy(data->{
              char[] dataArr=data.toCharArray();
              Arrays.sort(dataArr);
              return String.valueOf(dataArr);
          }));

          System.out.println("Input : "+str);
          Map<String,Integer> map = new HashMap<>();
            for( String data:str){
                char[] charData = data.toCharArray();
                Arrays.sort(charData);
                map.put(String.valueOf(charData),map.getOrDefault(String.valueOf(charData),0)+1);
            }
             int ans =0;
            for(Map.Entry<String,Integer> mapData: map.entrySet()){
                 if(ans<mapData.getValue()){
                     ans = mapData.getValue();
                 }

            }
          System.out.println("Map : "+map);
            return (int) map.get(targetSting);
           // return ans;

           // return map.entrySet().stream().max(Map.Entry.comparingByValue()).;
      }

    public static void main(String[] args) {
        String [] strArr = {"eat", "ate","tea", "earth","aehtr"};
        String str = "heart";

        // count(new ArrayList<>(Arrays.asList("eat", "ate","tea", "earth")));
        System.out.println("Ans : "+ count(new ArrayList<>(Arrays.asList("eat", "ate","tea", "earth","aehtr")),str));

     Student.builder().setMobile("AKHILESH").build();
    }
}
