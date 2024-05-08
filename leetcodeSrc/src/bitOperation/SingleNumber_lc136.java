package bitOperation;

public class SingleNumber_lc136 {

    public int singleNumber(int[] nums) {
        // n^n=0 n^0=n
        // 偶数次的n异或后都消没了，奇数次的异或后肯定还剩一个，所以最后剩下奇数次的
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }

}
