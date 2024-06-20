import java.util.*;


class CustomMap<String,Intger> {
    int capcity;

    public List<EntryMap> entries;


    class EntryMap{
        int hasCode;
        Entry entry;

        EntryMap(int hasCode, Entry entry){
            this.hasCode=hasCode;
            this.entry=entry;
        }
    }
    class Entry{
        String key;
        Intger value;

        Entry(String key, Intger value){
            this.key=key;
            this.value=value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry
                    entry =
                    (Entry) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }


    CustomMap(int capcity){
        this.capcity=capcity;
        this.entries= new ArrayList<>(capcity);
    }

    public void put(String key, Intger value){
        // Hash , Value
        // hasCOde , -> value
        entries.add(new EntryMap(Objects.hash(key),new Entry(key,value)));
    }
    public Intger get(String ket) throws Exception{

        if(this.entries.size()>0){

        }
        throw  new RuntimeException("Eleemnt not present");
    }
}
public class CMMMTest {

   /* public static Map<Map<Integer, Integer>, List<Integer>> getMapCount(List<Integer> data){

        return data.stream().filter(iteam->iteam %2==0).collect(Collectors.groupingBy(itm->{
            Map<Integer,Integer> updatedMap = new LinkedHashMap<>();
            updatedMap.put(itm,itm);
            return updatedMap;
        }));

        data.stream().filter(iteam->iteam %2==0).map(itm->{

            return null;
        }).collect(Collectors.toMap());
    }*/

    public static void main(String[] args) {
       // System.out.println(getMapCount(Arrays.asList(1,2,3,4,5,6)));
    }
}
