public class ProductOfArrayExceptSelf {
    /**
     * Problem Link:https://leetcode.com/problems/product-of-array-except-self
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int arrLen = nums.length;
        if(arrLen == 1){
            return nums;
        }

        int[] leftCumProduct = new int[arrLen];
        leftCumProduct[0] = nums[0];
        for (int indx = 1; indx < arrLen; indx++){
            leftCumProduct[indx] = leftCumProduct[indx - 1] * nums[indx];
        }

        int[] rightCumProduct = new int[arrLen];
        rightCumProduct[arrLen - 1] = nums[arrLen - 1];
        for (int indx = arrLen -2; indx > 0; indx--){
            rightCumProduct[indx] = rightCumProduct[indx + 1] * nums[indx];
        }

        nums[0] = rightCumProduct[1];
        nums[arrLen - 1] = leftCumProduct[arrLen -2];
        for (int indx = 1; indx < arrLen -1; indx++) {
            nums[indx] = leftCumProduct[indx - 1] * rightCumProduct[indx + 1];
        }

        return nums;
    }
}
