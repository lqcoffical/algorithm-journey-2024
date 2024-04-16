package quickSelect;

public class FindKthLargest_lc215 {

    public int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    // 如果排序arr的话，在i位置的数字是什么
    // i就是我们想要求的，length-k的位置，但是标准值是我们随机出来的，所以按照标准值排序完，可能没有锁定i位置
    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
            // 因为左右两侧只需要走一测，所以不用临时变量记录全局变量first、last
            if (i < first) {
                r = first - 1;
            } else if (i > last) {
                l = last + 1;
            } else {
                // 意思是如果有多个值一样，而且i夹在first和last内，那么这个值就是第k大
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    public static int first;
    public static int last;

    public static void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(arr, first++, i++);
            } else {
                swap(arr, i, last--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
