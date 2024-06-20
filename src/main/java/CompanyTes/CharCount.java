package CompanyTes;

import java.util.*;

interface CharCountService{
    public abstract void charCount(String str);
}


class StackImp {

    private int stackSize;
    private int top =-1;
    int[] array = null;

    public StackImp(int size){
        this.stackSize=size;
        this.array= new int[size];
        Arrays.fill(array,Integer.MIN_VALUE);
    }

    public boolean isEmpty(){
        return array.length==0;
    }

    public int peek(){
        if(top==-1){
            System.out.println("Peek  : -1");
            return -1;
        }

        System.out.println("Peek  : "+ array[top]);

        return array[top];
    }

    public void push(int iteam){

       top++;
       if(top>array.length){
           System.err.println("Stack size is already full");
           throw new RuntimeException("Stack size is already full");
       }
       array[top]=iteam;

        System.out.println("Array : "+ Arrays.toString(array));
    }

    public int pop(){
        if(top==-1){
            System.err.println("Stack is already empty");
            throw new RuntimeException("Stack is already empty");
        }
        int popElement =array[top];
        array[top]=Integer.MIN_VALUE;
        top--;
        System.out.println("Array : "+ Arrays.toString(array));
        return popElement;
    }
}
public class CharCount {
    public static void main(String[] args) {
        /*
        CharCountService charCountService = (s)->{
           // List<String> str = new ArrayList<>();
            //str.add(s);
         //   ..

          Map<Integer,Long> map=  s.chars().boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
          for(Map.Entry<Integer,Long> data :map.entrySet()){
             // if()
              System.out.println(((char)(data.getKey().intValue()) +" -> "+data.getValue()));
            }
         // System.out.println(map);
        };
        charCountService.charCount("Hello World");

         */
        StackImp stackImp= new StackImp(5);
        // Fist Test cases
        stackImp.push(1);
        stackImp.push(2);
        stackImp.push(3);
        stackImp.peek();
        stackImp.pop();
        stackImp.pop();
        stackImp.pop();
        stackImp.pop();
    }


}
