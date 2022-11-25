package Practice.binarySearch;

//Input: nums = [1,3,5,6], target = 5
//Output: 2

//Input: nums = [1,3,5,6], target = 2
//Output: 1

//Input: nums = [1,3,5,6], target = 7
//Output: 4
public class SearchInsertPosition {
    //https://leetcode.com/problems/search-insert-position/

    public static int searchInsert(int[] nums, int target) {
        int low =0;
        int high =nums.length-1;
        int mid =0;

        while(low<=high){
            mid = low + (high-low)/2;

            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }
}
