package containers;

public class IsAnagram_lc242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sData = new int[26];
        int[] tData = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        // 可以用增强for循环，快
        for (int i = 0; i < sCharArray.length; i++) {
            sData[sCharArray[i] - 'a']++;
            tData[tCharArray[i] - 'a']++;
        }
        for (int i = 0; i < sData.length; i++) {
            if (sData[i] != tData[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "nl";
        String t = "cx";
        new IsAnagram_lc242().isAnagram(s,t);
    }
}
