class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        products[0] = 1;
        int currProduct = nums[0];

        for(int i = 1; i < nums.length; i++) {
            products[i] = currProduct;
            currProduct *= nums[i];
        }

        currProduct = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            products[i] *= currProduct;
            currProduct *= nums[i];
        }

        return products;
    }
}  
