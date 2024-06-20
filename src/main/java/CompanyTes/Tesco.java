import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.chrono.JapaneseEra.values;

class Shift {
    private int
            startTime;
    private int
            endTime;

    public Shift(int startTime, int endTime) {
        this.startTime =
                startTime;
        this.endTime =
                endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime =
                startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime =
                endTime;
    }

    @Override
    public String toString() {
        return "Merged Shifts: " + startTime + "-" + endTime;
    }
}

public class Tesco {

    public static List<Shift> getShift(List<Shift> workingShift) {
        List<Shift> shifts = workingShift.stream()
                .sorted(Comparator.comparing(Shift::getStartTime))
                .collect(Collectors.toList());

        List<Shift> ans = new ArrayList<>();

        int startTime = shifts.get(0).getStartTime();
        int endTime = shifts.get(0).getEndTime();

        for (int index = 1; index < shifts.size(); index++) {
            Shift current = shifts.get(index);

            if (current.getStartTime() <= endTime) {
                endTime = Math.max(endTime, current.getEndTime());
            } else {
                ans.add(new Shift(startTime, endTime));
                startTime = current.getStartTime();
                endTime = current.getEndTime();
            }
        }
        ans.add(new Shift(startTime, endTime));

        return ans;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }

    public Interval[] merge(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->(a.start-b.start));
        int startTime=intervals[0].start;
        int endTime = intervals[0].end;
        List<Interval> ans = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<=endTime){
                endTime= Math.max(endTime,intervals[i].end);
            }else{
                ans.add(new Interval(startTime,endTime));
                startTime = intervals[i].start;
                endTime = intervals[i].end;
            }
        }

        return ans.toArray(new Interval[0]);

    }

    public static void main(String[] args) {
        System.out.println(getShift(Arrays.asList(new Shift(10,12),new Shift(12,14),new Shift(11,15),new Shift(16,19),new Shift(7,23))));
       // System.out.println(getShift(Arrays.asList(new Shift(1,3),new Shift(8,10),new Shift(2,6),new Shift(15,18))));

    }

    public ArrayList<ArrayList<String>> getAnagrams(ArrayList<String> A) {
        Map<Integer,ArrayList<String>> group = new LinkedHashMap<>();
        for(String data : A){
            int ans =0;

            for(int i=0;i<data.length();i++){
                ans+= (int) data.charAt(i);
            }
            //map.put(ans,map.get(ans,new ArrayList<String>()))
            if(group.containsKey(ans)){
                ArrayList<String> existingSubAns= group.get(ans);
                existingSubAns.add(data);
                group.put(ans,existingSubAns);
            }else{
                ArrayList<String>  subAns = new ArrayList<>();
                subAns.add(data);
                group.put(ans,subAns);
            }
        }
        ArrayList<ArrayList<String>>  ans = new ArrayList<>();

        for(Map.Entry<Integer,ArrayList<String>> map : group.entrySet()){

            ans.addAll(Collections.singleton(map.getValue()));
        }

        return ans;

    }


}
