package mathPattern;

public class Reverse_lc007 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // 在做*10的操作时可能溢出，所以可以用逆运算做验证
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // 每次取最后一位，然后推入到前边
            int num = x % 10;
            x /= 10;
            result = result * 10 + num;
        }
        return result;
    }
}
