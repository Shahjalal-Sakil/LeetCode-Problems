public class ShortestUnsortedContigousSubArr {
    /**
     * Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int arrLen = nums.length;
        if(arrLen == 1){
            return 0;
        }
        int rightMinIndex = 0;
        int maxFound = Integer.MIN_VALUE;
        for (int indx = 0; indx < arrLen; indx++){
           maxFound = nums[indx] > maxFound ? nums[indx] : maxFound;
           if (nums[indx] < maxFound){
               rightMinIndex = indx;
           }
        }
        if(rightMinIndex == 0){
            return 0;
        }
        int leftMaxIndx = arrLen - 1;
        int minFound = Integer.MAX_VALUE;
        for (int indx = arrLen - 1; indx >= 0; indx--){
            minFound = nums[indx] < minFound ? nums[indx] : minFound;
            if( nums[indx] > minFound){
                leftMaxIndx = indx;
            }
        }
        return rightMinIndex - leftMaxIndx + 1;
    }
}
