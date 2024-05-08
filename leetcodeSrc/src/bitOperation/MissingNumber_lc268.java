package bitOperation;

public class MissingNumber_lc268 {
    public int missingNumber(int[] nums) {
        // 整体的异或和是x，其中一部分的异或和是y，剩下部分的异或和是x^y
        int eorAll = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            // 异或范围上所有的数
            eorAll ^= i;
            // 只异或数组中存在的
            eorHas ^= nums[i];
        }
        // 别忘了数组中最后一个下标的数字
        eorAll ^= nums.length;
        return eorAll ^ eorHas;
    }
}
