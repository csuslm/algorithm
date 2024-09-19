package scn1.algh.string;

import java.util.Arrays;

public class StringTopics {
    public static void main(String[] args) {
        reverseWords("   hello world   ");
    }

    /**
     * 反转数组
     *
     * @param str
     * @return
     * @Tips 毫无疑问，一定是双指针（一次遍历）
     */
    public char[] reverseString(String str) {
        char[] strCharArray = str.toCharArray();
        int l = 0;
        int r = strCharArray.length - 1;
        while (l <= r) {
            char tmp = strCharArray[l];
            strCharArray[l] = strCharArray[r];
            strCharArray[r] = tmp;
            l++;
            r--;
        }
        return strCharArray;
    }

    /**
     * @param str
     * @param k
     * @return
     */
    public String reverseStrII(String str, int k) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i += 2 * k) {
            int slow = i;
            int end = Math.min(slow + k - 1, charArray.length - 1);
            while (slow < end) {
                char temp = charArray[slow];
                charArray[slow] = charArray[end];
                charArray[end] = temp;

                slow++;
                end--;
            }
        }
        return Arrays.toString(charArray);
    }

    public String turnStrToNumberStr(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                sb.append("number");
            } else {
                sb.append(c);
            }
        }
        return new String(sb);
    }

    /**
     * 反转字符串中的单词
     * todo 目前时间复杂度是n2 貌似可以降到n 可以再尝试一下
     *
     * @param s
     * @return
     * @Tips
     */
    public String reverseWordsInString(String s) {
        StringBuilder sb = new StringBuilder();
        int flag = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!s.substring(i + 1, flag).isEmpty()) {
                    sb.append(s, i + 1, flag).append(" ");
                }
                flag = i;
            }
            if (i == 0 && !s.substring(i, flag).isEmpty()) {
                sb.append(s, i, flag);
            }
        }
        return new String(sb);
    }

    /**
     * 字符串右旋转
     *
     * @param s
     * @return
     * @Tips 使用StringBuilder的方法，比较好想 O（n2）
     * @Tips 使用分段逆转的方法，因为现在可以将逆转的时间复杂度做到O(n) 那么逆转动作的叠加就全部都是O（N）
     */
    public String rightSwing(String s, int k) {
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, s.length() - 1);
        reverse(charArray, 0, k - 1);
        reverse(charArray, k, s.length() - 1);
        return new String(charArray);
    }

    /**
     * 异或运算的交换方式 a^b=c可以推出 c^a=b c^b=a
     */
    public static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            chars[l] ^= chars[r];
            chars[r] ^= chars[l];
            chars[l] ^= chars[r];
            l++;
            r--;
        }
    }

    /**
     * 实现strStr()
     * 双指针的问题在于，字符串不匹配时，肯定是要从头进行遍历了 时间复杂度时n2
     * 使用KMP算法，原理在于使用前缀表找到回调的位置，继续遍历，不需要从头遍历
     * 使用前缀表，公共前后缀可以帮助减少重复的判断（公共前后缀长度的判断），该表记录了字串和模式串匹配失败
     * 字串该回溯到什么位置 直接返回到前一位的next数组保存的值即可，因为记录的时前后缀长度嘛，前缀就是从字串头开始的长度
     * todo 计算next数组的过程还需要捋一下
     */
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(needle, next);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }

    /**
     * 获取前缀数表，next数组
     * 一定要明确，i，j指向的都是前缀和后缀的末尾
     *
     * @param needle
     * @return
     */
    public void getNext(String needle, int[] next) {
        int j = 0;
        next[0] = j;
        //从1开始，向后遍历，与j+1位比较
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j + 1) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;//将相同前后缀的长度赋值给next[i]
        }
    }


    /**
     * 反转字符串中的单词
     */
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("") && !s1[i].isEmpty()) {
                sb.append(s1[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return new String(sb);
    }

}
