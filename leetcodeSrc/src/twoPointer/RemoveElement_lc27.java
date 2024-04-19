package twoPointer;

public class RemoveElement_lc27 {
    public int removeElement(int[] nums, int val) {
        // 相当于向前覆盖，直接生成新数组
        // 这个要定义在for外面，要是在for里面，作用域只在for循环里，后面就拿不到
        int slow=0;
        for(int fast=0; fast<nums.length; fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
