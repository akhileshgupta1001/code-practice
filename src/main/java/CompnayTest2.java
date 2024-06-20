public class CompnayTest2 {
    //6.  Find an index such that the sum of elements at lower indexes is equal to the sum of     elements at higher indexes
    //Input: 		A[] = {-7, 1, 5, 2, -4, 3, 0}
    //Output: 	3
    //Input: 		A[] = {1, 2, 3}
    //Output:	 -1


    //Given a string s consisting only of characters a, b and c. Return the number of substrings containing at least one occurrence of all these characters a, b and c
    //.
    //--> abc
    // a, ab,abc,b,bc,c ---> 1
    //Input: s = "abcabc"
    //Output: 10
    //Input: s = "aaacb"
    //Output: 3

    public static  int numberOfSubString(String str){
         int ans =0;

        for(int i=0;i<str.length();i++){
            for(int j =i;j<str.length();j++){
                String s= str.substring(i,j+1);
                if(s.indexOf('a') !=-1 && s.indexOf('b') !=-1 && s.indexOf('c') !=-1){
                    ans++;
                }
            }
        }
        System.out.println("Ans : "+ans);
        return ans;
    }

    public static int equalPartition(int[] arr){
        int n = arr.length;
        //int[] lsum = new int[n];
       // int[] rSum = new int[n];
       int lsum=0;
       int rsum =0;
       int i=0;
       int j=n-1;

       while(i<j){
           lsum+=arr[i];
           rsum+=arr[j];
           if(lsum==rsum){
              // System.out.println("Lsum = "+lsum+" , i= "+i);
               return i+1;
           }
           i++;
           j--;
       }


        /*
        rSum[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rSum[i]= rSum[i+1]+arr[i];
        }

        for(int i=0;i<n;i++){
            if(lsum[i]==rSum[i]){
                return i;
            }
        }

         */
        return -1;
    }

    public static void main(String[] args) {
        numberOfSubString("abc");

       // System.out.println(equalPartition(new int[]{-7, 1, 5, 2, -4, 3, 0}));

        //System.out.println(equalPartition(new int[]{1,2,3}));
    }
}
