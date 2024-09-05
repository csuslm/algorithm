package scn1.algh.hash;

import java.util.HashSet;
import java.util.Set;

public class HashTableTopics {
    public Boolean isAnagram(String s, String t) {
        int[] dic = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dic[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            dic[t.charAt(i) - 'a']--;
        }
        for (int i : dic) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 快乐数
     *
     * @param n
     * @return
     * @Tips 循环计算平方和 如果哈希表中有记录过的值则说明会循环返回f 如果结果为1了返回t
     */
    public Boolean happyNumber(int n) {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        int tempSum = 0;
        while (sum != 1 && !set.contains(sum)) {
            set.add(sum);
            while (sum != 0) {
                int tmp = sum % 10;
                tempSum += tmp * tmp;
                sum /= 10;
            }
            sum = tempSum;
            tempSum = 0;
        }
      return sum == 1;
    }




}
